package it.exolab.tesina.auction.service.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.exolab.tesina.auction.api.model.dto.AuctionOrderStatusDTO;
import it.exolab.tesina.auction.repository.AuctionOrderStatusRepo;

public class AuctionOrderStatusService {

	private AuctionOrderStatusRepo auctionOrderStatusRepo;

	@Autowired(required = true)
	public void setAuctionOrderRepo(AuctionOrderStatusRepo auctionOrderStatusRepo) {
		this.auctionOrderStatusRepo = auctionOrderStatusRepo;
	}

	public AuctionOrderStatusDTO find(int id) {
		return auctionOrderStatusRepo.findOne(id);
	}

	public List<AuctionOrderStatusDTO> findAll() {
		return (List<AuctionOrderStatusDTO>) auctionOrderStatusRepo.findAll();
	}

	public void save(AuctionOrderStatusDTO model) {
		this.auctionOrderStatusRepo.save(model);
	}

	public void delete(int id) {
		auctionOrderStatusRepo.delete(id);
	}

}
