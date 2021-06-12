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
@Table(name="help_center")
public class HelpCenter {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="created_at")
	private Timestamp createdAt;
	
	@Column(name="updated_at")
	private Timestamp updatedAt;
	
	@Column(name="closed_at")
	private Timestamp closedAt;
	
	@Column(name="user_id")
	private Integer userId;
	
	@Fetch(value=FetchMode.JOIN)
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id", nullable=false, insertable=false, updatable=false)
	private User userDidQuestion;
	
	@Column
	private String question;
	
	@Column(name="assigned_to_id")
	private Integer assignedToId;
	
	@Fetch(value=FetchMode.JOIN)
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="assigned_to_id", nullable=false, insertable=false, updatable=false)
	private Staff staffAssigned;
	
	@OneToMany(mappedBy="helpCenterForThread", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<HelpCenterThread> helpThreads;
	

	public HelpCenter() {
	
	}


	public HelpCenter(Timestamp createdAt, Timestamp updatedAt, Timestamp closedAt, Integer userId,
			User userDidQuestion, String question, Integer assignedToId, Staff staffAssigned,
			List<HelpCenterThread> helpThreads) {
		super();
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.closedAt = closedAt;
		this.userId = userId;
		this.userDidQuestion = userDidQuestion;
		this.question = question;
		this.assignedToId = assignedToId;
		this.staffAssigned = staffAssigned;
		this.helpThreads = helpThreads;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Timestamp getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}


	public Timestamp getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}


	public Timestamp getClosedAt() {
		return closedAt;
	}


	public void setClosedAt(Timestamp closedAt) {
		this.closedAt = closedAt;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public User getUserDidQuestion() {
		return userDidQuestion;
	}


	public void setUserDidQuestion(User userDidQuestion) {
		this.userDidQuestion = userDidQuestion;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public Integer getAssignedToId() {
		return assignedToId;
	}


	public void setAssignedToId(Integer assignedToId) {
		this.assignedToId = assignedToId;
	}


	public Staff getStaffAssigned() {
		return staffAssigned;
	}


	public void setStaffAssigned(Staff staffAssigned) {
		this.staffAssigned = staffAssigned;
	}


	public List<HelpCenterThread> getHelpThreads() {
		return helpThreads;
	}


	public void setHelpThreads(List<HelpCenterThread> helpThreads) {
		this.helpThreads = helpThreads;
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
		HelpCenter other = (HelpCenter) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "HelpCenter [id=" + id + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", closedAt="
				+ closedAt + ", userId=" + userId + ", userDidQuestion=" + userDidQuestion + ", question=" + question
				+ ", assignedToId=" + assignedToId + ", staffAssigned=" + staffAssigned + ", helpThreads=" + helpThreads
				+ "]";
	}
	
	
	

}
