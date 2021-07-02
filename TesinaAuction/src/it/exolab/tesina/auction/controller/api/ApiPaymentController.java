package it.exolab.tesina.auction.controller.api;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import it.exolab.tesina.auction.controller.BaseController;
import it.exolab.tesina.auction.model.Auction;
import it.exolab.tesina.auction.model.AuctionOrder;
import it.exolab.tesina.auction.model.AuctionOrderTransactionLog;
import it.exolab.tesina.auction.model.Invoice;
import it.exolab.tesina.auction.model.Payment;
import it.exolab.tesina.auction.model.ReturnPayment;
import it.exolab.tesina.auction.model.User;
import it.exolab.tesina.auction.model.UserItem;
import it.exolab.tesina.auction.service.api.AuctionOrderService;
import it.exolab.tesina.auction.service.api.AuctionService;
import it.exolab.tesina.auction.service.api.InvoiceService;
import it.exolab.tesina.auction.service.api.UserItemService;
import it.exolab.tesina.auction.service.api.UserService;
import it.exolab.tesina.auction.util.Utils;

@CrossOrigin
@Controller
@RequestMapping(value = "api/payment")
public class ApiPaymentController extends BaseController<Payment> {
	
	
	private AuctionOrderService  auctionOrderService;
	private AuctionService auctionService;
	private UserService userService;
	private UserItemService userItemService;
	private InvoiceService invoiceService;
	
	@Autowired(required = true)
	public void setPaymentService(AuctionOrderService  auctionOrderService, AuctionService auctionService, UserService userService, 
										UserItemService userItemService, InvoiceService invoiceService) {
		this.auctionOrderService = auctionOrderService;
		this.auctionService = auctionService;
		this.userService = userService;
		this.userItemService = userItemService;
		this.invoiceService = invoiceService;
	}
	
//	@RequestMapping(value = "paymentNotify", method = RequestMethod.POST,consumes = MediaType.ALL_VALUE)
//	@ResponseBody
//	public void doPaymentNotify(@ModelAttribute Payment payment) {
//		
//		System.out.println("nel payment notify > " + payment);
//		AuctionOrder auctionOrder = auctionOrderService.findByOrderNo(payment.getCustomCode());
//		auctionOrder.setTransactionId(payment.getTransactionId());
//		auctionOrder.setAuctionOrderStatusId(3);
//		auctionOrderService.save(auctionOrder);
//		System.out.println("nel payment notify > " + auctionOrder);
//	}
	
	
	@RequestMapping(value = "paymentNotify", method = RequestMethod.POST,consumes = MediaType.ALL_VALUE)
	@ResponseBody
	public void doPaymentNotify(@ModelAttribute ReturnPayment returnPayment) {
		
		System.out.println("nel payment notify > returnPayment " + returnPayment);
		System.out.println("nel payment notify > Auction Order " + returnPayment.getPv()[4]);
		AuctionOrder auctionOrder = auctionOrderService.findByOrderNo(returnPayment.getPv()[4]);
		Auction auction = auctionService.findById(auctionOrder.getAuctionId());
		Integer winnerId = auction.getWinnerUserId();
		//stato 3 pagamento effettuato
		if(returnPayment.getPv()[5].equals("3")) {
			if(auctionOrder.getAmount() == Double.parseDouble(returnPayment.getPv()[1])) {
				auctionOrder.setTransactionId(returnPayment.getPv()[0]);
				auctionOrder.setPaidAt(new Timestamp(System.currentTimeMillis()));
				UserItem userItem = userItemService.find(auction.getUserItemId());
				
				auction.setWinnerUserId(winnerId);
				auctionService.save(auction);
				
				userItem.setSoldToUserId(winnerId);
				userItemService.save(userItem);
				
				auctionOrder.setAuctionOrderStatusId(3);
				auctionOrderService.save(auctionOrder);
				
				invoiceService.save(new Invoice((invoiceService.findLastInvoice()+1), 
												winnerId, 
												auctionOrder.getId(), 
												Utils.getNow(), 
												auctionOrder.getAmount()));
			}
		}
		//stato 2 pagamento annullato
		if(returnPayment.getPv()[5].equals("2")) {
			
			auctionOrder.setTransactionId(returnPayment.getPv()[0]);
			auctionOrder.setAuctionOrderStatusId(4);
			auctionOrderService.save(auctionOrder);
		
		}
		//stato 1 pagamento in verifica
		if(returnPayment.getPv()[5].equals("1")) {
			
			auctionOrder.setTransactionId(returnPayment.getPv()[0]);
			auctionOrder.setAuctionOrderStatusId(2);
			auctionOrderService.save(auctionOrder);
		
		}

	}
}
	

//	@RequestMapping(value = "AuctionOrderPayment", method = RequestMethod.POST,consumes = MediaType.ALL_VALUE)
//	@ResponseBody
//	public void doAuctionOrderPayment(@RequestBody Payment model, HttpServletResponse httpServletResponse) throws IOException {
//		
//		System.out.println("nel doAuctionOrderPayment, Payment > " + model);
//		String projectUrl = "http://localhost:8080/TesinaMyBank/payment/inserisci";
//
//		Gson gson = new Gson();
//		String json = gson.toJson(model);
//	
//		System.out.println(json);
//		URL url = new URL(projectUrl);
//		HttpURLConnection connection = (HttpURLConnection) url.openConnection(); 
//		connection.setRequestMethod("POST");
//		connection.setDoOutput(true);
//
//		
//		connection.setRequestProperty("Accept-Charset", "UTF-8");
//		connection.setRequestProperty("Accept", "application/json" );
//		connection.setRequestProperty("Content-Type", "application/json" + "UTF-8");
//
//	    OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
//
//	    writer.write(json);
//	    writer.flush();
//	    String line;
//
//	    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//	    while ((line = reader.readLine()) != null) {
//	      System.out.println(line);
//	    }
//	    writer.close();
//	    reader.close();
//		connection.connect();
//
//		System.out.println("prima del ret > " + connection);
//	}

