package it.exolab.tesina.auction.repository;

import org.springframework.data.repository.CrudRepository;

import it.exolab.tesina.auction.model.AuctionOrderTransactionLog;



public interface AuctionOrderTransactionLogRepo extends CrudRepository<AuctionOrderTransactionLog, Integer>{

}
