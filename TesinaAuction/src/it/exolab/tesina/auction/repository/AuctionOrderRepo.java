package it.exolab.tesina.auction.repository;

import org.springframework.data.repository.CrudRepository;

import it.exolab.tesina.auction.api.model.dto.AuctionOrderDTO;

public interface AuctionOrderRepo extends CrudRepository<AuctionOrderDTO, Integer>{

}
