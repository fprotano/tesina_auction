package it.exolab.tesina.auction.controller.api;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
		String urlUnDo = "http://localhost:8080/TesinaAuction/api/auctionOrder/AuctionOrderReturnFailure";
		String urlSuccess = "http://localhost:8080/TesinaAuction/api/auctionOrder/AuctionOrderReturnSuccess";
		String urlNotify = "http://localhost:8080/TesinaAuction/api/payment/paymentNotify";
		model.setUrlBank(urlBank);
		model.setUrlUnDo(urlUnDo);
		model.setUrlSuccess(urlSuccess);
		model.setUrlNotify(urlNotify);
		
		AuctionOrder auctionOrder = auctionOrderService.findByOrderNo(model.getCustomCode());
		auctionOrder.setAuctionOrderStatusId(2);
		auctionOrder.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		auctionOrderService.save(auctionOrder);
		System.out.println("nel doAuctionOrderPayment, auctionOrder   > " + auctionOrder);
		System.out.println("nel doAuctionOrderPayment, model   > " + model);
		
		return sendSuccess(model);
	}
	
	@RequestMapping(value = "AuctionOrderDeletePayment", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpResponse<Payment> doAuctionOrderDeletePayment(@RequestBody Payment model) {
		
		System.out.println("nel doAuctionOrderPayment, Payment > " + model);
		AuctionOrder auctionOrder = auctionOrderService.findByOrderNo(model.getCustomCode());
		auctionOrderService.delete(auctionOrder.getId());

		return sendSuccess(model);
	}
	
	@RequestMapping(value = "AuctionOrderReturnSuccess", method = RequestMethod.GET,consumes = MediaType.ALL_VALUE)
	@ResponseBody
	public ModelAndView doAuctionOrderReturnSuccess(@ModelAttribute Payment payment) {
		
		String url = System.getenv("ServerAsta");
		ModelAndView ret = new ModelAndView(url + "user");
		payment.setUrlUnDo(null);
		ret.addObject("payment", payment);
		
		return ret;
	}
	
	@RequestMapping(value = "AuctionOrderReturnFailure", method = RequestMethod.GET,consumes = MediaType.ALL_VALUE)
	@ResponseBody
	public ModelAndView doAuctionOrderReturnFailure(@ModelAttribute Payment payment) {
		
		
		String url = System.getenv("ServerAsta");
		
		ModelAndView ret = new ModelAndView(url + "user");
		payment.setUrlSuccess(null);
		ret.addObject("payment", payment);
		
		return ret;
	}
}
