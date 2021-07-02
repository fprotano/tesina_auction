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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table
public class Staff {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
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
	private Integer roleId;
	
	@Fetch(value=FetchMode.JOIN)
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="role_id", nullable=false, insertable=false, updatable=false)
	private Role staffRole;
	
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

	public Staff(String email, String password, Timestamp otpCodeExpiresAt) {
		super();
		this.email = email;
		this.password = password;
		this.otpCodeExpiresAt = otpCodeExpiresAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Role getStaffRole() {
		return staffRole;
	}

	public void setStaffRole(Role staffRole) {
		this.staffRole = staffRole;
	}

	public Timestamp getNextOtpCodeAfterDate() {
		return nextOtpCodeAfterDate;
	}

	public void setNextOtpCodeAfterDate(Timestamp nextOtpCodeAfterDate) {
		this.nextOtpCodeAfterDate = nextOtpCodeAfterDate;
	}

	public String getOtpCode() {
		return otpCode;
	}

	public void setOtpCode(String otpCode) {
		this.otpCode = otpCode;
	}

	public Timestamp getOtpCodeExpiresAt() {
		return otpCodeExpiresAt;
	}

	public void setOtpCodeExpiresAt(Timestamp otpCodeExpiresAt) {
		this.otpCodeExpiresAt = otpCodeExpiresAt;
	}

	public List<HelpCenter> getListHelpCenterOfStaff() {
		return listHelpCenterOfStaff;
	}

	public void setListHelpCenterOfStaff(List<HelpCenter> listHelpCenterOfStaff) {
		this.listHelpCenterOfStaff = listHelpCenterOfStaff;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Staff other = (Staff) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Staff [id=" + id + ", createAt=" + createAt + ", updatedAt=" + updatedAt + ", email=" + email
				+ ", password=" + password + ", name=" + name + ", surname=" + surname + ", roleId=" + roleId
				+ ", staffRole=" + staffRole + ", nextOtpCodeAfterDate=" + nextOtpCodeAfterDate + ", otpCode=" + otpCode
				+ ", otpCodeExpiresAt=" + otpCodeExpiresAt + ", listHelpCenterOfStaff=" + listHelpCenterOfStaff + "]";
	}

	
}
