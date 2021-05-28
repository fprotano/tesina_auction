package it.exolab.tesina.auction.repository;

import org.springframework.data.repository.CrudRepository;

import it.exolab.tesina.auction.api.model.dto.HelpCenterDTO;

public interface HelpCenterRepo extends CrudRepository<HelpCenterDTO,Integer> {

}
