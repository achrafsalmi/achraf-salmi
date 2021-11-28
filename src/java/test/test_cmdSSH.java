package test;
import java.io.InputStream;
import java.util.Properties;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static sun.security.krb5.Confounder.bytes;
import connexion.connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class test_cmdSSH {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
                int i = 255;
                int j = 100;
                int nb=5;
             connection con = null;
             PreparedStatement ps = con.getConnection().prepareStatement("select ip1 from ip");
             
        j = 100;
        if (i >= 254) {
            i = 1;
            j = j + 1;
        } else if (i <= 254) {
            i=i+1;
        }
                String host = "10.10.1.20";
		String user = "khalil";
		String password = "Kh@lilou1989Sl1ti";
		/*String command = "echo  '#khenissi Abdessalem	\n" +
"283B82DA7B7F		Auth-Type := CHAP\n" +
"			Service-Type = Framed,\n" +
"			Framed-Protocol = PPP,\n" +
"			Framed-IP-Address = 10.100."+ j +"."+ i +",\n" +
"                    Framed-IP-Netmask = 255.255.255.255' >> /home/radius/Desktop/test ";*/
                String command ="sh users sum";
                ResultSet res ;
                String s;
                

		try {
			Properties config = new Properties();
			config.put("StrictHostKeyChecking", "no");
			JSch jsch = new JSch();
			// Create a JSch session to connect to the server
			Session session = jsch.getSession(user, host, 22);
			session.setPassword(password);
			session.setConfig(config);
			// Establish the connection
			session.connect();
			System.out.println("Connected...");

			ChannelExec channel = (ChannelExec) session.openChannel("exec");
			channel.setCommand(command);
			channel.setErrStream(System.err);
System.out.println("test");
			InputStream in = channel.getInputStream();
			channel.connect();
                       
			byte[] tmp = new byte[1024];
			while (true) {
				while (in.available() > 0) {
					int v = in.read(tmp, 0, 1024);
					if (v < 0) {
						break;
                                                
                                            
                                                
					}
					
                                        s=new String(tmp);

                                         String k = s;
                                        System.out.println(s);
                                       
                                        
                                        
                                        
				}			if (channel.isClosed()) {
					System.out.println("Exit Status: "
							+ channel.getExitStatus());
					break;}Thread.sleep(1000);
			
                       
				}
                        channel.disconnect();
			session.disconnect();
			System.out.println("DONE!!!");
			
				
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
        
	}

