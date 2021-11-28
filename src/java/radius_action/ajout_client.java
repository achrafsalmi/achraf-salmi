/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radius_action;

import connexion.connection_radius;
import dao.stock.persImpli2;
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
public class ajout_client extends HttpServlet {

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
            out.println("<title>Servlet ajout_client</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ajout_client at " + request.getContextPath() + "</h1>");
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
                String Nom = request.getParameter("Nom");
                String telephone = request.getParameter("telephone");
                String Login = request.getParameter("Login");
                String value = request.getParameter("value");
                String CIN = request.getParameter("CIN");
                String groupname = request.getParameter("groupname");
                if(groupname.equals("Adsl")){
                    groupname="Bee.net.tn";
                }else{
                    groupname="VBee.net.tn";
                }
                int telephone1 = Integer.parseInt(telephone);
                persImpli2 pers = new persImpli2();
                pers.ajout_radius(Nom, telephone1, Login, value, CIN, groupname);
                persImpli pers1 = new persImpli();
                DateTimeFormatter datetime = DateTimeFormatter.ofPattern("yyy/MM/dd:HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                String date = datetime.format(now);
                
                pers1.ajout_action_radius(log, "ajout", telephone, date,Nom,Login,value,CIN,"",groupname);
                String msg = "select * from Bee_net_tn WHERE `attribute` NOT LIKE 'Calling-Station-Id' AND `telephone` LIKE '%" + telephone1 + "%' ";
                request.setAttribute("msg", msg);
                request.getRequestDispatcher("radius_bee_net.jsp").forward(request, response);
            } else {

                request.getRequestDispatcher("I_acceuil.jsp").forward(request, response);
            }

        } catch (Exception e) {
            request.getRequestDispatcher("I_acceuil.jsp").forward(request, response);
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
