package it.exolab.tesina.auction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.exolab.tesina.auction.api.model.dto.AuctionDTO;

import it.exolab.tesina.auction.repository.AuctionRepo;


public class AuctionService {
	
	private AuctionRepo auctionRepo;
	
	@Autowired(required = true)
	public void setAuctionRepo(AuctionRepo auctionRepo) {
		this.auctionRepo = auctionRepo;

	}

	public AuctionDTO find(int id) {
		return auctionRepo.findOne(id);
	}

	public List<AuctionDTO> findAll() {
		return (List<AuctionDTO>) auctionRepo.findAll();
	}

	public void save(AuctionDTO model) {
		this.auctionRepo.save(model);
	}

	public void delete(int id) {
		auctionRepo.delete(id);
	}

}
