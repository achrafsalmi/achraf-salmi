/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package initiationjee;

import connexion.connection_Stock;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
 
public class guru_upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public guru_upload() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
	
        
            String name=null;	       
            if(ServletFileUpload.isMultipartContent(request)){
		            try {
		                List <FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
		                for(FileItem item : multiparts){
		                    if(!item.isFormField()){
		                        name = new File(item.getName()).getName();
		                        item.write( new File("/home/serv-web/Documents/file" + File.separator + name));
		                    }
		                }
		               //File uploaded successfully
		               request.setAttribute("gurumessage", name);
                         
		            } catch (Exception ex) {
		               request.setAttribute("gurumessage", "File Upload Failed due to " + ex);
		            }         		
		        }else{
		
		            request.setAttribute("gurumessage","No File found");
 }
	String sql="LOAD DATA LOCAL INFILE '/home/serv-web/Documents/file/"+name+"' REPLACE INTO TABLE radius_bee.wf  FIELDS TERMINATED BY ';' LINES TERMINATED BY '\n' IGNORE 1 LINES (ref_tt,tel_adsl,contrat,date_depot,type_demande,client,debit,etat,date_etat,adresse,contact,cin,region,csc,motif_instance,ref_smart,date_etat_e,date_etat_v,date_conf);";
                          ResultSet res1;
        int i = 0;
        try {
            PreparedStatement ps = connection_Stock.getConnection().prepareStatement(sql);
             ps.execute();
             
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }	        
            request.getRequestDispatcher("/result.jsp").forward(request, response);
		
		    }
 
 
}