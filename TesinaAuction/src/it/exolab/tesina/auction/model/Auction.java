package it.exolab.tesina.auction.model;


import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table
public class Auction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="user_item_id")
	private Integer userItemId;
	
//	@Fetch(value=FetchMode.JOIN)
//	@OneToOne(fetch=FetchType.EAGER,optional=false)
//	@JoinColumn(name="user_item_id", nullable=false,insertable=false, updatable=false)
//	private UserItem userItem;
	
	@Transient
	@Fetch(value=FetchMode.JOIN)
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_item_id", referencedColumnName="id", nullable=false, insertable=false, updatable=false)
	private UserItem userItem;

	@Column(name="winner_user_id")
	private Integer winnerUserId;
	
	@Column(name="fixed_bid_every_time")
	private Integer freeBidEveryTime;
	
	@Column(name="start_price")
	private Double startPrice;
	
	@Column(name="current_bid")
	private Double currentBid;;
	
	@Column(name="shipment_extra_price")
	private Double shipmentExtraPrice;
	
	@Column(name="min_earn")
	private Double minEarn;
	
	@Column(name="fixed_bid_every_time", insertable=false, updatable=false)
	private Double fixedBidEveryTime;
	
	@Column(name="created_at")
	private Timestamp createdAt;
	
	@Column(name="updated_at")
	private Timestamp updatedAt;
	
	@Column(name="start_auction_at")
	private Timestamp startAuctionAt;
	
	@Column(name="end_auction_at")
	private Timestamp endAuctionAt;
	
	@Column(name="closed_auction_at")
	private Timestamp closedAuctionAt;
	
	public Auction() {
	
	}

	public Auction(Integer userItemId, Integer winnerUserId, Integer freeBidEveryTime, Double startPrice,
			Double currentBid, Double shipmentExtraPrice, Double minEarn, Double fixedBidEveryTime,
			Timestamp createdAt, Timestamp updatedAt, Timestamp startAuctionAt, Timestamp endAuctionAt,
			Timestamp closedAuctionAt) {

		this.userItemId = userItemId;
		this.winnerUserId = winnerUserId;
		this.freeBidEveryTime = freeBidEveryTime;
		this.startPrice = startPrice;
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
	
	public UserItem getUserItem() {
		return userItem;
	}

	public void setUserItem(UserItem userItem) {
		this.userItem = userItem;
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

	public Double getStartPrice() {
		return startPrice;
	}

	public void setStartPrice(Double startPrice) {
		this.startPrice = startPrice;
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

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Timestamp getStartAuctionAt() {
		return startAuctionAt;
	}

	public void setStartAuctionAt(Timestamp startAuctionAt) {
		this.startAuctionAt = startAuctionAt;
	}

	public Timestamp getEndAuctionAt() {
		return endAuctionAt;
	}

	public void setEndAuctionAt(Timestamp endAuctionAt) {
		this.endAuctionAt = endAuctionAt;
	}

	public Timestamp getClosedAuctionAt() {
		return closedAuctionAt;
	}

	public void setClosedAuctionAt(Timestamp closedAuctionAt) {
		this.closedAuctionAt = closedAuctionAt;
	}

	@Override
	public String toString() {
		return "Auction [id=" + id + ", userItemId=" + userItemId + ", winnerUserId=" + winnerUserId
				+ ", freeBidEveryTime=" + freeBidEveryTime + ", start_price=" + startPrice + ", currentBid="
				+ currentBid + ", shipmentExtraPrice=" + shipmentExtraPrice + ", minEarn=" + minEarn
				+ ", fixedBidEveryTime=" + fixedBidEveryTime + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", startAuctionAt=" + startAuctionAt + ", endAuctionAt=" + endAuctionAt + ", closedAuctionAt="
				+ closedAuctionAt + "]";
	}
	
	
	
	
	
	
	
	
	
	

}
	