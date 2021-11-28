package test;

import connexion.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class connection {
//on va d�clarer variable de type Connection de type java.sql 
	private static  Connection connection;
	//class pour �tablir la connection
	static{
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			//�tablir la connection
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/radius_bee","root","rtiL681r");
		    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static  Connection getConnection() {
		return connection;
	}

    PreparedStatement prepareStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
}
