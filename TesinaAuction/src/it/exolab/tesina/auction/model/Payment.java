package it.exolab.tesina.auction.model;

public class Payment {
	
	private double amount;
	private String email, custom_code, transaction_id, url;
	
	
	public Payment() {

	}
	
	public Payment(double amount, String email, String custom_code, String transaction_id, String url) {
		
		this.amount = amount;
		this.email = email;
		this.custom_code = custom_code;
		this.transaction_id = transaction_id;
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
	public String getCustom_code() {
		return custom_code;
	}
	public void setCustom_code(String custom_code) {
		this.custom_code = custom_code;
	}
	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	
	@Override
	public String toString() {
		return "Payment [amount=" + amount + ", email=" + email + ", custom_code=" + custom_code + ", transaction_id="
				+ transaction_id + ", url=" + url + "]";
	}
	
	
	

}
