package it.exolab.tesina.auction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import it.exolab.tesina.auction.model.Auction;
import it.exolab.tesina.auction.model.AuctionBid;


public interface AuctionBidRepo extends CrudRepository<AuctionBid, Integer> {
	
	// insert, findbyid, findByAuctionID, findByUserIdWhereClosedAt=null
	
	/*
	 * 	
	@Transactional
	@Modifying
	@Query("SELECT a FROM Auction AS a "
			+ " JOIN FETCH a.userItem AS ui "
			+ " JOIN FETCH ui.user AS u "
			+ "WHERE u.id=?1")
	public List<Auction> findAuctionsbyUser(Integer idUser);
	 * 
	 */
	
	@Transactional
	@Modifying
	@Query("SELECT b FROM AuctionBid b "
			+ " JOIN FETCH b.bidAuction ab"
			+ " WHERE ab.id = ?1 ")
	public List<AuctionBid> findBidsByAuctionId(Integer idAuction);
	
	@Transactional
	@Modifying
	@Query("SELECT b FROM AuctionBid b "
			+ " JOIN FETCH b.bidAuction a "
			+ " JOIN FETCH b.userBid ub "
			+ " JOIN FETCH a.userItem "
			+ " WHERE a.endAuctionAt is null AND ub.id = ?1 ")
	public List<AuctionBid> findBidsOfActiveAuctionsByUserId(Integer idUser);
	
//	@Transactional
//	@Modifying
//	@Query(" SELECT bids FROM it.exolab.tesina.auction.model.AuctionBid as bids, "
//			+ " it.exolab.tesina.auction.model.Auction as auction "
//			+ " WHERE auction.id = bids.auctionId "
//				+ " AND auction.closedAuctionAt is null "
//				+ " AND bids.userId = ?1 "
//			+ " ORDER BY bids.createAt DESC")
//	public List<AuctionBid> findBidsOfActiveAuctionsByUserId(Integer idUser);

	
	@Transactional
	@Modifying
	@Query("SELECT b FROM AuctionBid b "
			+ " JOIN FETCH b.bidAuction a "
			+ " JOIN FETCH b.userBid ub "
			+ " JOIN FETCH a.userItem "
			+ " WHERE a.endAuctionAt is null AND ub.id = ?1 "
			+ " GROUP BY a.id")
	public List<AuctionBid> findLastBidsOfActiveAuctionsByUserId(Integer idUser);
	
	
//	@Transactional
//	@Modifying
//	@Query(" SELECT bids FROM it.exolab.tesina.auction.model.AuctionBid as bids, "
//			+ " it.exolab.tesina.auction.model.Auction as auction "
//			+ " WHERE auction.id = bids.auctionId "
//				+ " AND auction.closedAuctionAt is null "
//				+ " AND bids.userId = ?1 "
//			+ " GROUP BY auction.id "
//			+ " ORDER BY bids.createAt DESC")
//	public List<AuctionBid> findLastBidsOfActiveAuctionsByUserId(Integer idUser);

}

