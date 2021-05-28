package it.exolab.tesina.auction.model;


import java.sql.Timestamp;


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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer enabled;

	private String email, password, name, surname, question, answer;

	@Column(name = "otp_code")
	private String otpCode;

	@Column(name = "created_at")
	private Timestamp createAt;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@Column(name = "next_otp_code_after_date")
	private Timestamp nextOtpCodeAfterDate;

	@Column(name = "otp_code_expires_at")
	private Timestamp otpCodeExpiresAt;

	
	public User(Integer enabled, String email, String password, String name, String surname, String question,
			String answer, String otpCode, Timestamp createAt, Timestamp updatedAt, Timestamp nextOtpCodeAfterDate,
			Timestamp otpCodeExpiresAt) {
	
		this.enabled = enabled;
		this.email = email;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.question = question;
		this.answer = answer;
		this.otpCode = otpCode;
		this.createAt = createAt;
		this.updatedAt = updatedAt;
		this.nextOtpCodeAfterDate = nextOtpCodeAfterDate;
		this.otpCodeExpiresAt = otpCodeExpiresAt;
	}

	public User() {

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

	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Timestamp getNextOtpCodeAfterDate() {
		return nextOtpCodeAfterDate;
	}

	public void setNextOtpCodeAfterDate(Timestamp nextOtpCodeAfterDate) {
		this.nextOtpCodeAfterDate = nextOtpCodeAfterDate;
	}

	public Timestamp getOtpCodeExpiresAt() {
		return otpCodeExpiresAt;
	}

	public void setOtpCodeExpiresAt(Timestamp otpCodeExpiresAt) {
		this.otpCodeExpiresAt = otpCodeExpiresAt;
	}

	

}
