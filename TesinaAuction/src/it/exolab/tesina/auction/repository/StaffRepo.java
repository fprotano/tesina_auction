package it.exolab.tesina.auction.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import it.exolab.tesina.auction.model.Staff;
import it.exolab.tesina.auction.model.User;

public interface StaffRepo extends CrudRepository<Staff, Integer>{
	
	
	public Staff findByEmailAndPassword(String email, String password);
	
	@Transactional
	@Modifying
	@Query("SELECT s FROM Staff s WHERE s.email=?1 and s.password=?2")
	public Staff findStaffLogin(String email, String password);
	
//	public Staff findOneByEmailAndPassword(String email, String password);
	
	public Staff findBySurname(String surname) ;
	
	
	
	
	
	
	
}
