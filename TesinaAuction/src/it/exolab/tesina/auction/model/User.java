package it.exolab.tesina.auction.model;


import java.time.LocalDateTime;

public class User {
	
	private Integer id;
	private LocalDateTime createAt;
	private LocalDateTime updateedAt;
	private Integer enabled;
	private String email;
	private String password;
	private String name;
	private String surname;
	private LocalDateTime nextOtpCodeAfterDate;
	private String otpCode;
	private LocalDateTime otpCodeExpiresAt;
	private String question;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDateTime getCreateAt() {
		return createAt;
	}
	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}
	public LocalDateTime getUpdateedAt() {
		return updateedAt;
	}
	public void setUpdateedAt(LocalDateTime updateedAt) {
		this.updateedAt = updateedAt;
	}
	public Integer getEnabled() {
		return enabled;
	}
	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public LocalDateTime getNextOtpCodeAfterDate() {
		return nextOtpCodeAfterDate;
	}
	public void setNextOtpCodeAfterDate(LocalDateTime nextOtpCodeAfterDate) {
		this.nextOtpCodeAfterDate = nextOtpCodeAfterDate;
	}
	public String getOtpCode() {
		return otpCode;
	}
	public void setOtpCode(String otpCode) {
		this.otpCode = otpCode;
	}
	public LocalDateTime getOtpCodeExpiresAt() {
		return otpCodeExpiresAt;
	}
	public void setOtpCodeExpiresAt(LocalDateTime otpCodeExpiresAt) {
		this.otpCodeExpiresAt = otpCodeExpiresAt;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public User(Integer id, LocalDateTime createAt, LocalDateTime updateedAt, Integer enabled, String email,
			String password, String name, String surname, LocalDateTime nextOtpCodeAfterDate, String otpCode,
			LocalDateTime otpCodeExpiresAt, String question) {
		super();
		this.id = id;
		this.createAt = createAt;
		this.updateedAt = updateedAt;
		this.enabled = enabled;
		this.email = email;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.nextOtpCodeAfterDate = nextOtpCodeAfterDate;
		this.otpCode = otpCode;
		this.otpCodeExpiresAt = otpCodeExpiresAt;
		this.question = question;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", createAt=" + createAt + ", updateedAt=" + updateedAt + ", enabled=" + enabled
				+ ", email=" + email + ", password=" + password + ", name=" + name + ", surname=" + surname
				+ ", nextOtpCodeAfterDate=" + nextOtpCodeAfterDate + ", otpCode=" + otpCode + ", otpCodeExpiresAt="
				+ otpCodeExpiresAt + ", question=" + question + "]";
	}
   

}
