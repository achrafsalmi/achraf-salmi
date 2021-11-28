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
public class deconnexion extends HttpServlet {
	@Override
	//utiliser pour avec url paterne 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

                    req.getSession().invalidate();
              req.getRequestDispatcher("I_acceuil.jsp").forward(req, resp);  
                
                
                }
	
	@Override
	//utiliser pour tout la pqge 
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

}}
