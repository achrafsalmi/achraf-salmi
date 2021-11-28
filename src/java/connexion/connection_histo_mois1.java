package connexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class connection_histo_mois1 {
//on va d�clarer variable de type Connection de type java.sql 
	private static  Connection connection;
	//class pour �tablir la connection
	static{
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			//�tablir la connection
			connection=DriverManager.getConnection("jdbc:mysql://10.20.1.44:3306/histo_radius?autoReconnect=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true","dark","Bee@dark2021");
		    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static  Connection getConnection() {
		return connection;
	}
	
}
