package it.exolab.tesina.auction.util;
import java.util.Properties;



public class SendEmail {

	// Recipient's email ID needs to be mentioned.
	private String sendTo;
	
	// Sender's email ID needs to be mentioned
	private String adminMail;
	
	private String oggetto, comunicazione;
	
	// Assuming you are sending email from through gmails smtp
	private String host = "smtp.gmail.com";
	
	// Get system properties
	private Properties properties = System.getProperties();

	
	public SendEmail(String sendTo, String adminMail, String oggetto, String comunicazione) {
		
		this.sendTo = sendTo;
		this.adminMail = adminMail;
		this.oggetto = oggetto;
		this.comunicazione = comunicazione;
	}

	public String getComunicazione() {
		return comunicazione;
	}

	public void setComunicazione(String comunicazione) {
		this.comunicazione = comunicazione;
	}

	public String getSendTo() {
		return sendTo;
	}

	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}

	public String getAdminMail() {
		return adminMail;
	}

	public void setAdminMail(String adminMail) {
		this.adminMail = adminMail;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public String getOggetto() {
		return oggetto;
	}

	public void setOggetto(String oggetto) {
		this.oggetto = oggetto;
	}

}
