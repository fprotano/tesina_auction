package it.exolab.tesina.auction.repository;

import org.springframework.data.repository.CrudRepository;

import it.exolab.tesina.auction.model.Staff;

public interface StaffRepo extends CrudRepository<Staff, Integer>{
	
	public Staff findByEmailAndPassword(String email,String password);  //
	public Staff findBySurname(String surname) ;

}
