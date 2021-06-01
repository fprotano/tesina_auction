package it.exolab.tesina.auction.service.api;

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

	public Auction find(int id) {
		return auctionRepo.findOne(id);
	}

	public List<Auction> findAll() {
		return (List<Auction>) auctionRepo.findAll();
	}

	public void save(Auction model) {
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
}
