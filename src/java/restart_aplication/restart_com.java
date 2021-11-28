/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restart_aplication;

import initiationjee.*;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import java.io.InputStream;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author DELL
 */
public class restart_com {
    
	 Session  session;
     public void initSession() {

            JSch jsch = new JSch();

            String host = "10.20.1.32";

            String username = "serv-web";

            String password = "rtiL681r";

            try {

                  session = jsch.getSession(username, host, 22);

                  session.setPassword(password);

                  java.util.Properties config = new
java.util.Properties();

                  config.put("StrictHostKeyChecking", "no");

                  session.setConfig(config);

                  session.setPassword(password);

                  session.connect();

            } catch (Exception e) {

                  e.printStackTrace();

            }

      }

     

      public void disconnectSession(){

             session.disconnect();

      }
public String runCommand1() {
    String command="bash /opt/tomcat/bin/catalina.sh stop";
String s = null;
            try {

                 

                  Channel channel = session.openChannel("exec");

channel.setInputStream(null);

                  channel.setOutputStream(System.out);

                  

                  ((ChannelExec) channel).setCommand(command);

                  channel.connect();
out.write(("rtiL681r" + "\n").getBytes());
        out.flush();
                  InputStream in = channel.getInputStream();

                  byte[] tmp = new byte[1024];

                  while (true) {

                        while (in.available() > 0) {

                              int i = in.read(tmp, 0, 1024);

                              if (i < 0)

                                    break;

                              System.out.print(new String(tmp, 0, i));
                               s =new String(tmp,0,1);
                        }

                        if (channel.isClosed()) {

 
System.out.println("exit-status:"+channel.getExitStatus());

                              break;

                        }

                        try {

                              Thread.sleep(1000);

                        } catch (Exception ee) {

                        }

                  }

                  channel.disconnect();

            } catch (Exception e) {

                  e.printStackTrace();

            }
         return s;

      }
 

      public String runCommand() {
          String command="bash /opt/tomcat/bin/catalina.sh start";
String s = null;
            try {

                 

                  Channel channel = session.openChannel("exec");

channel.setInputStream(null);

                  channel.setOutputStream(System.out);

                  

                  ((ChannelExec) channel).setCommand(command);

                  channel.connect();

                  InputStream in = channel.getInputStream();

                  byte[] tmp = new byte[1024];

                  while (true) {

                        while (in.available() > 0) {

                              int i = in.read(tmp, 0, 1024);

                              if (i < 0)

                                    break;

                              System.out.print(new String(tmp, 0, i));
                              
                        }
 s =new String(tmp,0,1);
                        if (channel.isClosed()) {

 
System.out.println("exit-status:"+channel.getExitStatus());

                              break;

                        }

                        try {

                              Thread.sleep(1000);

                        } catch (Exception ee) {

                        }

                  }

                  channel.disconnect();

            } catch (Exception e) {

                  e.printStackTrace();

            }
         return s;

      }
      
}
