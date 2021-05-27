package it.exolab.tesina.auction.service.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.exolab.tesina.auction.api.model.dto.AuctionOrderDTO;

import it.exolab.tesina.auction.repository.AuctionOrderRepo;


public class AuctionOrderService {
	
	private AuctionOrderRepo auctionOrderRepo;
	
	@Autowired(required = true)
	public void setAuctionOrderRepo(AuctionOrderRepo auctionOrderRepo) {
		this.auctionOrderRepo = auctionOrderRepo;
	}
	
	public AuctionOrderDTO find(int id) {
		return auctionOrderRepo.findOne(id);
	}

	public List<AuctionOrderDTO> findAll() {
		return (List<AuctionOrderDTO>) auctionOrderRepo.findAll();
	}

	public void save(AuctionOrderDTO model) {
		this.auctionOrderRepo.save(model);
	}

	public void delete(int id) {
		auctionOrderRepo.delete(id);
	}

}
