package it.exolab.tesina.auction.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import it.exolab.tesina.auction.api.model.HttpResponse;
import it.exolab.tesina.auction.controller.BaseController;
import it.exolab.tesina.auction.model.AuctionOrder;
import it.exolab.tesina.auction.model.Invoice;
import it.exolab.tesina.auction.model.User;
import it.exolab.tesina.auction.service.api.InvoiceService;
@CrossOrigin
@Controller
@RequestMapping(value="api/invoice")
public class ApiInvoiceController extends BaseController<Invoice> {
	
	private InvoiceService invoiceService;

	@Autowired(required = true)
	public void setInvoiceService(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}


	@RequestMapping(value = "downloadInvoice", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<Invoice> doDownloadInvoice(@RequestBody AuctionOrder model) {
		System.out.println("nel doDownloadInvoice, AuctionOrder > " + model.getId());
		Invoice invoice = invoiceService.findByAuctionOrderId(model.getId());
		System.out.println("nel doDownloadInvoice, invoice > " + invoice);
		return sendSuccess(invoice);
	}

	@RequestMapping(value = "invoiceFindByUserId", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<Invoice> doInvoiceFindByUserId(@RequestBody User model) {
		System.out.println("nel invoiceFindByIdUser, UserId > " + model.getId());
		List<Invoice> invoiceList = invoiceService.findByUserId(model);
		System.out.println("nel invoiceFindByIdUser, invoice  > " + invoiceList);
		return sendSuccess(invoiceList);
	}

   }
