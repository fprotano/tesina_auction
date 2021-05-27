package it.exolab.tesina.auction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.exolab.tesina.auction.api.model.dto.UserDTO;

import it.exolab.tesina.auction.repository.UserRepo;

public class UserService {
	
	private UserRepo userRepo;

	@Autowired(required = true)
	public void setUserRepo(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	public UserDTO find(int id) {
		return userRepo.findOne(id);
	}

	public List<UserDTO> findAll() {
		return (List<UserDTO>) userRepo.findAll();
	}

	public void save(UserDTO model) {
		this.userRepo.save(model);
	}

	public void delete(int id) {
		userRepo.delete(id);
	}
	public UserDTO findByEmailAndPassword(String email,String password) {
		return userRepo.findByEmailAndPassword(email, password);
	}

}
