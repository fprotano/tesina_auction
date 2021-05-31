package it.exolab.tesina.auction.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.exolab.tesina.auction.model.UserItem;

public interface UserItemRepo extends CrudRepository<UserItem, Integer>{
	
	public List<UserItem> findUserItemByUserId(Integer userId);

}
