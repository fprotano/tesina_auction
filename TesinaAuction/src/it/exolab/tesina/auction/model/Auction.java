package it.exolab.tesina.auction.model;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Auction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer id;
	
	@Column(name="user_item_id")
	public Integer userItemId;
	
	@Column(name="winner_user_id")
	public Integer winnerUserId;
	
	@Column(name="fixed_bid_every_time")
	public Integer freeBidEveryTime;
	
	@Column(name="start_price")
	public Double start_price;
	
	@Column(name="current_bid")
	public Double currentBid;;
	
	@Column(name="shipment_extra_price")
	public Double shipmentExtraPrice;
	
	@Column(name="min_earn")
	public Double minEarn;
	
	@Column(name="fixed_bid_every_time", insertable=false, updatable=false)
	public Double fixedBidEveryTime;
	
	@Column(name="created_at")
	public LocalDateTime createdAt;
	
	@Column(name="updated_at")
	public LocalDateTime updatedAt;
	
	@Column(name="start_auction_at")
	public LocalDateTime startAuctionAt;
	
	@Column(name="end_auction_at")
	public LocalDateTime endAuctionAt;
	
	@Column(name="closed_auction_at")
	public LocalDateTime closedAuctionAt;
	
	public Auction() {
	
	}

	public Auction(Integer userItemId, Integer winnerUserId, Integer freeBidEveryTime, Double start_price,
			Double currentBid, Double shipmentExtraPrice, Double minEarn, Double fixedBidEveryTime,
			LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime startAuctionAt, LocalDateTime endAuctionAt,
			LocalDateTime closedAuctionAt) {

		this.userItemId = userItemId;
		this.winnerUserId = winnerUserId;
		this.freeBidEveryTime = freeBidEveryTime;
		this.start_price = start_price;
		this.currentBid = currentBid;
		this.shipmentExtraPrice = shipmentExtraPrice;
		this.minEarn = minEarn;
		this.fixedBidEveryTime = fixedBidEveryTime;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.startAuctionAt = startAuctionAt;
		this.endAuctionAt = endAuctionAt;
		this.closedAuctionAt = closedAuctionAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserItemId() {
		return userItemId;
	}

	public void setUserItemId(Integer userItemId) {
		this.userItemId = userItemId;
	}

	public Integer getWinnerUserId() {
		return winnerUserId;
	}

	public void setWinnerUserId(Integer winnerUserId) {
		this.winnerUserId = winnerUserId;
	}

	public Integer getFreeBidEveryTime() {
		return freeBidEveryTime;
	}

	public void setFreeBidEveryTime(Integer freeBidEveryTime) {
		this.freeBidEveryTime = freeBidEveryTime;
	}

	public Double getStart_price() {
		return start_price;
	}

	public void setStart_price(Double start_price) {
		this.start_price = start_price;
	}

	public Double getCurrentBid() {
		return currentBid;
	}

	public void setCurrentBid(Double currentBid) {
		this.currentBid = currentBid;
	}

	public Double getShipmentExtraPrice() {
		return shipmentExtraPrice;
	}

	public void setShipmentExtraPrice(Double shipmentExtraPrice) {
		this.shipmentExtraPrice = shipmentExtraPrice;
	}

	public Double getMinEarn() {
		return minEarn;
	}

	public void setMinEarn(Double minEarn) {
		this.minEarn = minEarn;
	}

	public Double getFixedBidEveryTime() {
		return fixedBidEveryTime;
	}

	public void setFixedBidEveryTime(Double fixedBidEveryTime) {
		this.fixedBidEveryTime = fixedBidEveryTime;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public LocalDateTime getStartAuctionAt() {
		return startAuctionAt;
	}

	public void setStartAuctionAt(LocalDateTime startAuctionAt) {
		this.startAuctionAt = startAuctionAt;
	}

	public LocalDateTime getEndAuctionAt() {
		return endAuctionAt;
	}

	public void setEndAuctionAt(LocalDateTime endAuctionAt) {
		this.endAuctionAt = endAuctionAt;
	}

	public LocalDateTime getClosedAuctionAt() {
		return closedAuctionAt;
	}

	public void setClosedAuctionAt(LocalDateTime closedAuctionAt) {
		this.closedAuctionAt = closedAuctionAt;
	}

	@Override
	public String toString() {
		return "Auction [id=" + id + ", userItemId=" + userItemId + ", winnerUserId=" + winnerUserId
				+ ", freeBidEveryTime=" + freeBidEveryTime + ", start_price=" + start_price + ", currentBid="
				+ currentBid + ", shipmentExtraPrice=" + shipmentExtraPrice + ", minEarn=" + minEarn
				+ ", fixedBidEveryTime=" + fixedBidEveryTime + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", startAuctionAt=" + startAuctionAt + ", endAuctionAt=" + endAuctionAt + ", closedAuctionAt="
				+ closedAuctionAt + "]";
	}
	
	
	
	
	
	
	
	
	
	

}
	