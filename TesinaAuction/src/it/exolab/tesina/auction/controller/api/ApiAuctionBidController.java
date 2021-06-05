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
import it.exolab.tesina.auction.model.AuctionBid;
import it.exolab.tesina.auction.service.api.AuctionBidService;

@CrossOrigin
@Controller
@RequestMapping(value = "api/auctionBid")
public class ApiAuctionBidController extends BaseController<AuctionBid>{
	
	// insert, findbyid, findByAuctionID, findByUserIdWhereClosedAt=null
	
	private AuctionBidService auctionBidService;
	
	@Autowired(required = true)
	public void setAuctionBidService(AuctionBidService auctionBidService) {
		this.auctionBidService = auctionBidService;
	}
	
	
	@RequestMapping(value = "insertBid", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<AuctionBid> doInsertBid(@RequestBody AuctionBid model) {
		
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		model.setCreateAt(currentTime);
		System.out.println("nell insert del bid, auctionBid >> " + model);
		auctionBidService.save(model);
		return sendSuccess(model);
		
	}
	
	@RequestMapping(value = "findAllBids", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<AuctionBid> doFindAllBids(@RequestBody AuctionBid model) {
		
		List <AuctionBid> listBids = auctionBidService.findAll();
		return sendSuccess(listBids);
		
	}
	
	@RequestMapping(value = "auctionBids", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<AuctionBid> doFindBidsByAuctionId(@RequestBody String auctionId) {
		
		List <AuctionBid> listBids = auctionBidService.findBidsByAuctionId(Integer.parseInt(auctionId));
		return sendSuccess(listBids);
		
	}
	
	@RequestMapping(value = "userActiveAuctionBids", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<AuctionBid> doFindBidsOfActiveAuctionsByUserId(@RequestBody String userId) {
		
		List <AuctionBid> listBids = auctionBidService.findBidsOfActiveAuctionsByUserId(Integer.parseInt(userId));
		return sendSuccess(listBids);
		
	}
	
	@RequestMapping(value = "userLastActiveAuctionBids", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<AuctionBid> doFindLastBidsOfActiveAuctionsByUserId(@RequestBody String userId) {
		
		List <AuctionBid> listBids = auctionBidService.findLastBidsOfActiveAuctionsByUserId(Integer.parseInt(userId));
		return sendSuccess(listBids);
		
	}
	
	

}
