package it.exolab.tesina.auction.controller.api;

import java.sql.Timestamp;
import java.util.Calendar;
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
import it.exolab.tesina.auction.api.model.dto.AuctionDTO;
import it.exolab.tesina.auction.controller.BaseController;
import it.exolab.tesina.auction.model.Auction;
import it.exolab.tesina.auction.service.api.AuctionService;

@CrossOrigin
@Controller
@RequestMapping(value="api/auction")
public class ApiAuctionController extends BaseController {
	
	private AuctionService auctionService;
	
	@Autowired(required = true)
	public void setAuctionService(AuctionService auctionService) {
		this.auctionService = auctionService;
	}
	
	@RequestMapping(value="auctionInsert", method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<Auction> doAuctionInsert(@RequestBody AuctionDTO model) {
		System.out.println("nel auctionInsert, auction > " + model);
		
		Auction newAuction = model.getAuction();
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		Calendar cal = Calendar.getInstance();
		
		cal.setTimeInMillis(model.getAuction().getStartAuctionAt().getTime());
	    cal.add(Calendar.DAY_OF_MONTH, model.getAuctionDayDuration());
	    Timestamp auctioneEndDate = new Timestamp(cal.getTime().getTime());
	    
	    newAuction.setCreatedAt(currentTime);
	    newAuction.setEndAuctionAt(auctioneEndDate);
	    
		auctionService.save(newAuction);
		System.out.println("nel auctionInsert dopo l-insert, auction > " + newAuction );
		return sendSuccess(newAuction); 
	}
	
	
	@RequestMapping(value="findAllAuctions", method=RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<Auction> doFindAllAuctions() {
		
		System.out.println("sono nel findAllAuctions");
		List<Auction> auctionsList = auctionService.findAllAuctions();
		
		System.out.println("stampa delle aste > " + auctionsList);
		return sendSuccess(auctionsList);
	
	}
	
	@RequestMapping(value="findAuctionsByUser", method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<Auction> dofindAuctionsByUser(@RequestBody String userId) {
		System.out.println("nell findAuctionsByUser, user id > " + userId);
		List<Auction> auctionsList = auctionService.findAuctionsByUser(Integer.parseInt(userId));
		System.out.println("nell findAuctionsByUser dopo il find, user id > " + auctionsList);
		return sendSuccess(auctionsList);
	}
	
	@RequestMapping(value="finAuctiondByAuctionById", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<Auction> dofindAuctionBy1AuctionId(@RequestBody String auctionId) {
		System.out.println(auctionId);
		Auction auction = auctionService.findById(Integer.parseInt(auctionId));
		System.out.println(auction);
		return sendSuccess(auction);
	}
}
