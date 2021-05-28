package it.exolab.tesina.auction.service.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.exolab.tesina.auction.api.model.dto.HelpCenterDTO;
import it.exolab.tesina.auction.repository.HelpCenterRepo;

public class HelpCenterService {
	private HelpCenterRepo helpCenterRepo;

	@Autowired(required = true)
	public void setAuctionRepo(HelpCenterRepo helpCenterRepo) {
		this.helpCenterRepo = helpCenterRepo;

	}

	public HelpCenterDTO find(int id) {
		return helpCenterRepo.findOne(id);
	}

	public List<HelpCenterDTO> findAll() {
		return (List<HelpCenterDTO>) helpCenterRepo.findAll();
	}

	public void save(HelpCenterDTO model) {
		this.helpCenterRepo.save(model);
	}

	public void delete(int id) {
		helpCenterRepo.delete(id);
	}
}
