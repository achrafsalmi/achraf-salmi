/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail;

import java.util.*; 
import javax.mail.*; 
import javax.mail.PasswordAuthentication;
import javax.mail.internet.*;
public class send_email_gmail {
	public static void main(String[] args) {
		final String username = "bee.dark@bee.net.tn";
		final String password = "Achraf21";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "mail.beemail.tn");
		props.put("mail.smtp.port", "25");
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(username, password);
			}
		  });
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("bee.dark@bee.net.tn"));
			message.setRecipients(Message.RecipientType.TO,
			InternetAddress.parse("achraf.salmi@bee.net.tn"));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler");
			Transport.send(message);
			System.out.println("Done");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}