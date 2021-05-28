package it.exolab.tesina.auction.service.api;

import java.util.List;

import it.exolab.tesina.auction.api.model.dto.UserDTO;
import it.exolab.tesina.auction.model.User;
import it.exolab.tesina.auction.repository.UserRepo;

public class UserService {
	
	private UserRepo userRepo;

	//@Autowired(required = true)
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
	public User findByEmailAndPassword(String email, String password) {
		return userRepo.findByEmailAndPassword(email, password);
	}

}
