package it.exolab.tesina.auction.repository;

import org.springframework.data.repository.CrudRepository;

import it.exolab.tesina.auction.api.model.dto.InvoiceDTO;

public interface InvoiceRepo extends CrudRepository<InvoiceDTO, Integer> {

}

