package it.exolab.tesina.auction.service.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.exolab.tesina.auction.api.model.dto.AuctionOrderTransactionLogDTO;
import it.exolab.tesina.auction.repository.AuctionOrderTransactionLogRepo;

public class AuctionOrderTransactionLogService {

	private AuctionOrderTransactionLogRepo auctionOrderTransactionLogRepo;

	@Autowired(required = true)
	public void setAuctionOrderTransactionLogRepo(AuctionOrderTransactionLogRepo auctionOrderTransactionLogRepo) {
		this.auctionOrderTransactionLogRepo = auctionOrderTransactionLogRepo;

	}

	public AuctionOrderTransactionLogDTO find(int id) {
		return this.auctionOrderTransactionLogRepo.findOne(id);
	}

	public List<AuctionOrderTransactionLogDTO> findAll() {
		return (List<AuctionOrderTransactionLogDTO>) auctionOrderTransactionLogRepo.findAll();
	}

	public void save(AuctionOrderTransactionLogDTO model) {
		this.auctionOrderTransactionLogRepo.save(model);
	}

	public void delete(int id) {
		auctionOrderTransactionLogRepo.delete(id);
	}

}
