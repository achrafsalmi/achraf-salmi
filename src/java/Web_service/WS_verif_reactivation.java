/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web_service;

import dao.stock.persImpli2;
import initiationjee.com_reactivation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "Wsrec", urlPatterns = {"/api/verif_suspension"})
public class WS_verif_reactivation extends HttpServlet {

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
            out.println("<title>Servlet WS_verif_reactivation</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet WS_verif_reactivation at " + request.getContextPath() + "</h1>");
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
           
            String telephone = (String) jsonObject.get("telephone");
            int telephone1 = Integer.parseInt(telephone);
            int l =telephone.length();
            int msg=0;
            if (telephone1< 70000000 || telephone1 > 79999999){
                   msg=4;
               }else{
               msg=verif_suspension(telephone);
               
                   
               }
                    
           obj.put("message", msg);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(obj.toString());
               
               
               
            
            
        } catch (Exception e) {
            // crash and burn
            throw new IOException("Error parsing JSON request string");
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

    public int verif_suspension(String telephone){
        int r;
        String nb=null;
         String mac=null;
    int o=Integer.parseInt(telephone);
                 persImpli2 login = new persImpli2();
                 mac=login.rech_login(o);
                 
    com_reactivation test = new com_reactivation();

        test.initSession();
           nb = test.runCommand("nl /etc/freeradius/users |grep "+ mac +" |awk '{print $1}'");
          test.disconnectSession();
          if (mac !=null){
          if(nb!=null){
          r=0;
          }else{
          r=1;
          }
          }else{
          r=2;
          }
        
        
        return r;
    }
}

