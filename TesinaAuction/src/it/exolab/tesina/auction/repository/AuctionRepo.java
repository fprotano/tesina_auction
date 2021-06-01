package it.exolab.tesina.auction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import it.exolab.tesina.auction.model.Auction;


public interface AuctionRepo extends CrudRepository<Auction, Integer>{
	
	@Transactional
	@Modifying
	@Query("SELECT a FROM Auction AS a "
			+ " JOIN FETCH a.userItem AS ui "
			+ " JOIN FETCH ui.user AS u "
			+ "WHERE u.id=?1")
	public List<Auction> findAuctionsbyUser(Integer idUser);
	
	@Transactional
	@Modifying
	@Query("SELECT a FROM Auction AS a "
			+ " JOIN FETCH a.userItem AS ui "
			+ " JOIN FETCH ui.user AS u ")
	public List<Auction> findAllAuctions();
	
//	@Transactional
//	@Modifying
//	@Query("SELECT a FROM it.exolab.tesina.auction.model.Auction AS a, "
//			+ "it.exolab.tesina.auction.model.UserItem AS ui, "
//			+ "it.exolab.tesina.auction.model.User AS u "
//			+ "WHERE a.userItemId = ui.id AND "
//			+ "ui.userId = u.id AND "
//			+ "u.id=?1")
//	public List<Auction> findAuctionsbyUser(Integer idUser);
//	
}
