package initiationjee;

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

public class rech_lns_tel extends HttpServlet {

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
        String m = null;
        String n = null;
        String k = null;
        String o = null;
        String msg2=null,msg = null;
        n = req.getParameter("bt_action");
        m = req.getParameter("identifient");
        
        

        String log = null;
      // try {
            log = req.getSession().getAttribute("login").toString();
            if (log != null) {
                if (m.equals("")) {
                    msg = "vérifier l'identifiant du client";
                    req.setAttribute("msg", msg);
                    req.getRequestDispatcher("test.jsp").forward(req, resp);
                } else {
                    if (n.equals("Recherche_client")){
                        msg = "SELECT * FROM `Bee_net_tn` WHERE `telephone` LIKE '%"+m+"%' AND `attribute` NOT LIKE 'Calling-Station-Id' OR `Login` LIKE '%"+m+"%' AND `attribute` NOT LIKE 'Calling-Station-Id' OR `CIN` LIKE '%"+m+"%' AND `attribute` NOT LIKE 'Calling-Station-Id' OR `Nom` LIKE '%"+m+"%' AND `attribute` NOT LIKE 'Calling-Station-Id'";
                        req.setAttribute("msg", msg);
                        req.getRequestDispatcher("radius_bee_net_acc.jsp").forward(req, resp);
                    }else {
                    if (n.equals("Recherche Client")){
                        msg = "SELECT * FROM `Bee_net_tn` WHERE `telephone` LIKE '%"+m+"%' AND `attribute` NOT LIKE 'Calling-Station-Id' OR `Login` LIKE '%"+m+"%' AND `attribute` NOT LIKE 'Calling-Station-Id' OR `CIN` LIKE '%"+m+"%' AND `attribute` NOT LIKE 'Calling-Station-Id' OR `Nom` LIKE '%"+m+"%' AND `attribute` NOT LIKE 'Calling-Station-Id'";
                        req.setAttribute("msg", msg);
                        req.getRequestDispatcher("radius_bee_net_fact.jsp").forward(req, resp);
                    }
                    else {
                    if (n.equals("Recherche client")){
                        msg = "SELECT * FROM `Bee_net_tn` WHERE `telephone` LIKE '%"+m+"%' AND `attribute` NOT LIKE 'Calling-Station-Id' OR `Login` LIKE '%"+m+"%' AND `attribute` NOT LIKE 'Calling-Station-Id' OR `CIN` LIKE '%"+m+"%' AND `attribute` NOT LIKE 'Calling-Station-Id' OR `Nom` LIKE '%"+m+"%' AND `attribute` NOT LIKE 'Calling-Station-Id'";
                        req.setAttribute("msg", msg);
                        req.getRequestDispatcher("radius_bee_net_com.jsp").forward(req, resp);   
                    }else {
                    if (n.equals("Recherche__client")){
                        msg = "SELECT * FROM `Bee_net_tn` WHERE `telephone` LIKE '%"+m+"%' AND `attribute` NOT LIKE 'Calling-Station-Id' OR `Login` LIKE '%"+m+"%' AND `attribute` NOT LIKE 'Calling-Station-Id' OR `CIN` LIKE '%"+m+"%' AND `attribute` NOT LIKE 'Calling-Station-Id' OR `Nom` LIKE '%"+m+"%' AND `attribute` NOT LIKE 'Calling-Station-Id'";
                        req.setAttribute("msg", msg);
                        req.getRequestDispatcher("radius_bee_net_recv.jsp").forward(req, resp);   
                    }else {
                    if (n.equals("Recherche")){
                    
                        msg = "SELECT * FROM `Bee_net_tn` WHERE `telephone` LIKE '%"+m+"%' AND `attribute` NOT LIKE 'Calling-Station-Id' OR `Login` LIKE '%"+m+"%' AND `attribute` NOT LIKE 'Calling-Station-Id' OR `CIN` LIKE '%"+m+"%' AND `attribute` NOT LIKE 'Calling-Station-Id'OR `Nom` LIKE '%"+m+"%' AND `attribute` NOT LIKE 'Calling-Station-Id' ";
                        
                        req.setAttribute("msg", msg);
                        
                        req.getRequestDispatcher("radius_bee_net.jsp").forward(req, resp);   }
                    else {
                    if (n.equals("Recherche_c")){
                    
                        msg = "SELECT * FROM `Bee_net_tn` WHERE `telephone` LIKE '%"+m+"%' AND `attribute` NOT LIKE 'Calling-Station-Id' OR `Login` LIKE '%"+m+"%' AND `attribute` NOT LIKE 'Calling-Station-Id' OR `CIN` LIKE '%"+m+"%' AND `attribute` NOT LIKE 'Calling-Station-Id'OR `Nom` LIKE '%"+m+"%' AND `attribute` NOT LIKE 'Calling-Station-Id' ";
                        
                        req.setAttribute("msg", msg);
                        
                        req.getRequestDispatcher("radius_client_depl.jsp").forward(req, resp);   }
                    else {
                    if (n.equals("recherche")){
                    
                        msg = "SELECT * FROM `Bee_net_tn` WHERE `telephone` LIKE '%"+m+"%' AND `attribute` NOT LIKE 'Calling-Station-Id' OR `Login` LIKE '%"+m+"%' AND `attribute` NOT LIKE 'Calling-Station-Id' OR `CIN` LIKE '%"+m+"%' AND `attribute` NOT LIKE 'Calling-Station-Id'OR `Nom` LIKE '%"+m+"%' AND `attribute` NOT LIKE 'Calling-Station-Id' ";
                        req.setAttribute("msg", msg);
                        req.getRequestDispatcher("radius_bee_net_RM.jsp").forward(req, resp);   }
                    else if (n.equals("Ajouter client")){
                    persImpli2 pers = new persImpli2();
                    int i=pers.verif_radius(m);
                    if (i==0){
                        req.setAttribute("fix", m);
                    req.getRequestDispatcher("ajout_client.jsp").forward(req, resp);
                    }else {
                       msg="telephone déja existant";
                        req.setAttribute("msg", msg);
                    req.getRequestDispatcher("test.jsp").forward(req, resp);  
                    }
                    }
                }}}}}}}
            } else {

                req.getRequestDispatcher("I_acceuil.jsp").forward(req, resp);
            }

      // } catch (Exception e) {
        //  req.getRequestDispatcher("I_acceuil.jsp").forward(req, resp);
       //}

    }
}
