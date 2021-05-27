package it.exolab.tesina.auction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.exolab.tesina.auction.api.model.dto.UserItemDTO;
import it.exolab.tesina.auction.repository.UserItemRepo;


public class UserItemService {
	
	private UserItemRepo userItemRepo;
	
	@Autowired(required = true)
	public void setUserItemRepo(UserItemRepo userItemRepo) {
		this.userItemRepo = userItemRepo;
	}

	public UserItemDTO find(int id) {
		return userItemRepo.findOne(id);
	}

	public List<UserItemDTO> findAll() {
		return (List<UserItemDTO>) userItemRepo.findAll();
	}

	public void save(UserItemDTO model) {
		this.userItemRepo.save(model);
	}

	public void delete(int id) {
		userItemRepo.delete(id);
	}

}
