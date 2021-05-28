package it.exolab.tesina.auction.service.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.exolab.tesina.auction.api.model.dto.HelpCenterThreadDTO;
import it.exolab.tesina.auction.repository.HelpCenterThreadRepo;




public class HelpCenterThreadService {
	private HelpCenterThreadRepo helpCenterThreadRepo;

	@Autowired(required = true)
	public void setAuctionRepo(HelpCenterThreadRepo helpCenterThread) {
		this.helpCenterThreadRepo = helpCenterThread;

	}

	public HelpCenterThreadDTO find(int id) {
		return helpCenterThreadRepo.findOne(id);
	}

	public List<HelpCenterThreadDTO> findAll() {
		return (List<HelpCenterThreadDTO>) helpCenterThreadRepo.findAll();
	}

	public void save(HelpCenterThreadDTO model) {
		this.helpCenterThreadRepo.save(model);
	}

	public void delete(int id) {
		helpCenterThreadRepo.delete(id);
	}


}
