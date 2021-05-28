package it.exolab.tesina.auction.repository;

import org.springframework.data.repository.CrudRepository;

import it.exolab.tesina.auction.model.Invoice;

public interface InvoiceRepo extends CrudRepository<Invoice, Integer> {

}

