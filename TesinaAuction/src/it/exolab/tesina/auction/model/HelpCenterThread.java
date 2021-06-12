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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
@Entity
@Table(name="help_center_thread")
public class HelpCenterThread {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="created_at")
	private Timestamp createdAt;
	
	@Column(name="help_center_id")
	private Integer helpCenterId;
	
	@Fetch(value=FetchMode.JOIN)
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="help_center_id", nullable=false, insertable=false, updatable=false)
	private HelpCenter helpCenterForThread;
	
	@Column
	private String question;
	
	@Column
	private String answer;

	public HelpCenterThread() {
		
	}

	public HelpCenterThread(Timestamp createdAt, Integer helpCenterId, HelpCenter helpCenterForThread, String question,
			String answer) {
	
		this.createdAt = createdAt;
		this.helpCenterId = helpCenterId;
		this.helpCenterForThread = helpCenterForThread;
		this.question = question;
		this.answer = answer;
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

	public Integer getHelpCenterId() {
		return helpCenterId;
	}

	public void setHelpCenterId(Integer helpCenterId) {
		this.helpCenterId = helpCenterId;
	}

	public HelpCenter getHelpCenterForThread() {
		return helpCenterForThread;
	}

	public void setHelpCenterForThread(HelpCenter helpCenterForThread) {
		this.helpCenterForThread = helpCenterForThread;
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
		HelpCenterThread other = (HelpCenterThread) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HelpCenterThread [id=" + id + ", createdAt=" + createdAt + ", helpCenterId=" + helpCenterId
				+ ", helpCenterForThread=" + helpCenterForThread + ", question=" + question + ", answer=" + answer
				+ "]";
	}
	
	
	

}
