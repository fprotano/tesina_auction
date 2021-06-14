package it.exolab.tesina.auction.service.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.exolab.tesina.auction.model.HelpCenterThread;
import it.exolab.tesina.auction.repository.HelpCenterThreadRepo;




public class HelpCenterThreadService {
	private HelpCenterThreadRepo helpCenterThreadRepo;

	@Autowired(required = true)
	public void setAuctionRepo(HelpCenterThreadRepo helpCenterThread) {
		this.helpCenterThreadRepo = helpCenterThread;

	}

	public HelpCenterThread find(int id) {
		return helpCenterThreadRepo.findOne(id);
	}

	public List<HelpCenterThread> findAll() {
		return (List<HelpCenterThread>) helpCenterThreadRepo.findAll();
	}

	public void save(HelpCenterThread model) {
		this.helpCenterThreadRepo.save(model);
	}

	public void delete(int id) {
		helpCenterThreadRepo.delete(id);
	}
	
	public List<HelpCenterThread> getThreadsByHelpCenterId (Integer id){
		return this.helpCenterThreadRepo.findByHelpCenterId(id);
	}
	
	public void updateAnswerThread(Integer id, String answer) {
		this.helpCenterThreadRepo.updateAnswerThread(id, answer);
	}


}
