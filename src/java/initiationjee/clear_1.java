package initiationjee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import dao.stock.persImpli2;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class clear_1 extends HttpServlet {


    public void clear_interface(String mac) {
        String m;
        String k=null;
        
        String vi=null;
        
        SSHConnectionJava ssh3 = new SSHConnectionJava();
        k = ssh3.sh(mac);
        if (k==null){
        SSHConnectionJava1ava1 ssh4 = new SSHConnectionJava1ava1();
        k = ssh4.sh(mac);}
        
        int i =k.length();
        for(int j=4 ;j<i;j++){
        char s=k.charAt(j);
        char a=' ';
       
         if (s==a){
             i=j;
              vi=k.substring(0, j);
         }
        }
        
        vi=vi.replace("Vi", "");
        System.out.println("clear inter ok");
        SSHConnectionJava1av3 ssh = new SSHConnectionJava1av3();
        m = ssh.sh(vi);
        SSHConnectionJava3 ssh1 = new SSHConnectionJava3();
        m = ssh1.sh(vi);

      

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
