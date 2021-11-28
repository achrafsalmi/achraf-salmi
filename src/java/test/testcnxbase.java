/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.jcraft.jsch.JSchException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import connexion.connection_Stock;

/**
 *
 * @author serv-web
 */
public class testcnxbase {
    Connection con = null;
    Statement requete = null;
    ResultSet resultat = null; 
    public Connection connect() throws ClassNotFoundException, SQLException {
        Connection c = null;
        Class.forName("com.mysql.jdbc.Driver");
        
        c = DriverManager.getConnection("jdbc:mysql://localhost:3306/stock_modem","root","rtiL681r");
        return c;
    }
    public String testcnx() {
        try {
            con = this.connect();
            requete = con.createStatement();
            return ("ok");
        } catch (ClassNotFoundException cnfe) {
            return ("driver");
        } catch (SQLException se) {
            return ("stgpi");

        }
    }public void updpers(String p1 , int p2) {
        String sql="update modem set Mac='"+p1+"' where id = '"+p2+"'";
        connection_Stock conn = null;
		try {
		PreparedStatement ps = conn.getConnection().prepareStatement(sql);
		
		int test=ps.executeUpdate();
		//variable qui contient les retour de la requet 
		/*if(test!=0){
			System.out.println("Ajout effectuer avec succ�e");
		}else{
			System.out.println("Erreur d'ajout dans la table");
			
		}
		*/
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }public String rech(String p1 ) {
        String i = "null";
        String sql="SELECT * FROM `modem` WHERE `SN` LIKE '"+p1+"'";
        connection_Stock conn = null;
		try {
		PreparedStatement ps = conn.getConnection().prepareStatement(sql);
		
		ResultSet res=ps.executeQuery(sql);
                 while (res.next()) {
				
				i=res.getString("Mac");
				
				
				
			}
		//variable qui contient les retour de la requet 
		/*if(test!=0){
			System.out.println("Ajout effectuer avec succ�e");
		}else{
			System.out.println("Erreur d'ajout dans la table");
			
		}
		*/
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
        return i;
                
    }
    
    
    
      public static void main(String[] arg) throws ClassNotFoundException, SQLException {
testcnxbase ns=new testcnxbase();
         ns.connect();
ns.testcnx();
String i=ns.rech("T0031I5005841");
System.out.println(i);
ns.updpers("salmi21",1);
       
    }
}
