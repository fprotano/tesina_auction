package it.exolab.tesina.auction.service.api;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.exolab.tesina.auction.model.Auction;
import it.exolab.tesina.auction.repository.AuctionRepo;



public class AuctionService {

	private AuctionRepo auctionRepo;

	@Autowired(required = true)
	public void setAuctionRepo(AuctionRepo auctionRepo) {
		this.auctionRepo = auctionRepo;

	}

	public Auction findById(int id) {
		return auctionRepo.findById(id);
	}

	public List<Auction> findAll() {
		return (List<Auction>) auctionRepo.findAll();
	}

	public void save(Auction model) {
		model.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		this.auctionRepo.save(model);
	}

	public void delete(int id) {
		auctionRepo.delete(id);
	}
	
	public List<Auction> findAuctionsByUser(Integer idUser) {
		return auctionRepo.findAuctionsbyUser(idUser);
	}
	public List<Auction> findAllAuctions() {
		return auctionRepo.findAllAuctions();
	}
	
	public void closeAuction(Integer id) {
		auctionRepo.closeAuction(id);
	}
	
	public void closeAllExpiredAuctions() {
		auctionRepo.closeAllExpiredAuctions();
	}
	
	public void closeExpiredAuction(Integer id) {
		auctionRepo.closeAuction(id);
	}
	
	public void updateCurrentBid(Integer id, Double currentBid, Integer userId) {
		auctionRepo.updateCurrentBid(id, currentBid, userId);
	}
}
