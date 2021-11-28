/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package back_office;

import initiationjee.dao.persImpli;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.client_easy_bo;

/**
 *
 * @author serv-web
 */
public class affectation_tache extends HttpServlet {

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
            out.println("<title>Servlet affectation_tache</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet affectation_tache at " + request.getContextPath() + "</h1>");
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
        //nomber total des agent 
        String n = request.getParameter("number");
        //nomber total des demander a traiter 
        String m = request.getParameter("number1");

        persImpli p = new persImpli();
        p.supprimer_agent_double();
        p.rein_id_agent();
        //liste des agent selectionner 
        p.insert_back();

        ArrayList<Date> date_easy = new ArrayList();
        ArrayList<String> date_easy_1 = new ArrayList();
        ArrayList<String> code = new ArrayList();
        date_easy = p.select_date();
        date_easy_1 = p.select_date_1();
        code=p.select_code();
        int len_easy = date_easy.size();
        for (int i = 1; i < len_easy; i++) {

            p.inster_date(date_easy.get(i), code.get(i));
        }
        ArrayList<String> agent_L = new ArrayList();
        ArrayList<String> agent_nb = new ArrayList();
        ArrayList<Date> date_d = new ArrayList();
        ArrayList<Date> date_f = new ArrayList();
        String agent = null;
        String nb_demande = null;
        int l = 0;
        System.out.println(m);
        //changement int n
        int k = Integer.parseInt(n);
        //changement int m
        int u = Integer.parseInt(m);
        System.out.println(n);
        //les agent selectionner 
        for (int i = 1; i <= k; i++) {
            agent = request.getParameter("vehicle" + i);
            nb_demande = request.getParameter("nb_demande" + i);
            String date_debut = request.getParameter("date_debut" + i);
            String date_fin = request.getParameter("date_fin" + i);
            if (agent != null) {
                l++;
                agent_L.add(agent);
                agent_nb.add(nb_demande);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date startDate = null;
                Date lastDate = null;
                try {
                    startDate = sdf.parse(date_debut);

                    lastDate = sdf.parse(date_fin);
                } catch (ParseException ex) {
                    Logger.getLogger(affectation_tache.class.getName()).log(Level.SEVERE, null, ex);
                }
                date_d.add(startDate);
                date_f.add(lastDate);
            }
            System.out.println(agent);
            System.out.println(nb_demande);
        }
        //affichage nombre agent saisie
        System.out.println(l);
        //nombre des demande 
        System.out.println(u);
        //nb demande par agent 
        //int r = u / l;
        //nb rest des demande 
        //int rest = u % l;

        //System.out.println(r);
        //System.out.println(rest);
        //  p.affectation_easy(0,0,0);
        // p.insert_back();
        //ajout avec liste base client agent back office 
        ArrayList<String> t = new ArrayList<String>();
        int min = 0;
        int max = Integer.parseInt(agent_nb.get(0));

        for (int com = 0; com < l; com++) {
            String ag = agent_L.get(com);
            String nb_agent = agent_nb.get(com);
            Date debut=date_d.get(com);
            Date fin=date_f.get(com);
            java.sql.Date sDate = new java.sql.Date(debut.getTime());
            java.sql.Date sDate_1 = new java.sql.Date(fin.getTime());
            int ag1 = Integer.parseInt(ag);
            int ag2 = Integer.parseInt(nb_agent);
            System.out.println("avantmin" + min);
            System.out.println("apresmax" + nb_agent);
            t = p.select_back(min, max,sDate,sDate_1);
            int nb = t.size();
            System.out.println(nb);
            for (int d = 0; d < nb; d++) {
                
                String y = t.get(d);
                p.affectation_easy(ag1, y);
            }
            min = max;
            System.out.println("min" + min);
            max = max + ag2;
            System.out.println("max" + max);
        }

        /* date vérif
         String startDateStr=null;
         String startDateStr1=null;
         Date  startDate=null;
         Date  startDate1=null;*/
        /* startDateStr = request.getParameter("date_debut");
      
         System.out.println(startDateStr);
         startDateStr1 = request.getParameter("date_fin");
         startDateStr= startDateStr.replaceAll("-", "/");
         SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
       
         try {
         startDate  = sdf.parse(startDateStr);
         startDate1  = sdf.parse(startDateStr);
         } catch (ParseException ex) {
         Logger.getLogger(affectation_tache.class.getName()).log(Level.SEVERE, null, ex);
         }
         System.out.println(sdf.format(startDate));*/
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
