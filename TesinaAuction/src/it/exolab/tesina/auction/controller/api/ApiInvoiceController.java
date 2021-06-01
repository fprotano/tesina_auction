package it.exolab.tesina.auction.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import it.exolab.tesina.auction.api.model.HttpResponse;
import it.exolab.tesina.auction.controller.BaseController;
import it.exolab.tesina.auction.model.Invoice;
import it.exolab.tesina.auction.model.User;
import it.exolab.tesina.auction.service.api.InvoiceService;

public class ApiInvoiceController extends BaseController {
	private InvoiceService invoiceService;

	@Autowired(required = true)
	public void setInvoiceService(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}

	@RequestMapping(value = "invoiceInsert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<Invoice> doinvoiceInsert(@RequestBody Invoice model) {
		System.out.println("nel invoiceInsert, invoice > " + model);
		invoiceService.save(model);
		return sendSuccess(model);
	}

	@RequestMapping(value = "invoiceFindById", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<Invoice> doinvoiceFinfById(@RequestBody Invoice model) {
		System.out.println("nel invoiceFindById, invoice > " + model.getId());
		Invoice invoice = invoiceService.find(model.getId());
		return sendSuccess(invoice);
	}

	@RequestMapping(value = "invoiceFindByUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<Invoice> doinvoiceFinfByuser(@RequestBody User model) {
		System.out.println("nel invoiceFindById, invoice > " + model.getId());
		Invoice invoice = invoiceService.findByUser(model);
		return sendSuccess(invoice);
	}

   }
