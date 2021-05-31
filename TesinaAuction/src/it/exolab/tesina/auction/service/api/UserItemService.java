package it.exolab.tesina.auction.service.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.exolab.tesina.auction.model.UserItem;
import it.exolab.tesina.auction.repository.UserItemRepo;


public class UserItemService {
	
	private UserItemRepo userItemRepo;
	
	@Autowired(required = true)
	public void setUserItemRepo(UserItemRepo userItemRepo) {
		this.userItemRepo = userItemRepo;
	}

	public UserItem find(int id) {
		return userItemRepo.findOne(id);
	}

	public List<UserItem> findAll() {
		return (List<UserItem>) userItemRepo.findAll();
	}

	public void save(UserItem model) {
		this.userItemRepo.save(model);
	}

	public void delete(int id) {
		userItemRepo.delete(id);
	}
	
	public List<UserItem> findUserItemByUserId(Integer userId) {
		return userItemRepo.findUserItemByUserId(userId);
	}

}
