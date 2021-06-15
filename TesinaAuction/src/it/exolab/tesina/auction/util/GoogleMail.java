package it.exolab.tesina.auction.util;
import com.sun.mail.smtp.SMTPTransport;
import java.security.Security;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class GoogleMail {
	
	Session newSession;
	MimeMessage mimeMessage;
	
	public GoogleMail() {
    }
	
	// username exolabCorso2021
	// password e2021!tesina
	
	
public void sendMail(String getTo, String getSubject, String getText) throws AddressException, MessagingException {
		
//			GoogleMail gm = new GoogleMail();
//			
//			gm.setServerProperties();
//			gm.draftMail(getTo, getSubject, getText);
//			gm.sendEmail();
	
	this.sendPlainTextEmail("smtp.gmail.com", "587", "exolabCorso2021@gmail.com", 
						"e2021!tesina", getTo, getSubject, getText);
	
	/*
	 * String host, String port,
            final String userName, final String password, String toAddress,
            String subject, String message
	 */
		
	}

	private void sendEmail() throws MessagingException {
		String fromUser = "exolabCorso2021@gmail.com";
		String fromPassword = "e2021!tesina";
		String emailHost = "smtp.gmail.com";
		Transport transport = newSession.getTransport("smtp");
		transport.connect(emailHost, fromUser, fromPassword);
		transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
		transport.close();
		System.out.println("mail inviata");
	}

	private void draftMail(String getTo, String getSubject, String getText) throws AddressException, MessagingException {
	
		String to = getTo;
		String from ="exolabCorso2021@gmail.com";
		String subject = getSubject;
		String emailBody = getText;
		mimeMessage = new MimeMessage(newSession);
		
		mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		mimeMessage.setSubject(subject);
		
		MimeBodyPart mimeBodyPart = new MimeBodyPart();
		mimeBodyPart.setContent(emailBody, "html/text");
		
		MimeMultipart mimeMultipart = new MimeMultipart();
		mimeMultipart.addBodyPart(mimeBodyPart);
		mimeMessage.setContent(mimeMultipart);
}

	private void setServerProperties() {
		Properties pr = System.getProperties();	
		pr.put("mail.smtp.port", "547");
		pr.put("mail.smtp.auth", "true");
		pr.put("mail.smtp.starttls.enable", "true");
		newSession = Session.getDefaultInstance(pr, null);
		
	}
	
	/*
	 * ################################################################
	 * ################################################################
	 */
	
	
	public void sendPlainTextEmail(String host, String port,
            final String userName, final String password, String toAddress,
            String subject, String message) throws AddressException,
            MessagingException {

        // sets SMTP server properties
        Properties properties = new Properties();
//        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
// *** BEGIN CHANGE
        properties.put("mail.smtp.user", userName);

        // creates a new session, no Authenticator (will connect() later)
        Session session = Session.getDefaultInstance(properties);
// *** END CHANGE

        // creates a new e-mail message
        Message msg = new MimeMessage(session);

        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
        // set plain text message
        msg.setText(message);

// *** BEGIN CHANGE
        // sends the e-mail
        Transport t = session.getTransport("smtp");
        t.connect(userName, password);
        t.sendMessage(msg, msg.getAllRecipients());
        t.close();
        System.out.println("email spedita");
// *** END CHANGE

    }
}
