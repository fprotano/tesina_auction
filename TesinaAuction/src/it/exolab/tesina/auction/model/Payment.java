package it.exolab.tesina.auction.model;

public class Payment {
	
	private Double amount;
	private String email, customCode, transactionId, urlUnDo, urlSuccess, urlNotify, urlBank;
	
	
	public Payment() {

	}
	
	public Payment(Double amount, String email, String customCode, String transactionId, String urlUnDo,
			String urlSuccess, String urlNotify, String urlBank) {

		this.amount = amount;
		this.email = email;
		this.customCode = customCode;
		this.transactionId = transactionId;
		this.urlUnDo = urlUnDo;
		this.urlSuccess = urlSuccess;
		this.urlNotify = urlNotify;
		this.urlBank = urlBank;
	}

	public String getUrlUnDo() {
		return urlUnDo;
	}


	public void setUrlUnDo(String urlUnDo) {
		this.urlUnDo = urlUnDo;
	}

	public String getUrlSuccess() {
		return urlSuccess;
	}

	public void setUrlSuccess(String urlSuccess) {
		this.urlSuccess = urlSuccess;
	}

	public String getUrlNotify() {
		return urlNotify;
	}

	public void setUrlNotify(String urlNotify) {
		this.urlNotify = urlNotify;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
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

	public String getUrlBank() {
		return urlBank;
	}

	public void setUrlBank(String urlBank) {
		this.urlBank = urlBank;
	}

	@Override
	public String toString() {
		return "Payment [amount=" + amount + ", email=" + email + ", customCode=" + customCode + ", transactionId="
				+ transactionId + ", urlUnDo=" + urlUnDo + ", urlSuccess=" + urlSuccess + ", urlNotify=" + urlNotify
				+ ", urlBank=" + urlBank + "]";
	}
	
}
