package radius_action;

import initiationjee.*;
import dao.stock.persImpli2;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class modification extends HttpServlet {

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
        String m=null;
        String n=null;
        String k=null;
        String l=null;
        String msg=null;
        Date date1=null;
         n = req.getParameter("id");
          m = req.getParameter("Nom");
          k = req.getParameter("telephone");
          l = req.getParameter("bt_histo");
        String log =null;
          if (l.equals("historique")){
              req.setAttribute("msg", "select radacctid,username,acctstatustype,acctstarttime,acctstoptime,framedipaddress,acctsessiontime,tel_adsl from radacct WHERE `username` LIKE '%"+n+"%'ORDER BY `radacctid` DESC LIMIT 100");
        req.setAttribute("bee", "client est :"+m+" tel_adsl :"+k);
        req.setAttribute("Mac", n);
        req.setAttribute("tel", k);
        req.setAttribute("nom", m);
        req.setAttribute("verif", "oui");
        req.getRequestDispatcher("suivie_acct_com.jsp").forward(req, resp);
          }else if(l.equals("historique__client")){      
   req.setAttribute("msg", "select radacctid,username,acctstatustype,acctstarttime,acctstoptime,framedipaddress,acctsessiontime,tel_adsl from radacct WHERE `username` LIKE '%"+n+"%'ORDER BY `radacctid` DESC LIMIT 100");
        req.setAttribute("bee", "client est :"+m+" tel_adsl :"+k);
        req.setAttribute("Mac", n);
        req.setAttribute("tel", k);
        req.setAttribute("nom", m);
        req.setAttribute("verif", "oui");
        req.getRequestDispatcher("suivie_acct_recv.jsp").forward(req, resp);
}   else if(l.equals("historique_client")){      
   req.setAttribute("msg", "select radacctid,username,acctstatustype,acctstarttime,acctstoptime,framedipaddress,acctsessiontime,tel_adsl,nasipaddress from radacct WHERE `username` LIKE '%"+n+"%' ORDER BY `radacctid` DESC ");
        req.setAttribute("bee", "client est :"+m+" tel_adsl :"+k);
        req.setAttribute("Mac", n);
        req.setAttribute("tel", k);
        req.setAttribute("nom", m);
        req.setAttribute("verif", "oui");
        req.getRequestDispatcher("suivie_acct.jsp").forward(req, resp);
}else if(l.equals("historique_total")){   
    String o = req.getParameter("date_rech");
   
              SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd"); 
             SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM");
           try {  
                date1=formatter1.parse(o);
           } catch (ParseException ex) {
                Logger.getLogger(modification.class.getName()).log(Level.SEVERE, null, ex);
            }
              System.out.println(formater.format(date1));
              System.out.println(date1);
   req.setAttribute("msg", "select radacctid,username,acctstatustype,acctstarttime,acctstoptime,framedipaddress,acctsessiontime,tel_adsl,nasipaddress from histo_radius.`"+formater.format(date1)+"` WHERE `tel_adsl` LIKE '%"+k+"%'ORDER BY `radacctid` DESC");
        req.setAttribute("bee", "client est :"+m+" tel_adsl :"+k);
        req.setAttribute("Mac", n);
        req.setAttribute("tel", k);
        req.setAttribute("nom", m);
        req.setAttribute("verif", "non");
        req.getRequestDispatcher("suivie_acct_mois.jsp").forward(req, resp);
}else if(l.equals("historique__total")){      
   req.setAttribute("msg", "select radacctid,username,acctstatustype,acctstarttime,acctstoptime,framedipaddress,acctsessiontime,tel_adsl from 30_03_18_07_back WHERE `username` LIKE '%"+n+"%'ORDER BY `radacctid` DESC");
        req.setAttribute("bee", "client est :"+m+" tel_adsltest :"+k);
        req.setAttribute("Mac", n);
        req.setAttribute("tel", k);
        req.setAttribute("nom", m);
        req.setAttribute("verif", "non");
        req.getRequestDispatcher("suivie_acct_recv_ancien.jsp").forward(req, resp);
}else if(l.equals("histo_depl")){      
   req.setAttribute("msg", "select radacctid,username,acctstatustype,acctstarttime,acctstoptime,framedipaddress,acctsessiontime,tel_adsl from radacct WHERE `username` LIKE '%"+n+"%'ORDER BY `radacctid` DESC LIMIT 100");
        req.setAttribute("bee", "client est :"+m+" tel_adsltest :"+k);
        req.setAttribute("Mac", n);
        req.setAttribute("tel", k);
        req.setAttribute("nom", m);
        req.setAttribute("verif", "non");
        req.getRequestDispatcher("suivie_depl.jsp").forward(req, resp);
}}

 
                
               
		
    }
