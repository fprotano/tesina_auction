package it.exolab.tesina.auction.service.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.exolab.tesina.auction.model.AuctionOrderTransactionLog;
import it.exolab.tesina.auction.repository.AuctionOrderTransactionLogRepo;

public class AuctionOrderTransactionLogService {

	private AuctionOrderTransactionLogRepo auctionOrderTransactionLogRepo;

	@Autowired(required = true)
	public void setAuctionOrderTransactionLogRepo(AuctionOrderTransactionLogRepo auctionOrderTransactionLogRepo) {
		this.auctionOrderTransactionLogRepo = auctionOrderTransactionLogRepo;

	}

	public AuctionOrderTransactionLog find(int id) {
		return this.auctionOrderTransactionLogRepo.findOne(id);
	}

	public List<AuctionOrderTransactionLog> findAll() {
		return (List<AuctionOrderTransactionLog>) auctionOrderTransactionLogRepo.findAll();
	}

	public void save(AuctionOrderTransactionLog model) {
		this.auctionOrderTransactionLogRepo.save(model);
	}

	public void delete(int id) {
		auctionOrderTransactionLogRepo.delete(id);
	}

}
