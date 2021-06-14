package it.exolab.tesina.auction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import it.exolab.tesina.auction.model.HelpCenterThread;

public interface HelpCenterThreadRepo extends CrudRepository<HelpCenterThread,Integer>{
	
	public List<HelpCenterThread> findByHelpCenterId(Integer helpCenterId);
	
	@Transactional
	@Modifying
	@Query("UPDATE HelpCenterThread ht SET ht.answer = ?2 WHERE ht.id=?1 ")
	public void updateAnswerThread(Integer id, String answer);

}
