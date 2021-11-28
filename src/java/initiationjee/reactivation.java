package initiationjee;
import dao.stock.persImpli2;
import initiationjee.dao.persImpli;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class reactivation extends HttpServlet {
	@Override
	//utiliser pour avec url paterne 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String n =req.getParameter("cle");
		req.setAttribute("cle21", n);
		req.getRequestDispatcher("recup.jsp").forward(req, resp);
	}
	@Override
	//utiliser pour tout la pqge 
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
String m,d,d1;
String msg=null;
String log =null;
                try{
                    log = req.getSession().getAttribute("login").toString();
if (log!=null){
		String n =req.getParameter("bee_rec");
                String tel_adsl=n;
                  persImpli update = new persImpli();
                 int o=Integer.parseInt(n);
                 persImpli2 login = new persImpli2();
                 n=login.rech_login(o);
                 if (n!=null){
                
		 com_reactivation test = new com_reactivation();

        test.initSession();
        
        String nb =null;
        
       //   /etc/freeradius/users
        //home/radius/Desktop/test
            //test ajout users radius
        //283B82xA7B7F
          nb= test.runCommand("nl /etc/freeradius/users |grep "+ n +" |awk '{print $1}'");
         if (nb!=null){
  
          String nb1=nb.replaceAll("\n","");
           int i=Integer.parseInt(nb1);
           
          
         int ll1=i-1;
         int ll2=i+4;
       
          System.out.println(ll1);
          System.out.println(ll2);
        // test.runCommand("sed -i  '1i\\        \\"+b+" ' /home/radius/Desktop/test");
        ///etc/freeradius/users
         //test.runCommand("sed -i -e '"+ l1 +","+ l2 +"d' home/radius/Desktop/test");
        
       
         
          // System.out.println(k);
           
          // b=k.replaceAll("\n","");
          // int i=Integer.parseInt(b);
           
          // System.out.println(k);
          
         //int l1=i-1;
         //int l2=i+4;
              d=test.runCommand("sed -i -e '"+ ll1 +","+ ll2 +" d' /etc/freeradius/users");
               
           //   ------------------------------------------- 
               //
              
             d1=test.runCommand("sed -i -e '"+ ll1 +","+ ll2 +" d' /etc/freeradius/users~");
               
            rad_java ssh10 = new rad_java();
		m=ssh10.sh(n);
             String g;
        String k=null;
        String vi=null;
        
        SSHConnectionJava ssh3 = new SSHConnectionJava();
        k = ssh3.sh(n);
        if (k==null){
        SSHConnectionJava1ava1 ssh4 = new SSHConnectionJava1ava1();
        k = ssh4.sh(n);}
        
        int l =k.length();
        for(int l1=4 ;l1<l;l1++) {
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
        update.delet_coupure(tel_adsl);

        msg = ssh3.sh(n);
        if (msg==null){
        SSHConnectionJava1ava1 ssh4 = new SSHConnectionJava1ava1();
        msg = ssh4.sh(n);}
        
                 test.disconnectSession();
                 }else msg="pas de PB de suspension" ;
                 }else msg="vérifier le num fix";
		req.setAttribute("msg", msg);
		req.getRequestDispatcher("ajout.jsp").forward(req, resp);
		}
else{
              req.getRequestDispatcher("I_acceuil.jsp").forward(req, resp);  
                }
                
               } catch (Exception e) {
            req.getRequestDispatcher("I_acceuil.jsp").forward(req, resp);
        }
		
		}
}
