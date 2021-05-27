package it.exolab.tesina.auction.repository;

import org.springframework.data.repository.CrudRepository;

import it.exolab.tesina.auction.model.User;


public interface UserRepo extends  CrudRepository<User, Integer> {
	User findByEmailAndPassword(String email, String password);

}
