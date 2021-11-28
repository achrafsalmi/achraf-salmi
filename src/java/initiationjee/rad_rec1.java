/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package initiationjee;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author DELL
 */
public class rad_rec1 {
    
	public String sh(String nl ,String nl1) {
		// TODO Auto-generated method stub
		String s = null;
		String host = "41.231.103.28";
		String user = "root";
		String password = "Kh@lilou1989Sl1ti";
		String command = "sed -i -e '$"+ nl +" ,$ "+ nl1 +" d' /home/radius/Desktop/test "  ;
                  
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
					
					s=new String(tmp);
                                           
                                        
				}				if (channel.isClosed()) {
					System.out.println("Exit Status: "
							+ channel.getExitStatus());
					break;
				}Thread.sleep(1000);
			}
			channel.disconnect();
			session.disconnect();
			System.out.println("DONE!!!");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s  ;
	}
}
