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
	@Query(" SELECT h FROM help_center  AS  h WHERE  h.assigned_to_id =?1 AND h.closed_at=null ")
	public List<HelpCenter> findByAssignedIdAndClosed(Integer assignedId );

}
