package it.exolab.tesina.auction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import it.exolab.tesina.auction.model.Invoice;

public interface InvoiceRepo extends CrudRepository<Invoice, Integer> {
	
	public List<Invoice> findByUserId(Integer UserId);
	
	@Query(value = "SELECT i.invoice_no FROM invoice AS i ORDER BY i.invoice_no DESC LIMIT 1", nativeQuery = true)
	public Integer findLastInvoice();
	

}

