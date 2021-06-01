package it.exolab.tesina.auction.controller.api;

import java.util.List;

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
import it.exolab.tesina.auction.service.api.AuctionOrderService;

@CrossOrigin
@Controller
@RequestMapping(value = "api/auctionOrder")
public class APiAuctionOrderController extends BaseController<AuctionOrder> {
  
	
	private AuctionOrderService  auctionOrderService;
	
	
	
	@RequestMapping(value="auctionOrderInsert", method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<AuctionOrder> doauctionInsert(@RequestBody AuctionOrder model) {
		System.out.println("nel auctionOrderInsert, Order > " + model);
		auctionOrderService.save(model);
		return sendSuccess(model); 
	}
	@RequestMapping(value="auctionOrderFindByAuction", method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<AuctionOrder> doauctionOrderFindByAuction(@RequestBody Auction model) {
		System.out.println("nel auctionOrderFindByAuction, Auction > " + model);
		List<AuctionOrder> auctionOrder =auctionOrderService.findAuctionOrderByAuctionId(model.getId());
		return sendSuccess(auctionOrder); 
	}
}
