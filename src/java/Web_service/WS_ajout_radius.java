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
@WebServlet(name = "WsActivation", urlPatterns = {"/api/ajout_radius"})

public class WS_ajout_radius extends HttpServlet {

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
            out.println("<title>Servlet WS_ajout_radius</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet WS_ajout_radius at " + request.getContextPath() + "</h1>");
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
            String Nom = (String) jsonObject.get("Nom");
            String telephone = (String) jsonObject.get("telephone");
            String SN = (String) jsonObject.get("SN");
            String CIN = (String) jsonObject.get("CIN");
            String Groupname = (String) jsonObject.get("Groupname");
            persImpli2 Rmac = new persImpli2();
            String mac =Rmac.rechmac_webS(SN);
            int k =Rmac.rechmac_id(SN);
            int m= 0;
             if(Groupname.startsWith("ADSL")){
                    Groupname="Bee.net.tn";
                }else if(Groupname.startsWith("VDSL")){
                    Groupname="VBee.net.tn";
                }else{
                m=1;
                }
               
               int l =telephone.length();
               
               if (k==0){
                    String message="3";
           obj.put("message", message);
          
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(obj.toString());
               }else if(m==1){
                    String message="6";
           obj.put("message", message);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(obj.toString());
               }else if (l!=8){
                   String message="4";
           obj.put("message", message);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(obj.toString());
               }else{
                    int telephone1 = Integer.parseInt(telephone);
                    if(telephone1< 70000000 || telephone1 > 79999999){
                    String message="5";
           obj.put("message", message);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(obj.toString());
                    }else{
               int i= Rmac.verif_radius_par_tel(telephone);
               int j= Rmac.verif_radius_par_mac(mac);
               if (i!=0){
                   String message="1";
           obj.put("message", message);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(obj.toString());
               }else if(j!=0){
                   String message="2";
           obj.put("message", message);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(obj.toString()); 
               }else {
                 Rmac.ajout_radius(Nom,telephone1,mac,mac,CIN,Groupname);
            String message="0";
           obj.put("message", message);
           obj.put("login", mac);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(obj.toString());  
               }}}
            
        } catch (Exception e) {
            // crash and burn
            throw new IOException(e);
        }
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
            String Nom = (String) jsonObject.get("Nom");
            String telephone = (String) jsonObject.get("telephone");
            String SN = (String) jsonObject.get("SN");
            String CIN = (String) jsonObject.get("CIN");
            String Groupname = (String) jsonObject.get("Groupname");
            persImpli2 Rmac = new persImpli2();
            String mac =Rmac.rechmac_webS(SN);
            int k =Rmac.rechmac_id(SN);
            int m= 0;
             if(Groupname.startsWith("ADSL")){
                    Groupname="Bee.net.tn";
                }else if(Groupname.startsWith("VDSL")){
                    Groupname="VBee.net.tn";
                }else{
                m=1;
                }
               
               int l =telephone.length();
               
               if (k==0){
                    String message="3";
           obj.put("message", message);
          
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(obj.toString());
               }else if(m==1){
                    String message="6";
           obj.put("message", message);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(obj.toString());
               }else if (l!=8){
                   String message="4";
           obj.put("message", message);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(obj.toString());
               }else{
                    int telephone1 = Integer.parseInt(telephone);
                    if(telephone1< 70000000 || telephone1 > 79999999){
                    String message="5";
           obj.put("message", message);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(obj.toString());
                    }else{
               int i= Rmac.verif_radius_par_tel(telephone);
               int j= Rmac.verif_radius_par_mac(mac);
               if (i!=0){
                   String message="1";
           obj.put("message", message);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(obj.toString());
               }else if(j!=0){
                   String message="2";
           obj.put("message", message);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(obj.toString()); 
               }else {
                 Rmac.ajout_radius(Nom,telephone1,mac,mac,CIN,Groupname);
            String message="0";
           obj.put("message", message);
           obj.put("login", mac);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(obj.toString());  
               }}}
            
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

    
    }


