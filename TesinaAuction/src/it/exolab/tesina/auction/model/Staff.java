package it.exolab.tesina.auction.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class Staff {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer id;
	
	@Column(name="created_at")
	private Timestamp createAt;
	
	@Column(name="updated_at")
	private Timestamp updatedAt;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
	@Column
	private String  name;
	
	@Column
	private String  surname;
	
	@Column(name="role_id")
	public Integer roleId;
	
	@Column(name="next_otp_code_after_date")
	private Timestamp nextOtpCodeAfterDate;
	
	@Column(name="otp_code")
	private String otpCode;
	
	@Column(name="otp_code_expires_at")
	private Timestamp otpCodeExpiresAt;
	
	@Transient
	@OneToMany(mappedBy="staffAssigned", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<HelpCenter> listHelpCenterOfStaff;

	
	public Staff() {

	}
	
	

	public Staff(Timestamp createAt, String email, String password, String name, String surname, Integer roleId) {
		super();
		this.createAt = createAt;
		this.email = email;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.roleId = roleId;
	}



	public Staff(Integer id, Integer roleId, String email, String password, String name, String surname, String otpCode,
			Timestamp createAt, Timestamp updatedAt, Timestamp nextOtpCodeAfterDate,
			Timestamp otpCodeExpiresAt) {
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

	@Override
	public String toString() {
		return "Staff [id=" + id + ", roleId=" + roleId + ", email=" + email + ", password=" + password + ", name="
				+ name + ", surname=" + surname + ", otpCode=" + otpCode + ", createAt=" + createAt + ", updatedAt="
				+ updatedAt + ", nextOtpCodeAfterDate=" + nextOtpCodeAfterDate + ", otpCodeExpiresAt="
				+ otpCodeExpiresAt + "]";
	}
}
