package it.exolab.tesina.auction.api.model.dto;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import it.exolab.tesina.auction.model.HelpCenter;
import it.exolab.tesina.auction.model.HelpCenterThread;

public class HelpCenterThreadDTO {
	
	private Integer id;
	private Timestamp createdAt;
	private Integer helpCenterId;
	private String question;
	private String answer;
	
	public HelpCenterThreadDTO() {
		super();
	}

	public HelpCenterThreadDTO(HelpCenterThread model) {
		super();
		this.id = model.getId();
		this.createdAt = model.getCreatedAt();
		this.helpCenterId = model.getHelpCenterId();
		this.question = model.getQuestion();
		this.answer = model.getAnswer();
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
		HelpCenterThreadDTO other = (HelpCenterThreadDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HelpCenterThreadDTO [id=" + id + ", createdAt=" + createdAt + ", helpCenterId=" + helpCenterId
				+ ", question=" + question + ", answer=" + answer + "]";
	}
	
	

}
