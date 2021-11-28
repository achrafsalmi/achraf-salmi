package connexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class connection_historadius {
//on va d�clarer variable de type Connection de type java.sql 
	private static  Connection connection;
	//class pour �tablir la connection
	static{
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			//�tablir la connection
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/back_radius?autoReconnect=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true","radius_bee","rtiL681r");
		    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static  Connection getConnection() {
		return connection;
	}
        
	
}
