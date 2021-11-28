/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web_service;

import connexion.connection_radius;
import initiationjee.SSHConnectionJava;
import initiationjee.SSHConnectionJava1ava1;
import initiationjee.dao.persImpli;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author serv-web
 */
@WebServlet(name = "WsActivation", urlPatterns = {"/api/verif_1cnx"})
public class api_1er_cnx extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet api_1er_cnx</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet api_1er_cnx at " + request.getContextPath() + "</h1>");
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

    public ArrayList<String> vérif_1er(String mac)  {
ArrayList<String> r=new ArrayList<String>();
        String sql = "select framedipaddress,acctstarttime from radacct where username= '" + mac + "' order by radacctid asc limit 1 ";
        ResultSet res1;

        PreparedStatement ps;
        try {
            ps = connection_radius.getConnection().prepareStatement(sql);
        
        res1 = ps.executeQuery();
        
        while (res1.next()) {
            String histo, stop = null;
            histo = res1.getString("acctstarttime");
            stop = res1.getString("framedipaddress"); 
            r.add(histo);
            r.add(stop);
        }
        } catch (SQLException ex) {
            Logger.getLogger(api_1er_cnx.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    } 
}
