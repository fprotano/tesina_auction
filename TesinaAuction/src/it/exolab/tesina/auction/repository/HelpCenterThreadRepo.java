package it.exolab.tesina.auction.repository;

import org.springframework.data.repository.CrudRepository;

import it.exolab.tesina.auction.api.model.dto.HelpCenterThreadDTO;

public interface HelpCenterThreadRepo extends CrudRepository<HelpCenterThreadDTO,Integer>{

}
