package it.exolab.tesina.auction.service.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.exolab.tesina.auction.model.AuctionOrderStatus;
import it.exolab.tesina.auction.repository.AuctionOrderStatusRepo;

public class AuctionOrderStatusService {

	private AuctionOrderStatusRepo auctionOrderStatusRepo;

	@Autowired(required = true)
	public void setAuctionOrderRepo(AuctionOrderStatusRepo auctionOrderStatusRepo) {
		this.auctionOrderStatusRepo = auctionOrderStatusRepo;
	}

	public AuctionOrderStatus find(int id) {
		return auctionOrderStatusRepo.findOne(id);
	}

	public List<AuctionOrderStatus> findAll() {
		return (List<AuctionOrderStatus>) auctionOrderStatusRepo.findAll();
	}

	public void save(AuctionOrderStatus model) {
		this.auctionOrderStatusRepo.save(model);
	}

	public void delete(int id) {
		auctionOrderStatusRepo.delete(id);
	}

}
