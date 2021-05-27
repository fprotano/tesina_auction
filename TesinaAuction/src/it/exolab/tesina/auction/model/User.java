package it.exolab.tesina.auction.model;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private Integer enabled;
	
	private String email, password, name, surname, question;
	
	@Column(name="otp_code")
	private String otpCode;
	
	@Column(name="create_at")
	private LocalDateTime createAt;
	
	@Column(name="update_at")
	private LocalDateTime updatedAt;
	
	@Column(name="next_otp_code_after_date")
	private LocalDateTime nextOtpCodeAfterDate;
	
	@Column(name="otp_code_expires_at")
	private LocalDateTime otpCodeExpiresAt;

	
	public User(Integer id, LocalDateTime createAt, LocalDateTime updatedAt, Integer enabled, String email,
			String password, String name, String surname, LocalDateTime nextOtpCodeAfterDate, String otpCode,
			LocalDateTime otpCodeExpiresAt, String question) {
		
		this.id = id;
		this.createAt = createAt;
		this.updatedAt = updatedAt;
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
		
	}
	
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
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdateedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
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
	
	@Override
	public String toString() {
		return "User [id=" + id + ", createAt=" + createAt + ", updatedAt=" + updatedAt + ", enabled=" + enabled
				+ ", email=" + email + ", password=" + password + ", name=" + name + ", surname=" + surname
				+ ", nextOtpCodeAfterDate=" + nextOtpCodeAfterDate + ", otpCode=" + otpCode + ", otpCodeExpiresAt="
				+ otpCodeExpiresAt + ", question=" + question + "]";
	}
}
