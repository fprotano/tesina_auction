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
public class HelpCenterThread {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="create_at")
	private LocalDateTime createAt;
	@Column(name="help_center_id")
	private Integer helpCenterId;
	private String question;
	private String answer;

	public HelpCenterThread(LocalDateTime createAt, Integer helpCenterId, String question, String answer) {
		super();
		this.createAt = createAt;
		this.helpCenterId = helpCenterId;
		this.question = question;
		this.answer = answer;
	}

	public HelpCenterThread() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
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
	public String toString() {
		return "HelpCenterThread [id=" + id + ", createAt=" + createAt + ", helpCenterId=" + helpCenterId
				+ ", question=" + question + ", answer=" + answer + "]";
	}

}
