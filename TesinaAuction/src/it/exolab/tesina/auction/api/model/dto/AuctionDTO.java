package it.exolab.tesina.auction.api.model.dto;

import it.exolab.tesina.auction.model.Auction;

public class AuctionDTO extends Auction {
	
	private Auction auction;
	private Integer auctionDayDuration;
	
	
	public AuctionDTO() {

	}

	public Auction getAuction() {
		return auction;
	}
	public void setAuction(Auction auction) {
		this.auction = auction;
	}
	public Integer getAuctionDayDuration() {
		return auctionDayDuration;
	}
	public void setAuctionDayDuration(Integer auctionDayDuration) {
		this.auctionDayDuration = auctionDayDuration;
	}
	@Override
	public String toString() {
		return "AuctionDTO [auction=" + auction + ", auctionDayDuration=" + auctionDayDuration + "]";
	}
}
