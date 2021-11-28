package initiationjee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import connexion.connection;
import dao.stock.persImpli2;
import initiationjee.dao.persImpli;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class susp_par11 extends HttpServlet {

   

    //utiliser pour tout la pqge 
    public String susp(String n,String mac) {
        String m;

        
        Connection connection;
        Statement statement;

        // R�cup�ration des donn�es depuis le fichier excel
        

        
        String nb=null;
        int i, j;
        connection con = new connection();
String msg="";
        persImpli rech = new persImpli();
        i = rech.rechip1();
        j = rech.rechip2();
       
        rad_rec ssh5 = new rad_rec();
        ssh5.initSession();
        if (i >= 254) {
            i = 1;
            j = j + 1;
        } else if (i <= 254) {
            i = i + 1;
        }
        int o=Integer.parseInt(n);
                 persImpli2 login = new persImpli2();
                 mac=login.rech_login(o);
             SSHConnectionJava ssh3 = new SSHConnectionJava();
        com_reactivation test = new com_reactivation();

        test.initSession();
           nb= test.runCommand("nl /etc/freeradius/users |grep "+ mac +" |awk '{print $1}'");
          test.disconnectSession();
              if(nb==null)  { 
        //déclaration 
        String b3 = "" + n + "\n";
        String b22 = "" + mac + "              Auth-Type := CHAP\n";
        String b23 = "Service-Type = Framed,";
        String b24 = "Framed-Protocol = PPP,\n";
        String b25 = "Framed-IP-Address = 10.100." + j + "." + i + ",\n";
        String b26 = "Framed-IP-Netmask = 255.255.255.255\n";
//ajout in users
        m = ssh5.runCommand1("sed -i '1i#" + b3 + "'   /etc/freeradius/users ");
        m = ssh5.runCommand1("sed -i '2i" + b22 + "'   /etc/freeradius/users ");
        m = ssh5.runCommand1("sed -i '3i\\              \\" + b23 + "' /etc/freeradius/users ");
        m = ssh5.runCommand1("sed -i '4i\\              \\" + b24 + "' /etc/freeradius/users ");
        m = ssh5.runCommand1("sed -i '5i\\              \\" + b25 + "' /etc/freeradius/users ");
        m = ssh5.runCommand1("sed -i '6i\\               \\" + b26 + "' /etc/freeradius/users ");
//ajout in users ~
        m = ssh5.runCommand1("sed -i '1i#" + b3 + "'   /etc/freeradius/users~ ");
        m = ssh5.runCommand1("sed -i '2i" + b22 + "'   /etc/freeradius/users~ ");
        m = ssh5.runCommand1("sed -i '3i\\              \\" + b23 + "' /etc/freeradius/users~ ");
        m = ssh5.runCommand1("sed -i '4i\\              \\" + b24 + "' /etc/freeradius/users~ ");
        m = ssh5.runCommand1("sed -i '5i\\              \\" + b25 + "' /etc/freeradius/users~ ");
        m = ssh5.runCommand1("sed -i '6i\\               \\" + b26 + "\n' /etc/freeradius/users~ ");

        persImpli update = new persImpli();
        update.updpers(i, j);
        rad_java ssh6 = new rad_java();
        m = ssh6.sh(mac);
        
     
        String g;
        String k=null;
        String vi=null;
        
        
        k = ssh3.sh(mac);
        if (k==null){
        SSHConnectionJava1ava1 ssh4 = new SSHConnectionJava1ava1();
        k = ssh4.sh(mac);}
        if (k!=null){
        int l =k.length();
        for(int l1=4 ;l1<l;l1++){
        char s=k.charAt(l1);
        char a=' ';
       
         if (s==a){
             l=l1;
              vi=k.substring(0, l1);
         }
        }
        vi=vi.replace("Vi", "");
        SSHConnectionJava1av3 ssh = new SSHConnectionJava1av3();
        g = ssh.sh(vi);
        SSHConnectionJava3 ssh1 = new SSHConnectionJava3();
        g = ssh1.sh(vi);
        msg="suspension ok";
        update.ajout_coupure(n, msg);
        }
        else{
        msg="client n'est pas connecté";
        }
        } else{
        msg="client est déja suspendu";
        }
        return msg;
        
    }
}
