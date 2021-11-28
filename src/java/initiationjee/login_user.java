package initiationjee;

import support.*;
import initiationjee.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import connexion.connection;
import initiationjee.dao.persImpli;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class login_user extends HttpServlet {

    @Override
    //utiliser pour avec url paterne 
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub

    }

    @Override
    //utiliser pour tout la pqge 
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String login = req.getParameter("matricule");
String mdp = req.getParameter("mdp");
HttpSession session=req.getSession();
session.setAttribute("login", login);
session.setAttribute("mdp", mdp);
        persImpli login_user = new persImpli();
      int j=  login_user.login_user(login, mdp);
        System.out.println(j);
        if(j==1){

    req.setAttribute("msg", "Welcome  "+login);
    req.setAttribute("login", login);
        req.getRequestDispatcher("ajout.jsp").forward(req, resp);    
        
        }else  if(j==2){ req.setAttribute("msg", "Welcome  "+login);
        req.setAttribute("login", login);
        req.getRequestDispatcher("S_com_acc.jsp").forward(req, resp);
        }else  if(j==3){ req.setAttribute("msg", "Welcome  "+login);
        req.setAttribute("login", login);
        req.getRequestDispatcher("test.jsp").forward(req, resp);
        }else if (j==4){
            req.setAttribute("msg", "Welcome  "+login);
        req.setAttribute("login", login);
        req.getRequestDispatcher("S_client_acc.jsp").forward(req, resp);
        }else if (j==5){
            req.setAttribute("msg", "Welcome  "+login);
        req.setAttribute("login", login);
        req.getRequestDispatcher("S_recv_acc.jsp").forward(req, resp);
        }else if (j==6){
            req.setAttribute("msg", "Welcome  "+login);
        req.setAttribute("login", login);
        req.getRequestDispatcher("S_com_fact.jsp").forward(req, resp);
        }else if (j==7){
            req.setAttribute("msg", "Welcome  "+login);
        req.setAttribute("login", login);
        req.getRequestDispatcher("S_com_fact_RM.jsp").forward(req, resp);
        }else if (j==8){
            req.setAttribute("msg", "Welcome  "+login);
        req.setAttribute("login", login);
        req.getRequestDispatcher("upload_BD_WF.jsp").forward(req, resp);
        }else{ req.setAttribute("msg", "login non valide");
        }
        req.getRequestDispatcher("I_acceuil.jsp").forward(req, resp);
       }
}
    

