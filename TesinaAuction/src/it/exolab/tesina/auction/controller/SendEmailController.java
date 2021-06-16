package it.exolab.tesina.auction.controller;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import it.exolab.tesina.auction.util.SendEmail;

public class SendEmailController {
	
	private static String host = "mail.smtp.host";
	private static String port = "mail.smtp.port";
	private static String portNumber ="465";
	private static String ssl = "mail.smtp.ssl.enable";
	private static String trueMail = "true";
	private static String auth = "mail.smtp.auth";
//	private static String filePath = "C:\\Users\\alessio\\Downloads\\out.pdf";
	
	private final String yourPassword = "e2021!tesina";
	
	
	public void sendMail(String sendTo, String adminMail, String oggetto,  String comunicazione) {
		 
		
		SendEmail sendEmail = new SendEmail(sendTo, adminMail, oggetto, comunicazione);	
	        
		// Setup mail server
		sendEmail.getProperties().put(host, sendEmail.getHost());
		sendEmail.getProperties().put(port, portNumber);
		sendEmail.getProperties().put(ssl, trueMail);
		sendEmail.getProperties().put(auth,trueMail);
		
		// Get the Session object.// and pass 
		Session session = Session.getInstance(sendEmail.getProperties(), new javax.mail.Authenticator() {
		
		    protected PasswordAuthentication getPasswordAuthentication() {
		
		        return new PasswordAuthentication(sendEmail.getAdminMail(), yourPassword);
		    }
		});
		//session.setDebug(true);
		try {
		    // Create a default MimeMessage object.
		    MimeMessage message = new MimeMessage(session);
		
		    // Set From: header field of the header.
		    message.setFrom(new InternetAddress(sendEmail.getAdminMail()));
		
		    // Set To: header field of the header.
		    message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendEmail.getSendTo()));
		
		    // Set Subject: header field
		    message.setSubject(oggetto);
		
		    Multipart multipart = new MimeMultipart();
		
		    MimeBodyPart attachmentPart = new MimeBodyPart();
		
		    MimeBodyPart textPart = new MimeBodyPart();
		
//		    try {
//		
//		        File allegato =new File(filePath);
//		
//		        attachmentPart.attachFile(allegato);
		        textPart.setText(comunicazione);
		        multipart.addBodyPart(textPart);
//		        multipart.addBodyPart(attachmentPart);
//		
//		    } 
//		    catch (IOException e) {
//		
//		        e.printStackTrace();
//		    }
		    message.setContent(multipart);
		
		    System.out.println("sending...");
		    // Send message
		    Transport.send(message);
		    System.out.println("Sent message successfully....");
		    } catch (MessagingException mex) {
		        mex.printStackTrace();
		    }
		
		}

}
