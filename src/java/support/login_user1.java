/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package support;

import initiationjee.dao.persImpli;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * 
 */
public class login_user1 {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub

    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         
String login = req.getParameter("matricule");
String mdp = req.getParameter("mdp");
 ResultSet res=null;
    

    
       
        cnx c = new cnx();
        
        int group = 0;
        res = c.execR("SELECT * FROM user  ");
        try {
            while (res.next()) {
                if (login.equals(res.getString("Matricule")) && mdp.equals(res.getString("Mpasse"))) {

                    switch (res.getInt("id_group")) {
                        case 1:
                            req.getRequestDispatcher("ajout.jsp").forward(req, resp);
                            break;
                        case 2:
                            req.getRequestDispatcher("ajout.jsp").forward(req, resp);
                            break;
                        case 3:
                            req.getRequestDispatcher("ajout.jsp").forward(req, resp);
                            break;
                        case 4:
                            req.getRequestDispatcher("ajout.jsp").forward(req, resp);
                            break;
                        case 5:
                            group = 5;
                            break;
                        default:
                            group = 7;
                            break;
                    }
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(login_user1.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
        

    }
   




