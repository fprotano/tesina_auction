package it.exolab.tesina.auction.repository;

import org.springframework.data.repository.CrudRepository;

import it.exolab.tesina.auction.api.model.dto.AuctionDTO;


public interface AuctionRepo extends CrudRepository<AuctionDTO, Integer> {

}
