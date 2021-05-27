package it.exolab.tesina.auction.repository;

import org.springframework.data.repository.CrudRepository;

import it.exolab.tesina.auction.api.model.dto.StaffDTO;

public interface StaffRepo extends CrudRepository<StaffDTO, Integer>{

}
