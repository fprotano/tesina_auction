package it.exolab.tesina.auction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.exolab.tesina.auction.model.Auction;


public interface AuctionRepo extends CrudRepository<Auction, Integer>{
	
	
	@Query("SELECT a FROM Auction a "
			+ "INNER JOIN UserItem ui ON a.userItemId = ui.id "
			+ "INNER JOIN User u ON ui.userId = u.id "
			+ "WHERE u.id=?1")
	public List<Auction> findAuctionsbyUser(Integer idUser);

}
