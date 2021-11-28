package initiationjee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import connexion.connection;
import dao.stock.persImpli2;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class rech_stock12 extends HttpServlet {

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
        String m, s, b;
        String n = req.getParameter("mac");
        String log =null;
                try{
                    log = req.getSession().getAttribute("login").toString();
if (log!=null){
        persImpli2 rech = new persImpli2();
        s = rech.rechsn(n);
        System.out.println(s);
        req.setAttribute("name1", s);
        req.setAttribute("name", n);
        req.getRequestDispatcher("page_mobile.jsp").forward(req, resp);
}
else{
              req.getRequestDispatcher("I_acceuil.jsp").forward(req, resp);  
                }
                
               } catch (Exception e) {
            req.getRequestDispatcher("I_acceuil.jsp").forward(req, resp);
        }
    }
}
