/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author DELL
 */
public class testcmdsudo {

    /**
     * @param args the command line arguments
     */
     Session session = null;

    

    public void connect(){
    try {

            JSch jsch = new JSch();
            session = jsch.getSession("user", "xxx.xxx.xx.xx", 22);
            session.setPassword("test");
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void executeCommand(String script) throws JSchException, IOException{
        System.out.println("Execute sudo");
        String sudo_pass = "test";
        ChannelExec channel = (ChannelExec) session.openChannel("exec");
        ((ChannelExec) channel).setCommand( script);

        InputStream in = channel.getInputStream();
        OutputStream out = channel.getOutputStream();
        ((ChannelExec) channel).setErrStream(System.err);

        channel.connect();
        out.write((sudo_pass + "\n").getBytes());
        out.flush();

        byte[] tmp = new byte[1024];
        while (true) {
            while (in.available() > 0) {
                int i = in.read(tmp, 0, 1024);
                if (i < 0)
                    break;
                System.out.print(new String(tmp, 0, i));
            }
            if (channel.isClosed()) {
                System.out.println("exit-status: " + channel.getExitStatus());
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (Exception ee) {
                System.out.println(ee);
            }
        }
        channel.disconnect();
        System.out.println("Sudo disconnect");
    }

    public void disconnect(){
        session.disconnect();
    }


    public static void main(String... args) throws JSchException, IOException {

        testcmdsudo up = new testcmdsudo();
        up.connect();

        up.executeCommand("sudo -u masteruser bash");

        up.disconnect();
    }

}


