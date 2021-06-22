package it.exolab.tesina.auction.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import it.exolab.tesina.auction.model.Staff;
import it.exolab.tesina.auction.model.User;

public interface StaffRepo extends CrudRepository<Staff, Integer>{
	
	
	public Staff findByEmailAndPassword(String email, String password);
	
//	@Transactional
//	@Modifying
	@Query("SELECT s FROM Staff s WHERE s.email=?1 and s.password=?2")
	public Staff findStaffLogin(String email, String password);
	
//	public Staff findOneByEmailAndPassword(String email, String password);
	
	public Staff findBySurname(String surname) ;
	
//	@Modifying
	@Query("SELECT s FROM Staff s "
			+ " JOIN FETCH s.staffRole sr "
			+ " WHERE sr.title = ?1 ")
	public List<Staff> findByRoleTitle(String role);
	
	
	@Transactional
	@Modifying
	@Query("UPDATE Staff s SET s.otpCode = ?2, s.otpCodeExpiresAt = ?3 "
			+ " WHERE s.id=?1 ")
	public void updateOTP(Integer id, String otp, Timestamp otpExpiresAt);
	

	public Staff findByEmailAndPasswordAndOtpCode(String email, String password, String otp);
	
	String query = " SELECT s " + 
			" FROM staff s, help_center h " +
			" WHERE s.id=h.assigned_to_id AND h.closed_at is not null " + 
			" GROUP BY s.id " + 
			" ORDER BY COUNT(*) asc " + 
			" limit 1 ";
	
	@Query( value = query, 
			  nativeQuery = true)
	public Staff findHelpDeskWithLessWork();
}
