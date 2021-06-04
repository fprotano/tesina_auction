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
@RequestMapping(value = "api/auctionBid")
public class ApiAuctionBidController extends BaseController{
	
	// insert, findbyid, findByAuctionID, findByUserIdWhereClosedAt=null
	
	private AuctionBidService auctionBidSer;
	
	@Autowired(required = false)
	public void setAuctionBidService(AuctionBidService auctionBidSer) {
		this.auctionBidSer = auctionBidSer;
	}
	
	
	@RequestMapping(value = "insertBid", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<AuctionBid> doInsertBid(@RequestBody AuctionBid model) {
		
		this.auctionBidSer.save(model);
		return sendSuccess(model);
		
	}
	
	@RequestMapping(value = "findAllBids", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<AuctionBid> doFindAllBids(@RequestBody AuctionBid model) {
		
		List <AuctionBid> listBids = auctionBidSer.findAll();
		return sendSuccess(listBids);
		
	}
	
	@RequestMapping(value = "auctionBids", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<AuctionBid> doFindBidsByAuctionId(@RequestBody String auctionId) {
		
		List <AuctionBid> listBids = auctionBidSer.findBidsByAuctionId(Integer.parseInt(auctionId));
		return sendSuccess(listBids);
		
	}
	
	@RequestMapping(value = "userActiveAuctionBids", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<AuctionBid> doFindBidsOfActiveAuctionsByUserId(@RequestBody String userId) {
		
		List <AuctionBid> listBids = auctionBidSer.findBidsOfActiveAuctionsByUserId(Integer.parseInt(userId));
		return sendSuccess(listBids);
		
	}
	
	@RequestMapping(value = "userLastActiveAuctionBids", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<AuctionBid> doFindLastBidsOfActiveAuctionsByUserId(@RequestBody String userId) {
		
		List <AuctionBid> listBids = auctionBidSer.findLastBidsOfActiveAuctionsByUserId(Integer.parseInt(userId));
		return sendSuccess(listBids);
		
	}
	
	

}
