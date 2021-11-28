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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

public class susp_par1 extends HttpServlet {

    @Override
    //utiliser pour avec url paterne 
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub

    }

    @Override
    //utiliser pour tout la pqge 
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String n = req.getParameter("bee_rec2");
         String log=null;
         String nb=null;
         String mac=null;
        try{
log = req.getSession().getAttribute("login").toString();
} catch (Exception e) {
            log=null;
        }
if (log==null){
              req.getRequestDispatcher("I_acceuil.jsp").forward(req, resp);  
                }
else{
    int o=Integer.parseInt(n);
                 persImpli2 login = new persImpli2();
                 mac=login.rech_login(o);
    com_reactivation test = new com_reactivation();

        test.initSession();
           nb= test.runCommand("nl /etc/freeradius/users |grep "+ mac +" |awk '{print $1}'");
          test.disconnectSession();
          if ((nb==null)&&(mac!=null)){
    DateTimeFormatter datetime=DateTimeFormatter.ofPattern("yyy/MM/dd:HH:mm:ss");
        LocalDateTime now =LocalDateTime.now();
        String date=datetime.format(now);
        String action ="suspension";
        String type="1";
        persImpli rect = new persImpli();
        rect.ajout_rectivation(log, action, n, date, type);
        String msg="suspension ok";
        req.setAttribute("msg", msg);
        req.getRequestDispatcher("S_recv_acc.jsp").forward(req, resp);
     }
else{
              String msg="client est déja suspendu ";
        req.setAttribute("msg", msg+mac+nb);
        req.getRequestDispatcher("ajout.jsp").forward(req, resp);
}}}
}
