/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail;
import java.util.*; 
import javax.mail.*;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.*;
public class send_mail {
	public static void main(String[] args) {
		send_mail obj_send_mail=new send_mail();
		obj_send_mail.send_mail("subject ","body", "achraf.salmi@bee.net.tn");
	}
	public void send_mail(String subject,String message,String email_id) {
		String smtpServer = null; 
                String smtpPort = null;
		final String authAddress = "bee.dark@bee.net.tn";      
		final String authPassword = "Achraf21";    
          
		//String message = "test by jinu";     
        smtpServer = "mail.beemail.tn";
        smtpPort = "25";    
        try{    
                Properties props = new Properties();     
                props.put("mail.smtp.host", smtpServer); 
                props.put("mail.smtp.port", smtpPort);   
                props.put("mail.smtp.auth", "true");         
            // create some properties and get the default Session
            Session sessionMail = Session.getInstance(props, new Authenticator() {
                 public PasswordAuthentication getPasswordAuthentication() {      
                         return new PasswordAuthentication(authAddress, authPassword);
                 }                                                                    
                });                                                                   
            sessionMail.setDebug(true);
            // create a message
            Message msg = new MimeMessage(sessionMail);
            // set the from and to address
            InternetAddress addressFrom = new InternetAddress(authAddress);
            msg.setFrom(addressFrom);
            InternetAddress[] addressTo = new InternetAddress[1];
            addressTo[0] = new InternetAddress(email_id);
            msg.setRecipients(Message.RecipientType.TO, addressTo);
            // Setting the Subject and Content Type
            msg.setSubject(subject);
            msg.setContent(message, "text/html");
            Transport.send(msg);
        }catch(Exception e){
                System.out.println(e);
        }
}
}