package it.exolab.tesina.auction.service.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.exolab.tesina.auction.model.AuctionOrder;
import it.exolab.tesina.auction.model.Invoice;
import it.exolab.tesina.auction.model.User;
import it.exolab.tesina.auction.model.UserItem;
import it.exolab.tesina.auction.repository.AuctionOrderRepo;


public class AuctionOrderService {
	
	private AuctionOrderRepo auctionOrderRepo;
	
	@Autowired(required = true)
	public void setAuctionOrderRepo(AuctionOrderRepo auctionOrderRepo) {
		this.auctionOrderRepo = auctionOrderRepo;
	}
	
	public AuctionOrder find(int id) {
		return auctionOrderRepo.findOne(id);
	}

	public List<AuctionOrder> findAll() {
		return (List<AuctionOrder>) auctionOrderRepo.findAll();
	}

	public void save(AuctionOrder model) {
		this.auctionOrderRepo.save(model);
	}

	public void delete(int id) {
		auctionOrderRepo.delete(id);
	}
    public List<AuctionOrder> findAuctionOrderByAuctionId(Integer auctionId) {
		return auctionOrderRepo.findAuctionOrderByAuctionId(auctionId);
	}
 
    public List<AuctionOrder> findbyUserId(Integer userId) {
		return auctionOrderRepo.finbyUserId(userId) ;
		
	}
    
    public List<AuctionOrder> finbyWinnerUserReturnAuctionUser(Integer userId) {
		return auctionOrderRepo.finbyWinnerUserReturnAuctionUser(userId) ;
		
	}
}
