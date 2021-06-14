package it.exolab.tesina.auction.controller.api;

import java.sql.Timestamp;
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
import it.exolab.tesina.auction.model.Auction;
import it.exolab.tesina.auction.model.AuctionOrder;
import it.exolab.tesina.auction.model.Payment;
import it.exolab.tesina.auction.model.User;
import it.exolab.tesina.auction.service.api.AuctionOrderService;


@CrossOrigin
@Controller
@RequestMapping(value = "api/auctionOrder")
public class APiAuctionOrderController extends BaseController<AuctionOrder> {
  
	
	private AuctionOrderService  auctionOrderService;
	
	@Autowired(required = true)
	public void setAuctionOrderService(AuctionOrderService  auctionOrderService) {
		this.auctionOrderService = auctionOrderService;
	}
	

	@RequestMapping(value="auctionOrderInsert", method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<AuctionOrder> doAuctionInsert(@RequestBody AuctionOrder model) {
		System.out.println("nel auctionOrderInsert, Order > " + model);
		auctionOrderService.save(model);
		return sendSuccess(model); 
	}
	@RequestMapping(value="auctionOrderFindByAuction", method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<AuctionOrder> doAuctionOrderFindByAuction(@RequestBody Auction model) {
		System.out.println("nel auctionOrderFindByAuction, Auction > " + model);
		List<AuctionOrder> auctionOrder =auctionOrderService.findAuctionOrderByAuctionId(model.getId());
		return sendSuccess(auctionOrder); 
	}
	
	@RequestMapping(value = "AuctionOrderFindByUserId", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<AuctionOrder> doAuctionOrderFindByUserId(@RequestBody User model) {
		System.out.println("nel AuctionOrderFindByUserId, UserId > " + model.getId());
		List<AuctionOrder> auctionOrderList = auctionOrderService.finbyWinnerUserReturnAuctionUser(model.getId());
		System.out.println("nel AuctionOrderFindByUserId, AuctionOrder  > " + auctionOrderList);
		return sendSuccess(auctionOrderList);
	}
	
	@RequestMapping(value = "AuctionOrderPayment", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<Payment> doAuctionOrderPayment(@RequestBody Payment model) {
		
		System.out.println("nel doAuctionOrderPayment, Payment > " + model);
		String urlBank = "http://localhost:8080/TesinaMyBank/payment/inserisci";
		String urlUnDo = "daDefinire:1";
		String urlSuccess = "daDefinire:2";
		String urlNotify = "http://localhost:8080/TesinaAuction/api/auctionOrder/paymentNotify";
		model.setUrlBank(urlBank);
		model.setUrlUnDo(urlUnDo);
		model.setUrlSuccess(urlSuccess);
		model.setUrlNotify(urlNotify);
		
		AuctionOrder auctionOrder = auctionOrderService.findByOrderNo(model.getCustomCode());
		auctionOrder.setAuctionOrderStatusId(2);
		auctionOrder.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		auctionOrderService.save(auctionOrder);
		System.out.println("nel doAuctionOrderPayment,> " + auctionOrder);
		
		return sendSuccess(model);
	}
	
	@RequestMapping(value = "paymentNotify", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<Payment> doPaymentNotify(@RequestBody Payment model) {
		
		return null;
		
		
	}

}
