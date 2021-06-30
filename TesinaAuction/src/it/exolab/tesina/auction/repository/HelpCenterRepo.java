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
			+ " ORDER BY ht.createdAt asc ")
	public List<HelpCenter> findOpenHelpCenterAndWaitingAnswer(Integer assignedId);

	public List<HelpCenter> findByAssignedToId(Integer assignedToId);
	
//	@Transactional
//	@Query(" SELECT h FROM HelpCenter h "
//			+ " JOIN FETCH h.staffAssigned s "
//			+ " WHERE h.userId = ?1 ")
//	@Query(value = "SELECT h.*, s.name, s.surname "
//					+ " FROM help_center h, staff s"
//					+ " WHERE h.assigned_to_id = s.id AND h.user_id = ?1 ",
//			nativeQuery = true)
	public List<HelpCenter> findbyUserId(Integer userId);
	
//	@Modifying
//	@Query(" SELECT h FROM HelpCenterThread as ht "
//			+ " JOIN ht.helpCenterForThread as h "
//			+ " WHERE h.assignedToId = ?1 AND h.closedAt is null "
//			+ " AND ht.answer is null AND h.id = ht.helpCenterId "
//			+ " ORDER BY ht.createdAt asc ")
//	public List<HelpCenter> findOpenHelpCenterAndWaitingAnswer(Integer assignedId);
	
//	@Modifying
//	@Query("select h from it.exolab.tesina.auction.model.HelpCenter h "
//			+ " inner join it.exolab.tesina.auction.model.HelpCenterThread t " + 
//			"   where h.id  = t.helpCenterId ")
//	public List<HelpCenter> findOpenHelpCenterAndWaitingAnswer(Integer assignedId);
	
//	@Modifying
//	@Query("SELECT h FROM HelpCenter h, HelpCenterThread t "
//			+ " WHERE h.id=t.helpCenterId AND h.assignedToId= ?1 "
//			+ " AND h.closedAt is null AND t.answer is null "
//			+ " ORDER BY t.createdAt ASC ")
//	public List<HelpCenter> findOpenHelpCenterAndWaitingAnswer(Integer assignedId);

}
