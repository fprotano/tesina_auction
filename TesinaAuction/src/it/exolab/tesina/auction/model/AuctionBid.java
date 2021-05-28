package it.exolab.tesina.auction.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="auction_bid")
public class AuctionBid {
  
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="create_id")
	private LocalDateTime createAt;
	@Column(name="auction_id")
	private Integer auctionId;
	@Column(name="user_id")
	private Integer userId;
	private Double bid;
	public AuctionBid( LocalDateTime createAt, Integer auctionId, Integer userId, Double bid) {
		super();
		
		this.createAt = createAt;
		this.auctionId = auctionId;
		this.userId = userId;
		this.bid = bid;
	}
	public AuctionBid() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDateTime getCreateAt() {
		return createAt;
	}
	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}
	public Integer getAuctionId() {
		return auctionId;
	}
	public void setAuctionId(Integer auctionId) {
		this.auctionId = auctionId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Double getBid() {
		return bid;
	}
	public void setBid(Double bid) {
		this.bid = bid;
	}
	@Override
	public String toString() {
		return "AuctionBid [id=" + id + ", createAt=" + createAt + ", auctionId=" + auctionId + ", userId=" + userId
				+ ", bid=" + bid + "]";
	}
	
	
	
}
