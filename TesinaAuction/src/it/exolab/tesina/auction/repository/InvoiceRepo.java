package it.exolab.tesina.auction.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.exolab.tesina.auction.model.Invoice;

public interface InvoiceRepo extends CrudRepository<Invoice, Integer> {
	
	public List<Invoice> findByUserId(Integer UserId);

}

