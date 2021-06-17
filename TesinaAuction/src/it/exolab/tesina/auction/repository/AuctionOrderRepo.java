package it.exolab.tesina.auction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import it.exolab.tesina.auction.model.Auction;
import it.exolab.tesina.auction.model.AuctionOrder;
import it.exolab.tesina.auction.model.User;


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
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("SELECT ao FROM AuctionOrder ao WHERE ao.orderNo=?1")
	public AuctionOrder findbyOrderNo(String orderNo);
	
	
	public AuctionOrder findByOrderNo(String orderNo);
}
