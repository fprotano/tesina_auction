package it.exolab.tesina.auction.repository;

import org.springframework.data.repository.CrudRepository;

import it.exolab.tesina.auction.api.model.dto.RoleDTO;

public interface RoleRepo extends  CrudRepository<RoleDTO, Integer>{

}
