package it.exolab.tesina.auction.repository;

import org.springframework.data.repository.CrudRepository;

import it.exolab.tesina.auction.model.Auction;


public interface AuctionRepo extends CrudRepository<Auction, Integer>{

}
