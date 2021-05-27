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
public class Auction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer id;
	
	public Integer enabled;
	public String email, password, name, surname, question, answer;
	
	@Column(name="otp_code")
	public String otpCode;
	
	@Column(name="created_at")
	public LocalDateTime createdAt;
	
	@Column(name="updated_at")
	public LocalDateTime updatedAt;
	
	@Column(name="next_otp_code_after_date")
	public LocalDateTime nextOtpCodeAfterDate;
	
	@Column(name="otp_code_expires_at")
	public LocalDateTime otpCodeExpiresAt;

	
	public Auction() {
		super();
	}
	
	public Auction(Integer enabled, String email, String password, String name, String surname, String question,
			String answer, String otpCode, LocalDateTime createdAt, LocalDateTime updatedAt,
			LocalDateTime nextOtpCodeAfterDate, LocalDateTime otpCodeExpiresAt) {
		this.enabled = enabled;
		this.email = email;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.question = question;
		this.answer = answer;
		this.otpCode = otpCode;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.nextOtpCodeAfterDate = nextOtpCodeAfterDate;
		this.otpCodeExpiresAt = otpCodeExpiresAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getOtpCode() {
		return otpCode;
	}

	public void setOtpCode(String otpCode) {
		this.otpCode = otpCode;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public LocalDateTime getNextOtpCodeAfterDate() {
		return nextOtpCodeAfterDate;
	}

	public void setNextOtpCodeAfterDate(LocalDateTime nextOtpCodeAfterDate) {
		this.nextOtpCodeAfterDate = nextOtpCodeAfterDate;
	}
	
	public LocalDateTime getOtpCodeExpiresAt() {
		return otpCodeExpiresAt;
	}

	public void setOtpCodeExpiresAt(LocalDateTime otpCodeExpiresAt) {
		this.otpCodeExpiresAt = otpCodeExpiresAt;
	}

	@Override
	public String toString() {
		return "Auction [id=" + id + ", enabled=" + enabled + ", email=" + email + ", password=" + password + ", name="
				+ name + ", surname=" + surname + ", question=" + question + ", answer=" + answer + ", otpCode="
				+ otpCode + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", nextOtpCodeAfterDate="
				+ nextOtpCodeAfterDate + ", otpCodeExpiresAt=" + otpCodeExpiresAt + "]";
	}
	
	
	
	
}
	