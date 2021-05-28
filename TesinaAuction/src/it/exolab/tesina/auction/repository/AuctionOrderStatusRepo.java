package it.exolab.tesina.auction.repository;

import org.springframework.data.repository.CrudRepository;

import it.exolab.tesina.auction.model.AuctionOrderStatus;

public interface AuctionOrderStatusRepo extends CrudRepository <AuctionOrderStatus,Integer>{

}
