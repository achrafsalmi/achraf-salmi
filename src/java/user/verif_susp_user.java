package user;
import initiationjee.*;
import initiationjee.*;
import dao.stock.persImpli2;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class verif_susp_user extends HttpServlet {
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
String n=null;
String msg;
		 n =req.getParameter("bee_rec");
              String log =null;
                try{
                    log = req.getSession().getAttribute("login").toString();
if (log!=null){   
                 int o=Integer.parseInt(n);
                 persImpli2 login = new persImpli2();
                 n=login.rech_login(o);
                 
                if (n != null){
		 com_reactivation test = new com_reactivation();

        test.initSession();
        
        String nb =null;
       //   /etc/freeradius/users
        //home/radius/Desktop/test
            //test ajout users radius
        //283B82xA7B7F
          nb= test.runCommand("nl /etc/freeradius/users |grep "+ n +" |awk '{print $1}'");
         
  if(nb!=null){
     msg ="suspendu" ;      }
  else {
  msg ="Pas de PB Suspension";
  
  }
        
                 test.disconnectSession();
                }else{
                    msg="vérifier le tel_adsl";
                    }
                
		req.setAttribute("msg", msg);
		req.getRequestDispatcher("page_client.jsp").forward(req, resp);
		
		}
else{
              req.getRequestDispatcher("I_acceuil.jsp").forward(req, resp);  
                }
                
               } catch (Exception e) {
                   msg="merci de vérifier les champs saisie";
                   req.setAttribute("msg", msg);
            req.getRequestDispatcher("page_client.jsp").forward(req, resp);
        }
		}
}
