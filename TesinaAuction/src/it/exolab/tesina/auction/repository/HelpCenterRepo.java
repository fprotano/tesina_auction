package it.exolab.tesina.auction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import it.exolab.tesina.auction.model.HelpCenter;

public interface HelpCenterRepo extends CrudRepository<HelpCenter,Integer> {
	
	
	@Transactional
	@Modifying
	@Query(" SELECT h FROM HelpCenter  AS  h WHERE  h.assignedToId =?1 AND h.closedAt=null ")
	public List<HelpCenter> findbyAssignedIdAndClosed(Integer assignedId );

}
