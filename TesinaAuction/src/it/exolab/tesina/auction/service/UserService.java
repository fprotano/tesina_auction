package it.exolab.tesina.auction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.exolab.tesina.auction.model.User;
import it.exolab.tesina.auction.repository.UserRepo;

public class UserService {
	private UserRepo userRepo;

	@Autowired(required = true)
	public void setUserRepo(UserRepo userRepo) {
		this.userRepo = userRepo;

	}

	public User find(int id) {
		return userRepo.findOne(id);
	}

	public List<User> findAll() {
		return (List<User>) userRepo.findAll();
	}

	public void save(User model) {
		this.userRepo.save(model);
	}

	public void delete(int id) {
		userRepo.delete(id);
	}

}
