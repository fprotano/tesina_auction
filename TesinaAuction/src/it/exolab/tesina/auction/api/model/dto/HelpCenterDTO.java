package it.exolab.tesina.auction.api.model.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import it.exolab.tesina.auction.model.HelpCenter;
import it.exolab.tesina.auction.model.HelpCenterThread;
import it.exolab.tesina.auction.model.Staff;
import it.exolab.tesina.auction.model.User;

public class HelpCenterDTO {
	
	private Integer id;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	private Timestamp closedAt;
	private Integer userId; 
	private User userDidQuestion;
	private String question;
	private Integer assignedToId;
	private Staff staffAssigned;
	private List<HelpCenterThreadDTO> helpThreads;
	
	public HelpCenterDTO() {
		super();
	}

	public HelpCenterDTO(HelpCenter model) {
		super();
		this.id = model.getId();
		this.createdAt = model.getCreatedAt();
		this.updatedAt = model.getUpdatedAt();
		this.closedAt = model.getClosedAt();
		this.userId = model.getUserId();
		this.userDidQuestion = model.getUserDidQuestion();
		this.question = model.getQuestion();
		this.assignedToId = model.getAssignedToId();
		this.staffAssigned = model.getStaffAssigned();
		this.helpThreads= new ArrayList<HelpCenterThreadDTO>();
		List<HelpCenterThread> ht = model.getHelpThreads();
		for(HelpCenterThread lht : ht) {
			HelpCenterThreadDTO hctDTO = new HelpCenterThreadDTO(lht);
			this.helpThreads.add(hctDTO);
		}
		
	}

	public HelpCenterDTO(Integer id, Timestamp createdAt, Timestamp updatedAt, Timestamp closedAt, String question,
			Staff staffAssigned, List<HelpCenterThread> helpThreads) {
		super();
		this.id = id;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.closedAt = closedAt;
		this.question = question;
		this.staffAssigned = staffAssigned;
		this.helpThreads= new ArrayList<HelpCenterThreadDTO>();
		for(HelpCenterThread lht : helpThreads) {
			HelpCenterThreadDTO hctDTO = new HelpCenterThreadDTO(lht);
			this.helpThreads.add(hctDTO);
		}
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

	public List<HelpCenterThreadDTO> getHelpThreads() {
		return helpThreads;
	}

	public void setHelpThreads(List<HelpCenterThreadDTO> helpThreads) {
		this.helpThreads = helpThreads;
	}
	
	public static HelpCenterDTO setHelpCenterDTOForUser(HelpCenter model) {
		return new HelpCenterDTO(model.getId(), model.getCreatedAt(), model.getUpdatedAt(), 
								 model.getClosedAt(), model.getQuestion(), model.getStaffAssigned(),
								 model.getHelpThreads());
	}
	
	public static List<HelpCenterDTO> setListHelpCenterDTOForUser(List<HelpCenter> model) {
		List<HelpCenterDTO> ret = new ArrayList<HelpCenterDTO>();
		for(HelpCenter hc: model)
			ret.add(HelpCenterDTO.setHelpCenterDTOForUser(hc));
		return ret;
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
		HelpCenterDTO other = (HelpCenterDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HelpCenterDTO [id=" + id + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", closedAt="
				+ closedAt + ", userId=" + userId + ", question=" + question + ", assignedToId=" + assignedToId + "]";
	}
	
	
	
	

}
