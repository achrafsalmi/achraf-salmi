package authentification;
import initiationjee.*;
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
public class auth_susp extends HttpServlet {
	@Override
	//utiliser pour avec url paterne 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String log =null;
                try{
                    log = req.getSession().getAttribute("login").toString();
if (log!=null){
              req.getRequestDispatcher("rec_susp.jsp").forward(req, resp);  
                }
else{
              req.getRequestDispatcher("I_acceuil.jsp").forward(req, resp);  
                }
                
               } catch (Exception e) {
            req.getRequestDispatcher("I_acceuil.jsp").forward(req, resp);
        }}
	
	@Override
	//utiliser pour tout la pqge 
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

}}
