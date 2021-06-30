package it.exolab.tesina.auction.service.api;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.exolab.tesina.auction.model.HelpCenter;
import it.exolab.tesina.auction.repository.HelpCenterRepo;


public class HelpCenterService {
	private HelpCenterRepo helpCenterRepo;

	@Autowired(required = true)
	public void setAuctionRepo(HelpCenterRepo helpCenterRepo) {
		this.helpCenterRepo = helpCenterRepo;
	}

	public HelpCenter find(int id) {
		return helpCenterRepo.findOne(id);
	}

	public List<HelpCenter> findAll() {
		return (List<HelpCenter>) helpCenterRepo.findAll();
	}

	public void save(HelpCenter model) {
		model.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		this.helpCenterRepo.save(model);
	}

	public void delete(int id) {
		helpCenterRepo.delete(id);
	}
	
	public List<HelpCenter> findbyAssignedIdAndOpen (int assignedId){
		return this.helpCenterRepo.findbyAssignedIdAndOpen(assignedId);
	}
	
	public List<HelpCenter> findOpenHelpCenterAndWaitingAnswer(int assignedId){
		return this.helpCenterRepo.findOpenHelpCenterAndWaitingAnswer(assignedId);
	}
	
	public List<HelpCenter> findByAssignedToId(Integer assignedToId){
		return this.helpCenterRepo.findByAssignedToId(assignedToId);
	}
	
	public List<HelpCenter> findbyUserId(Integer userId){
		return this.helpCenterRepo.findByUserId(userId);
	}
	
}
