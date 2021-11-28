package support;

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
 ResultSet res=null;
    

    
       
        cnx c = new cnx();
        
        int group = 0;
        res = c.execR("SELECT * FROM user");
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
