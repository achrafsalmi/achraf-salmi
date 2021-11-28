package controlor;
import java.io.InputStream;
import java.util.Properties;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import java.util.ArrayList;

public class SSHConnectionJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String host = "41.231.12.1";
		String user = "BEE_Partner";
		String password = "BEE_Partner";
		String command = "sh users | inc mo";
                ArrayList <String> list =new ArrayList ();
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
  //System.out.print(channel);
			InputStream in = channel.getInputStream();
                        // System.out.println(in); 
			channel.connect();
			byte[] tmp = new byte[1024];
                     //  System.out.println(tmp); 
			while (true) { 
                          
				while (in.available() > 0) {
                                  
					int i = in.read(tmp, 0, 1024);
					if (i < 0) {
						break;
                                         
					
                                             
					}//System.out.print(i);
					//System.out.print(tmp);
                                       // String s=new String(tmp, 0,i);
                                        System.out.print(tmp);
                                        
                                      //  System.out.print(s);
					/*
                                        list.add(s);
                                        
                                       System.out.println(list);                   
System.out.println(list.size());      */             
				}
                                
				}
				
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	}

