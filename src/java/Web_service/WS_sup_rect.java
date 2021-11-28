/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web_service;

import com.mysql.cj.xdevapi.Type;
import dao.stock.persImpli2;
import initiationjee.com_reactivation;
import initiationjee.dao.persImpli;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author serv-web
 */
@WebServlet(name = "Wsrec", urlPatterns = {"/api/des:re_activation"})
public class WS_sup_rect extends HttpServlet {

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
            out.println("<title>Servlet up_rect</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet up_rect at " + request.getContextPath() + "</h1>");
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
            String type = (String) jsonObject.get("type");
            int telephone1 = Integer.parseInt(telephone);
            int l =telephone.length();
            int msg=0;
            if (telephone1< 70000000 || telephone1 > 79999999){
                   msg=4;
               }else{
               if(type.equals("2")){
             msg= pay(telephone,type); }
               else if(type.equals("1")){
             msg= susp(telephone,type); }
               else{
               msg = 5;
               }
               
                   
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

    
   public int pay(String m,String j) {
       int k=0;
    String log=null;
        String nb=null;
         String mac=null;
    int o=Integer.parseInt(m);
                 persImpli2 login = new persImpli2();
                 mac=login.rech_login(o);
                 
    com_reactivation test = new com_reactivation();

        test.initSession();
           nb= test.runCommand("nl /etc/freeradius/users |grep "+ mac +" |awk '{print $1}'");
          test.disconnectSession();
          if ((nb!=null)&&(mac!=null)){
        Connection connection;
        Statement statement;

        // R�cup�ration des donn�es depuis le fichier excel
        

        DateTimeFormatter datetime=DateTimeFormatter.ofPattern("yyy/MM/dd:HH:mm:ss");
        LocalDateTime now =LocalDateTime.now();
        String date=datetime.format(now);
        String action ="reactivation";        
        String type=j;
        persImpli rect = new persImpli();
        rect.ajout_rectivation(log,action,m,date,type);
       // rect.ver_client();

       int i= rect.ligne_couppure();
       i=i*30;
       i=i/60;
       k=2;
}else{
              String msg="client n'est pas suspendu";
              k=3;
        
}
                
        return k;
       } 
   public int susp(String m,String j) {
       int k=0;
    String log=null;
        String nb=null;
         String mac=null;
    int o=Integer.parseInt(m);
                 persImpli2 login = new persImpli2();
                 mac=login.rech_login(o);
                 
    com_reactivation test = new com_reactivation();

        test.initSession();
           nb= test.runCommand("nl /etc/freeradius/users |grep "+ mac +" |awk '{print $1}'");
          test.disconnectSession();
          if ((nb==null)&&(mac!=null)){
        Connection connection;
        Statement statement;

        // R�cup�ration des donn�es depuis le fichier excel
        

        DateTimeFormatter datetime=DateTimeFormatter.ofPattern("yyy/MM/dd:HH:mm:ss");
        LocalDateTime now =LocalDateTime.now();
        String date=datetime.format(now);
       String action ="reactivation";
              
        String type=j;
        persImpli rect = new persImpli();
        rect.ajout_rectivation(log,action,m,date,type);
       // rect.ver_client();

       int i= rect.ligne_couppure();
       i=i*30;
       i=i/60;
       k=2;
}else{
              String msg="client est déja suspendu";
              k=3;
        
}
                
        return k;
       } 
    }


