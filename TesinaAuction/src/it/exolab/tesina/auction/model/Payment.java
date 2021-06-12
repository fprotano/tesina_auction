package it.exolab.tesina.auction.model;

public class Payment {
	
	private Double amount;
	private String email, customCode, transactionId, url;
	
	
	public Payment() {

	}
	
	public Payment(double amount, String email, String customCode, String transactionId, String url) {
		
		this.amount = amount;
		this.email = email;
		this.customCode = customCode;
		this.transactionId = transactionId;
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCustomCode() {
		return customCode;
	}
	public void setCustomCode(String customCode) {
		this.customCode = customCode;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	
	@Override
	public String toString() {
		return "Payment [amount=" + amount + ", email=" + email + ", customCode=" + customCode + ", transactionId="
				+ transactionId + ", url=" + url + "]";
	}
	
	
	

}
