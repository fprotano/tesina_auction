package it.exolab.tesina.auction.repository;

import org.springframework.data.repository.CrudRepository;

import it.exolab.tesina.auction.api.model.dto.AuctionBidDTO;


public interface AuctionBidRepo extends   CrudRepository<AuctionBidDTO, Integer>{

}

