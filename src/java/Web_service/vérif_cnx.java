/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web_service;

import connexion.connection;
import connexion.connection_radius;
import initiationjee.SSHConnectionJava;
import initiationjee.SSHConnectionJava1ava1;
import initiationjee.dao.persImpli;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author serv-web
 */
@WebServlet(name = "WsActivation", urlPatterns = {"/api/verif_cnx"})
public class vérif_cnx extends HttpServlet {

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
            out.println("<title>Servlet vérif_cnx</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet vérif_cnx at " + request.getContextPath() + "</h1>");
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
        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }
        } catch (Exception e) { /*report an error*/ }

        try {
            JSONObject obj = new JSONObject();
            obj.put("success", true);
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(jb.toString());
            String tel = (String) jsonObject.get("tel");
            int r= vérif(tel);
            
            obj.put("r", r);
           obj.put("tel", tel);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(obj.toString());
            } catch (Exception e) {
            // crash and burn
            throw new IOException(e);
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
    public int vérif(String tel) throws SQLException{
SSHConnectionJava ssh = new SSHConnectionJava();
int r=0;
//cnx basse exc query
String msg = "SELECT Login FROM `Bee_net_tn` WHERE `telephone` LIKE '%"+tel+"%' AND `attribute` NOT LIKE 'Calling-Station-Id'";
persImpli ps = new persImpli();
                ResultSet res = null;
                connection_radius conn = null;
                PreparedStatement ps1 = conn.getConnection().prepareStatement(msg);
                res = ps1.executeQuery(msg);
                //vérif cnx
                String n=null;
                while (res.next()) {
                    //recupération mac id
                    n= res.getString("Login");
                }
                //vérification connexion wardiya
                        String m = ssh.sh(n);
                        String j = "LNS ouardia" + m;
                        //vérification connexion bélvidére
                        System.out.println(m);
                        if (m == null || m.isEmpty() || m.equals(' ')) {
                            SSHConnectionJava1ava1 ss = new SSHConnectionJava1ava1();
                            m = ss.sh(n);
                            j = "LNS bélvédére" + m;
                        }
                        //condition client connecter 
                        if (j.contains("Vi2.")) {
                        r=1;
                        } 
                        //condition client non connecter 
                        else {
                            r=0;
                                } 
        return r;
    }
}
