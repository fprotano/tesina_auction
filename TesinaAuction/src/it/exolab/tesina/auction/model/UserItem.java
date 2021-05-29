package it.exolab.tesina.auction.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="user_item")
public class UserItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="sold_to_user_id")
	private Integer soldToUserId;
	
	@Column(name="user_id")
	private Integer userId;
	
	private String title, description, notes, picture1, picture2, picture3, picture4, picture5;
	
	@Column(name="created_at")
	private Timestamp createdAt;
	
	@Column(name="updated_at")
	private Timestamp updatedAt;
	
	@Column(name="sold_at")
	private Timestamp soldAt;
	
	@Fetch(value=FetchMode.JOIN)
	@OneToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="user_id", nullable=false,insertable=false, updatable=false)
	private User user;

	public UserItem() {
	
	}

	public UserItem(Integer soldToUserId, Integer userId, String title, String description, String notes,
			String picture1, String picture2, String picture3, String picture4, String picture5,
			Timestamp createdAt, Timestamp updatedAt, Timestamp soldAt) {

		this.soldToUserId = soldToUserId;
		this.userId = userId;
		this.title = title;
		this.description = description;
		this.notes = notes;
		this.picture1 = picture1;
		this.picture2 = picture2;
		this.picture3 = picture3;
		this.picture4 = picture4;
		this.picture5 = picture5;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.soldAt = soldAt;
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSoldToUserId() {
		return soldToUserId;
	}

	public void setSoldToUserId(Integer soldToUserId) {
		this.soldToUserId = soldToUserId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getPicture1() {
		return picture1;
	}

	public void setPicture1(String picture1) {
		this.picture1 = picture1;
	}

	public String getPicture2() {
		return picture2;
	}

	public void setPicture2(String picture2) {
		this.picture2 = picture2;
	}

	public String getPicture3() {
		return picture3;
	}

	public void setPicture3(String picture3) {
		this.picture3 = picture3;
	}

	public String getPicture4() {
		return picture4;
	}

	public void setPicture4(String picture4) {
		this.picture4 = picture4;
	}

	public String getPicture5() {
		return picture5;
	}

	public void setPicture5(String picture5) {
		this.picture5 = picture5;
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

	public Timestamp getSoldAt() {
		return soldAt;
	}

	public void setSoldAt(Timestamp soldAt) {
		this.soldAt = soldAt;
	}

	@Override
	public String toString() {
		return "UserItem [id=" + id + ", soldToUserId=" + soldToUserId + ", userId=" + userId + ", title=" + title
				+ ", description=" + description + ", notes=" + notes + ", picture1=" + picture1 + ", picture2="
				+ picture2 + ", picture3=" + picture3 + ", picture4=" + picture4 + ", picture5=" + picture5
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", soldAt=" + soldAt + "]";
	}
}
