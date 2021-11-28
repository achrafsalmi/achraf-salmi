package initiationjee;

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
import java.sql.Statement;
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

public class susp extends HttpServlet {

    @Override
    //utiliser pour avec url paterne 
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub

    }

    @Override
    //utiliser pour tout la pqge 
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String m;

        
        Connection connection;
        Statement statement;

        // R�cup�ration des donn�es depuis le fichier excel
        

        
        // TODO Auto-generated method stub
		String log =null;
                try{
                    log = req.getSession().getAttribute("login").toString();
if (log!=null){
        
        persImpli susp_auto = new persImpli();
        susp_auto.susp_automatique();

        req.setAttribute("msg", "internet suspendu");
        req.getRequestDispatcher("ajout.jsp").forward(req, resp);
}
else{
              req.getRequestDispatcher("I_acceuil.jsp").forward(req, resp);  
                }
                
               } catch (Exception e) {
            req.getRequestDispatcher("I_acceuil.jsp").forward(req, resp);
        }
    }
}
