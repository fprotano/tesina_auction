package it.exolab.tesina.auction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import it.exolab.tesina.auction.model.AuctionOrder;


public interface AuctionOrderRepo extends CrudRepository<AuctionOrder, Integer>{
	
	public List<AuctionOrder> findAuctionOrderByAuctionId(Integer auctionId);  //
	

	@Modifying
	@Query("SELECT ao FROM AuctionOrder AS ao"
			+ " JOIN FETCH ao.auction AS a  "
			+ " WHERE a.winnerUserId = ?1 ")
	public List<AuctionOrder> finbyUserId(Integer UserId);
	
	@Modifying
	@Query("SELECT ao FROM AuctionOrder AS ao"
			+ " JOIN FETCH ao.auction AS a  "
			+ " JOIN FETCH a.userItem AS ui "
			+ " JOIN FETCH ui.user AS u "
			+ " WHERE a.winnerUserId = ?1 ")
	public List<AuctionOrder> finbyWinnerUserReturnAuctionUser(Integer UserId);
}
