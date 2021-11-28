/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radius_action;

import connexion.connection_radius;
import dao.stock.persImpli2;
import initiationjee.com_reactivation;
import initiationjee.dao.persImpli;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author serv-web
 */
public class modif_radius extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet modif_radius</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet modif_radius at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String log = null;
        try {
            log = request.getSession().getAttribute("login").toString();
            if (log != null) {
                
         String id = request.getParameter("id");
         String telephone= request.getParameter("telephone");
         String bt= request.getParameter("modif");
         if(bt.equals("actualiser")){
                String msg = "select * from Bee_net_tn WHERE `attribute` NOT LIKE 'Calling-Station-Id' AND `telephone` LIKE '%"+telephone+"%' OR `Login` LIKE '%"+telephone+"%' OR `Nom` LIKE '%"+telephone+"%' OR `CIN` LIKE '%"+telephone+"%'";
                        request.setAttribute("msg", msg);
             request.getRequestDispatcher("radius_bee_net.jsp").forward(request, response);
            }else if(bt.equals("actualiser info")){
               String msg = "select * from Bee_net_tn WHERE `attribute` NOT LIKE 'Calling-Station-Id' AND `telephone` LIKE '%"+telephone+"%' OR `Login` LIKE '%"+telephone+"%' OR `Nom` LIKE '%"+telephone+"%' OR `CIN` LIKE '%"+telephone+"%'";
                        request.setAttribute("msg", msg);
             request.getRequestDispatcher("radius_bee_net_com.jsp").forward(request, response);
            }else if(bt.equals("actualiser_info")){
               String msg = "select * from Bee_net_tn WHERE `attribute` NOT LIKE 'Calling-Station-Id' AND `telephone` LIKE '%"+telephone+"%' OR `Login` LIKE '%"+telephone+"%' OR `Nom` LIKE '%"+telephone+"%' OR `CIN` LIKE '%"+telephone+"%'";
                        request.setAttribute("msg", msg);
             request.getRequestDispatcher("radius_bee_net_recv.jsp").forward(request, response);
            }
         else if(bt.equals("modification")){
            String msg = "select * from Bee_net_tn WHERE `attribute` NOT LIKE 'Calling-Station-Id' AND `telephone` LIKE '%"+telephone+"%' OR `Login` LIKE '%"+telephone+"%' OR `Nom` LIKE '%"+telephone+"%' OR `CIN` LIKE '%"+telephone+"%'";
                        request.setAttribute("msg", msg);
             request.getRequestDispatcher("radius_bee_net_2.jsp").forward(request, response);
         }else if(bt.equals("validation")){
         String Nom= request.getParameter("Name");
         
         String Login= request.getParameter("Login");
         String value= request.getParameter("value");
         String groupname= request.getParameter("groupname");
         String CIN= request.getParameter("CIN");
         String IPADDRESS= request.getParameter("IPADDRESS");
         String Login1= request.getParameter("Login1");
         String value1= request.getParameter("value1");
         String groupname1= request.getParameter("groupname1");
         String CIN1= request.getParameter("CIN1");
         String IPADDRESS1= request.getParameter("IPADDRESS1");
         String Nom1= request.getParameter("Nom1");
         persImpli2 pers=new persImpli2();
         com_reactivation test = new com_reactivation();

                                test.initSession();

                                String nb = null;
                                String susp;

                                nb = test.runCommand("nl /etc/freeradius/users |grep " + telephone + " |awk '{print $1}'");

                                if (nb != null) {
                                    String msg="client n'est pas modifié client suspendu";
                                    request.setAttribute("msg", telephone);
                                    request.getRequestDispatcher("test.jsp").forward(request, response);
                                } else {
                                   persImpli pers1 = new persImpli();
                DateTimeFormatter datetime = DateTimeFormatter.ofPattern("yyy/MM/dd:HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                String date = datetime.format(now);
                
                
                pers1.ajout_action_radius(log, "mofidier", telephone, date,Nom1,Login1,value1,CIN1,IPADDRESS1,groupname1);
                System.out.println("erreur");
        pers.update_radius(id, Nom, telephone, Login, value, groupname, CIN, IPADDRESS); 
        String msg = "select * from Bee_net_tn WHERE `attribute` NOT LIKE 'Calling-Station-Id' AND `telephone` LIKE '%"+telephone+"%' OR `Login` LIKE '%"+telephone+"%' OR `Nom` LIKE '%"+telephone+"%' OR `CIN` LIKE '%"+telephone+"%'";
                        request.setAttribute("msg", msg);
                        String bee="client modifié avec succés";
                        request.setAttribute("bee", bee);
             request.getRequestDispatcher("radius_bee_net.jsp").forward(request, response);

                                }        
    }}else {

                request.getRequestDispatcher("I_acceuil.jsp").forward(request, response);
            }

        } catch (Exception e) {
             e.printStackTrace();
             System.out.println("class");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
