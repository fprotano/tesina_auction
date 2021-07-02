package it.exolab.tesina.auction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import it.exolab.tesina.auction.model.HelpCenter;

public interface HelpCenterRepo extends CrudRepository<HelpCenter,Integer> {
	
	
	@Query(" SELECT h FROM HelpCenter  AS  h WHERE  h.assignedToId =?1 AND h.closedAt is null ")
	public List<HelpCenter> findbyAssignedIdAndOpen(Integer assignedToId );
	
	
	@Query(" SELECT h FROM HelpCenter as h "
			+ " JOIN FETCH h.helpThreads as ht "
			+ " WHERE h.assignedToId = ?1 AND h.closedAt is null "
			+ " AND ht.answer is null  "
			+ " GROUP BY h.id "
			+ " ORDER BY ht.createdAt asc ")
	public List<HelpCenter> findOpenHelpCenterAndWaitingAnswer(Integer assignedId);

	public List<HelpCenter> findByAssignedToId(Integer assignedToId);
	
	@Transactional
	@Query(" SELECT h FROM HelpCenter h "
			+ " JOIN FETCH h.staffAssigned s "
			+ " WHERE h.userId = ?1 "
			+ " ORDER BY h.updatedAt Desc")
//	@Query(value = "SELECT h.*, s.name, s.surname "
//					+ " FROM help_center h, staff s"
//					+ " WHERE h.assigned_to_id = s.id AND h.user_id = ?1 ",
//			nativeQuery = true)
	public List<HelpCenter> findByUserId(Integer userId);

}
