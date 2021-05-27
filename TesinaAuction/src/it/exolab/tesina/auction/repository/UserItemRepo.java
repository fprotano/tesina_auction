package it.exolab.tesina.auction.repository;

import org.springframework.data.repository.CrudRepository;

import it.exolab.tesina.auction.api.model.dto.UserItemDTO;

public interface UserItemRepo extends CrudRepository<UserItemDTO, Integer>{

}
