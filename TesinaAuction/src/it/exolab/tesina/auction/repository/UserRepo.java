package it.exolab.tesina.auction.repository;

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


import it.exolab.tesina.auction.model.User;



public interface UserRepo extends CrudRepository<User, Integer> {
	
	public User findByEmailAndPassword(String email, String password);
	
	@Transactional
	@Modifying
	@Query("SELECT u FROM User u WHERE u.email=?1 and u.password=?2")
	public User findUserLogin(String email, String password);
	
	@Transactional
	@Modifying
	@Query("UPDATE User u SET u.otpCode = ?2, u.otpCodeExpiresAt = ?3 "
			+ " WHERE u.id=?1 ")
	public void updateOTP(Integer id, String otp, Timestamp otpExpiresAt);

}
