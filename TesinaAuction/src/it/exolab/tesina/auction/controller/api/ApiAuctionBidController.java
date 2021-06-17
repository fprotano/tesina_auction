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
import it.exolab.tesina.auction.model.AuctionBid;
import it.exolab.tesina.auction.service.api.AuctionBidService;
import it.exolab.tesina.auction.service.api.AuctionService;

@CrossOrigin
@Controller
@RequestMapping(value = "api/auctionBid")
public class ApiAuctionBidController extends BaseController<AuctionBid>{
	
	// insert, findbyid, findByAuctionID, findByUserIdWhereClosedAt=null
	
	private AuctionBidService auctionBidService;
	private AuctionService auctionService;
	
	@Autowired(required = true)
	public void setAuctionBidService(AuctionBidService auctionBidService, AuctionService auctionService) {
		this.auctionBidService = auctionBidService;
		this.auctionService = auctionService;
	}
	
	
	@RequestMapping(value = "insertBid", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<AuctionBid> doInsertBid(@RequestBody AuctionBid auctionBid) {
		
		auctionBid.setCreateAt(new Timestamp(System.currentTimeMillis()));
		System.out.println("nell insert del bid, auctionBid >> " + auctionBid);
		auctionBidService.save(auctionBid);
		
		//questo sotto andra nel validator
		Auction auction = auctionService.findById(auctionBid.getAuctionId());
		System.out.println("bid " + auction.getCurrentBid());
		if(auction.getCurrentBid() == null & auctionBid.getBid() > auction.getStartPrice() 
				|| auction.getCurrentBid() < auctionBid.getBid() & auctionBid.getBid() > auction.getStartPrice()) {
			auction.setCurrentBid(auctionBid.getBid());
			auction.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
			auctionService.save(auction);
			return sendSuccess(auctionBid);
		}
		return sendErr("errore", "001");
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
