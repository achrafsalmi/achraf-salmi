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

public class clear_inter extends HttpServlet {

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
        String k=null;
        String n = req.getParameter("macid");
        String telephone= req.getParameter("telephone");
        String cnx= req.getParameter("cnx");
        System.out.println("test");
        String vi=null;
        String log =null;
                try{
                    log = req.getSession().getAttribute("login").toString();
if (log!=null){
    if(!cnx.equals("client n'est pas connecter")){
        
    
        
    
        SSHConnectionJava ssh3 = new SSHConnectionJava();
        k = ssh3.sh(n);
        System.out.println(k);
        if (k==null || !k.contains("Vi2.")){
        SSHConnectionJava1ava1 ssh4 = new SSHConnectionJava1ava1();
        k = ssh4.sh(n);
            System.out.println(k);
        }
        
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
        SSHConnectionJava1av3 ssh = new SSHConnectionJava1av3();
        m = ssh.sh(vi);
        SSHConnectionJava3 ssh1 = new SSHConnectionJava3();
        m = ssh1.sh(vi);
String msg = "select * from Bee_net_tn WHERE `attribute` NOT LIKE 'Calling-Station-Id' AND `telephone` LIKE '%"+telephone+"%' OR `Login` LIKE '%"+telephone+"%' OR `Nom` LIKE '%"+telephone+"%' OR `CIN` LIKE '%"+telephone+"%'";
                        req.setAttribute("msg", msg);
        req.getRequestDispatcher("radius_bee_net.jsp").forward(req, resp);
 }else{
        String msg = "select * from Bee_net_tn WHERE `attribute` NOT LIKE 'Calling-Station-Id' AND `telephone` LIKE '%"+telephone+"%' OR `Login` LIKE '%"+telephone+"%' OR `Nom` LIKE '%"+telephone+"%' OR `CIN` LIKE '%"+telephone+"%'";
                        req.setAttribute("msg", msg);
        req.setAttribute("bee","client n'est pas connecté");
            req.getRequestDispatcher("radius_bee_net.jsp").forward(req, resp);
    }}
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
