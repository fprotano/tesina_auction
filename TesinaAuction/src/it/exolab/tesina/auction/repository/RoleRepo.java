package it.exolab.tesina.auction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.exolab.tesina.auction.model.Role;

public interface RoleRepo extends  CrudRepository<Role, Integer>{

	
	@Modifying
	@Query("SELECT r FROM Role r")
	public List<Role> findAllCustom();
}
