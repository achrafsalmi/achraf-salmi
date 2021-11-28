/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package initiationjee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import connexion.connection;
import dao.stock.persImpli2;
import initiationjee.dao.persImpli;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 *
 * @author serv-web
 */
public class reactivation_recv extends HttpServlet {

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
            out.println("<title>Servlet réactivation_recv</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet réactivation_recv at " + request.getContextPath() + "</h1>");
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String m = req.getParameter("bee_rec");
       String j = req.getParameter("bee_rec1");
        String log=null;
        String nb=null;
         String mac=null;
        try{
log = req.getSession().getAttribute("login").toString();
} catch (Exception e) {
            log=null;
        }
if (log==null){
              req.getRequestDispatcher("I_acceuil.jsp").forward(req, resp);  
                }
else{
    int o=Integer.parseInt(m);
                 persImpli2 login = new persImpli2();
                 mac=login.rech_login(o);
                 if (!j.isEmpty()){
                     req.setAttribute("msg", "client a une  IP fixe merci d'envoyer un en cas de réactivation");
        req.getRequestDispatcher("S_recv_acc.jsp").forward(req, resp);
                   } else {
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
        String type="2";
        persImpli rect = new persImpli();
        rect.ajout_rectivation(log,action,m,date,type);
       // rect.ver_client();

        req.setAttribute("msg", "connexion rétablie");
        req.getRequestDispatcher("S_recv_acc.jsp").forward(req, resp);
}else{
              String msg="client n'est pas suspendu";
        req.setAttribute("msg", msg);
        req.getRequestDispatcher("S_recv_acc.jsp").forward(req, resp);
}}
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
