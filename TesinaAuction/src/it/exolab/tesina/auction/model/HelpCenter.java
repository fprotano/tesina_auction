package it.exolab.tesina.auction.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="help_center")
public class HelpCenter {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="create_at")
	private Timestamp createdAt;
	@Column(name="update_at")
	private Timestamp updatedAt;
	@Column(name="closed_at")
	private Timestamp closedAt;
	@Column(name="user_id")
	private Integer userId;
	private String question;
	@Column(name="assigned_to_id")
	private Integer assignedToId;

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

	@Override
	public String toString() {
		return "HelpCenter [id=" + id + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", closedAt="
				+ closedAt + ", userId=" + userId + ", question=" + question + ", assignedToId=" + assignedToId + "]";
	}

	public HelpCenter(Timestamp createdAt, Timestamp updatedAt, Timestamp closedAt, Integer userId,
			String question, Integer assignedToId) {
		super();
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.closedAt = closedAt;
		this.userId = userId;
		this.question = question;
		this.assignedToId = assignedToId;
	}

	public HelpCenter() {
		super();
		// TODO Auto-generated constructor stub
	}

}
