package it.exolab.tesina.auction.service.api;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;

import it.exolab.tesina.auction.model.Auction;
import it.exolab.tesina.auction.model.AuctionOrder;
import it.exolab.tesina.auction.model.Invoice;
import it.exolab.tesina.auction.model.ReturnPayment;
import it.exolab.tesina.auction.model.UserItem;
import it.exolab.tesina.auction.util.Utils;

public class PaymentService {
	/*
	 * alla fine ho fatto a malapena in tempo a creare il servizio
	 */
	private AuctionOrderService  auctionOrderService;
	private AuctionService auctionService;
	private UserItemService userItemService;
	private InvoiceService invoiceService;
	
	@Autowired(required = true)
	public void setPaymentServiceLogic(AuctionOrderService  auctionOrderService, AuctionService auctionService, 
										UserItemService userItemService, InvoiceService invoiceService) {
		this.auctionOrderService = auctionOrderService;
		this.auctionService = auctionService;
		this.userItemService = userItemService;
		this.invoiceService = invoiceService;
	}
	
	public void paymentNotify(ReturnPayment returnPayment) {
		
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
