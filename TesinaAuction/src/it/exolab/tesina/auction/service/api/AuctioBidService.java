package it.exolab.tesina.auction.service.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.exolab.tesina.auction.api.model.dto.AuctionBidDTO;
import it.exolab.tesina.auction.repository.AuctionBidRepo;

public class AuctioBidService {
private AuctionBidRepo auctionBidRepo;
	
	@Autowired(required = true)
	public void setAuctionOrderRepo(AuctionBidRepo auctionBidRepo) {
		this.auctionBidRepo =auctionBidRepo;
	}
	
	public AuctionBidDTO find(int id) {
		return auctionBidRepo.findOne(id);
	}

	public List<AuctionBidDTO> findAll() {
		return (List<AuctionBidDTO>) auctionBidRepo.findAll();
	}

	public void save(AuctionBidDTO model) {
		this.auctionBidRepo.save(model);
	}

	public void delete(int id) {
		auctionBidRepo.delete(id);
	}

}
