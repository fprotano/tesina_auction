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
public class Staff {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer id;
	
	@Column(name="role_id")
	public Integer roleId;
	
	private String email, password, name, surname;
	
	@Column(name="otp_code")
	private String otpCode;
	
	@Column(name="created_at")
	private LocalDateTime createAt;
	
	@Column(name="updated_at")
	private LocalDateTime updatedAt;
	
	@Column(name="next_otp_code_after_date")
	private LocalDateTime nextOtpCodeAfterDate;
	
	@Column(name="otp_code_expires_at")
	private LocalDateTime otpCodeExpiresAt;

	
	public Staff() {

	}

	public Staff(Integer id, Integer roleId, String email, String password, String name, String surname, String otpCode,
			LocalDateTime createAt, LocalDateTime updatedAt, LocalDateTime nextOtpCodeAfterDate,
			LocalDateTime otpCodeExpiresAt) {
		this.id = id;
		this.roleId = roleId;
		this.email = email;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.otpCode = otpCode;
		this.createAt = createAt;
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

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
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

	public String getOtpCode() {
		return otpCode;
	}

	public void setOtpCode(String otpCode) {
		this.otpCode = otpCode;
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
		return "Staff [id=" + id + ", roleId=" + roleId + ", email=" + email + ", password=" + password + ", name="
				+ name + ", surname=" + surname + ", otpCode=" + otpCode + ", createAt=" + createAt + ", updatedAt="
				+ updatedAt + ", nextOtpCodeAfterDate=" + nextOtpCodeAfterDate + ", otpCodeExpiresAt="
				+ otpCodeExpiresAt + "]";
	}
}
