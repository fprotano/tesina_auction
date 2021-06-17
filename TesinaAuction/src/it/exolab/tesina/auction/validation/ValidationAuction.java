package it.exolab.tesina.auction.validation;

import java.time.LocalDateTime;

public class ValidationAuction {
	
	public static boolean Auctionclose(LocalDateTime end) {
		if(end==null &&end.isBefore(LocalDateTime.now())) {
			return false;
		}
		
		
		return true;

}
	
	public static boolean AuctionBid() {
		return false;
		
	}
}