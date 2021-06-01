package it.exolab.tesina.auction.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.exolab.tesina.auction.model.AuctionOrder;


public interface AuctionOrderRepo extends CrudRepository<AuctionOrder, Integer>{
	public List<AuctionOrder> findByAuction(Integer auctionId);  //
}
