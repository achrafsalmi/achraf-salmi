package mobile;

import user.*;
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

public class rech_lns_tel_mobile extends HttpServlet {

    @Override
    //utiliser pour avec url paterne 
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String n = req.getParameter("cle");
        req.setAttribute("cle21", n);
        req.getRequestDispatcher("recup.jsp").forward(req, resp);
    }

    @Override
    //utiliser pour tout la pqge 
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String m;
        String n=null;
        String msg=null;
         n = req.getParameter("nom");
        String log =null;
                try{
                    log = req.getSession().getAttribute("login").toString();
if (log!=null){
         int b=Integer.parseInt(n);
         persImpli2 login = new persImpli2();
         n=login.rech_login(b);
         if (n!=null){
         SSHConnectionJava ssh = new SSHConnectionJava();
        m = ssh.sh(n);
        req.setAttribute("bee", m);
        SSHConnectionJava1ava1 ss = new SSHConnectionJava1ava1();
        m = ss.sh(n);
        req.setAttribute("bee1", m);
        }else msg="vérifier le num fix";
        req.setAttribute("msg", msg);
        req.getRequestDispatcher("page_mobile.jsp").forward(req, resp);
}
else{
              req.getRequestDispatcher("I_acceuil.jsp").forward(req, resp);  
                }
                
               } catch (Exception e) {
            req.getRequestDispatcher("I_acceuil.jsp").forward(req, resp);
        }
		// TODO Auto-generated method stub
        ///////////////
        /*PrintWriter aff=resp.getWriter();
         String nom=req.getParameter("nom");
		
         aff.println("votre nom est : "+nom);
         resp.sendRedirect("affichage.jsp");*/
		/////////////////////////////////
		//n varialble pour prandre les parametre 
        //String n =req.getParameter("nom");
        //donnee un nom pour l'attribue
        //req.setAttribute("name", n);
        //redirection ver la page conserner 
        //req.getRequestDispatcher("affichage.jsp").forward(req, resp);
    }
}
