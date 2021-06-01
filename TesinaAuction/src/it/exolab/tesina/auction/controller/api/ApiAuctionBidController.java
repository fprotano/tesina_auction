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
import it.exolab.tesina.auction.model.AuctionBid;
import it.exolab.tesina.auction.service.api.AuctionBidService;

@CrossOrigin
@Controller
@RequestMapping(value = "api/auction/bid")
public class ApiAuctionBidController extends BaseController{
	
	// insert, findbyid, findByAuctionID, findByUserIdWhereClosedAt=null
	
	private AuctionBidService auctionBidSer;
	
	@Autowired(required = false)
	public void setAuctionBidService(AuctionBidService abS) {
		this.auctionBidSer = abS;
	}
	
	
	@RequestMapping(value = "insertBid", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<AuctionBid> insertBid(@RequestBody AuctionBid model) {
		
		this.auctionBidSer.save(model);
		return (HttpResponse<AuctionBid>) sendSuccess(model);
		
	}
	
	@RequestMapping(value = "findAllBids", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<AuctionBid> findAllBids(@RequestBody AuctionBid model) {
		
		List <AuctionBid> listBids = this.auctionBidSer.findAll();
		return (HttpResponse<AuctionBid>) sendSuccess(listBids);
		
	}
	
	@RequestMapping(value = "auctionBids", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<AuctionBid> findBidsByAuctionId(@RequestBody String auctionId) {
		
		List <AuctionBid> listBids = this.auctionBidSer.findBidsByAuctionId(Integer.parseInt(auctionId));
		return (HttpResponse<AuctionBid>) sendSuccess(listBids);
		
	}
	
	@RequestMapping(value = "userActiveAuctionBids", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<AuctionBid> findBidsOfActiveAuctionsByUserId(@RequestBody String userId) {
		
		List <AuctionBid> listBids = this.auctionBidSer.findBidsOfActiveAuctionsByUserId(Integer.parseInt(userId));
		return (HttpResponse<AuctionBid>) sendSuccess(listBids);
		
	}
	
	@RequestMapping(value = "userLastActiveAuctionBids", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<AuctionBid> findLastBidsOfActiveAuctionsByUserId(@RequestBody String userId) {
		
		List <AuctionBid> listBids = this.auctionBidSer.findLastBidsOfActiveAuctionsByUserId(Integer.parseInt(userId));
		return (HttpResponse<AuctionBid>) sendSuccess(listBids);
		
	}
	
	

}
