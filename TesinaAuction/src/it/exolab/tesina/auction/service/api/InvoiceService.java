package it.exolab.tesina.auction.service.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.exolab.tesina.auction.model.Invoice;
import it.exolab.tesina.auction.repository.InvoiceRepo;


public class InvoiceService {
	
	private InvoiceRepo invoiceRepo;
	
	@Autowired(required = true)
	public void setInvoiceRepo(InvoiceRepo invoiceRepo) {
		this.invoiceRepo = invoiceRepo;
	}
	
	public Invoice find(int id) {
		return invoiceRepo.findOne(id);
	}

	public List<Invoice> findAll() {
		return (List<Invoice>) invoiceRepo.findAll();
	}

	public void save(Invoice model) {
		this.invoiceRepo.save(model);
	}

	public void delete(int id) {
		invoiceRepo.delete(id);
	}

}
