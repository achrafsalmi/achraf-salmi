package ssh_LNS_new;
import initiationjee.*;
import java.io.InputStream;
import java.util.Properties;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import java.util.ArrayList;
import java.util.List;

public class lns_bel_cnx {

	public String sh(String login) {
		// TODO Auto-generated method stub
		String s = null;
		String host = "10.20.20.15";
		String user = "admin";
		String password = "BeeAdmin";
		String command = "sh users | inc "+ login  ;
                System.out.println(command);
                  List <String> list =new ArrayList ();
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
			

			ChannelExec channel = (ChannelExec) session.openChannel("exec");
			channel.setCommand(command);
			channel.setErrStream(System.err);

			InputStream in = channel.getInputStream();
			channel.connect();
			byte[] tmp = new byte[1024];
			while (true) {
				while (in.available() > 0) {
					int i = in.read(tmp, 0, 1024);
					if (i < 0) {
						break;
					}
					
					 String k=new String(tmp, 0,i);
                                           s=k;
                                           
                                         
                                        
				}				if (channel.isClosed()) {
					//System.out.println("Exit Status: "
							//+ channel.getExitStatus());
					break;
				}Thread.sleep(1000);
			}
			channel.disconnect();
			session.disconnect();
			//System.out.println("DONE!!!");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s  ;
	}
	}

