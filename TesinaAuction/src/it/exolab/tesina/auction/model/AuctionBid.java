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
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="auction_bid")
public class AuctionBid {
  
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="created_at")
	private Timestamp createAt;
	
	@Column(name="auction_id")
	private Integer auctionId;
	
	@Fetch(value=FetchMode.JOIN)
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="auction_id", nullable=false, insertable=false, updatable=false)
	private Auction bidAuction;
	
	@Column(name="user_id")
	private Integer userId;
	
	@Fetch(value=FetchMode.JOIN)
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id", nullable=false, insertable=false, updatable=false)
	private User userBid;
	
	@Column
	private Double bid;

	public AuctionBid() {
		super();
	}

	public AuctionBid(Timestamp createAt, Integer auctionId, Auction bidAuction, Integer userId, User userBid,
			Double bid) {
	
		this.createAt = createAt;
		this.auctionId = auctionId;
		this.bidAuction = bidAuction;
		this.userId = userId;
		this.userBid = userBid;
		this.bid = bid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}

	public Integer getAuctionId() {
		return auctionId;
	}

	public void setAuctionId(Integer auctionId) {
		this.auctionId = auctionId;
	}

	public Auction getBidAuction() {
		return bidAuction;
	}

	public void setBidAuction(Auction bidAuction) {
		this.bidAuction = bidAuction;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public User getUserBid() {
		return userBid;
	}

	public void setUserBid(User userBid) {
		this.userBid = userBid;
	}

	public Double getBid() {
		return bid;
	}

	public void setBid(Double bid) {
		this.bid = bid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuctionBid other = (AuctionBid) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AuctionBid [id=" + id + ", createAt=" + createAt + ", auctionId=" + auctionId + ", bidAuction="
				+ bidAuction + ", userId=" + userId + ", userBid=" + userBid + ", bid=" + bid + "]";
	}
	
	
	
	
	
}
