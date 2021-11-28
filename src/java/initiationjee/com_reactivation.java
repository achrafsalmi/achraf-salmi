/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package initiationjee;

import test.*;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author DELL
 */
public class com_reactivation {

    Session session;

    public void initSession() {

        JSch jsch = new JSch();

        String host = "10.20.1.28";

        String username = "root";

        String password = "Kh@lilou1989Sl1ti";

        try {

            session = jsch.getSession(username, host, 22);

            session.setPassword(password);

            java.util.Properties config = new java.util.Properties();

            config.put("StrictHostKeyChecking", "no");

            session.setConfig(config);

            session.setPassword(password);

            session.connect();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public void disconnectSession() {

        session.disconnect();

    }

    public String runCommand(String command) {
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

                    if (i < 0) {
                        break;
                    }

                   // System.out.print(new String(tmp, 0, i));
s = new String(tmp, 0,i);
                }
                
                if (channel.isClosed()) {

                    System.out.println("exit-status:" + channel.getExitStatus());

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
