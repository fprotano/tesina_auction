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
	public HttpResponse<Auction> doauctionInsert(@RequestBody Auction model) {
		System.out.println(model);
		auctionService.save(model);
		return sendSuccess(model); 
	}
	
	
	@RequestMapping(value="FindAllAuctions", method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<Auction> doFindAllAuctions() {
	
		List<Auction> auctionsList = auctionService.findAll();

		return sendSuccess(auctionsList);
	}
	
	@RequestMapping(value="findAuctionsByUser", method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<Auction> dofindAuctionsByUser(@RequestBody String userId) {
		System.out.println(userId);
		List<Auction> auctionsList = auctionService.findAuctionsByUser(Integer.parseInt(userId));
		System.out.println(auctionsList);
		return sendSuccess(auctionsList);
	}
	
	// find auctionbyid
	
//	@RequestMapping(value="finAuctiondByAuctionById", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public HttpResponse<Auction> dofindAuctionBy1AuctionId(@RequestBody String auctionId) {
//		System.out.println(auctionId);
//		Auction auction = auctionService.find(Integer.parseInt(auctionId));
//		System.out.println(auction);
//		return sendSuccess(auction);
//	}
}
