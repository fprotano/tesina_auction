package it.exolab.tesina.auction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import it.exolab.tesina.auction.model.UserItem;

public interface UserItemRepo extends CrudRepository<UserItem, Integer>{
	
	@Transactional
	@Modifying
	@Query("SELECT ui FROM UserItem AS ui "
			+ " JOIN FETCH ui.user AS u "
			+ "WHERE u.id=?1")
	public List<UserItem> findUserItemByUserId(Integer userId);

//	public List<UserItem> findAllItems();
}
