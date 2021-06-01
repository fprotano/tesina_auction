package it.exolab.tesina.auction.service.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.exolab.tesina.auction.model.AuctionBid;
import it.exolab.tesina.auction.repository.AuctionBidRepo;

public class AuctionBidService {
private AuctionBidRepo auctionBidRepo;
	
	@Autowired(required = true)
	public void setAuctionOrderRepo(AuctionBidRepo auctionBidRepo) {
		this.auctionBidRepo =auctionBidRepo;
	}
	
	public AuctionBid find(int id) {
		return auctionBidRepo.findOne(id);
	}

	public List<AuctionBid> findAll() {
		return (List<AuctionBid>) auctionBidRepo.findAll();
	}

	public void save(AuctionBid model) {
		this.auctionBidRepo.save(model);
	}

	public void delete(int id) {
		auctionBidRepo.delete(id);
	}

	public List<AuctionBid> findBidsByAuctionId(int id) {
		return (List<AuctionBid>) auctionBidRepo.findBidsByAuctionId(id);
	}

	public List<AuctionBid> findBidsOfActiveAuctionsByUserId(int id) {
		return (List<AuctionBid>) auctionBidRepo.findBidsOfActiveAuctionsByUserId(id);
	}

	public List<AuctionBid> findLastBidsOfActiveAuctionsByUserId(int id) {
		return (List<AuctionBid>) auctionBidRepo.findLastBidsOfActiveAuctionsByUserId(id);
	}
	
	

}
