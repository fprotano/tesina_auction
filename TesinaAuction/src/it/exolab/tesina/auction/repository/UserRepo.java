package it.exolab.tesina.auction.repository;

import org.springframework.data.repository.CrudRepository;

import it.exolab.tesina.auction.api.model.dto.UserDTO;



public interface UserRepo extends CrudRepository<UserDTO, Integer> {
	
	public UserDTO findByEmailAndPassword(String email, String password);

}
