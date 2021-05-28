package it.exolab.tesina.auction.repository;

import org.springframework.data.repository.CrudRepository;

import it.exolab.tesina.auction.api.model.dto.AuctionOrderStatusDTO;

public interface AuctionOrderStatusRepo extends CrudRepository <AuctionOrderStatusDTO,Integer>{

}
