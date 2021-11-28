package connexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class cnx_radius {
//on va d�clarer variable de type Connection de type java.sql 
	private static  Connection connection;
	//class pour �tablir la connection
	static{
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			//�tablir la connection
			connection=DriverManager.getConnection("jdbc:mysql://10.20.1.28:3306/radius","cnx_base","base_bee_2020");
		    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static  Connection getConnection() {
		return connection;
	}
	
}
