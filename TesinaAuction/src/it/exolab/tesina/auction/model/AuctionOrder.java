package it.exolab.tesina.auction.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="auction_order")
public class AuctionOrder {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
		
	@Column(name="auction_id")
	private Integer auctionId;
	
	@Column(name="auction_order_status_id")
	private Integer auctionOrderStatusId;
	
	@Column(name="created_at")
	private Timestamp createAt;
	
	@Column(name="updated_at")
	private Timestamp updatedAt;
	
	@Column(name="payment_verify_expires_at")
	private Timestamp paymentVerifyExpiresAt;
	
	@Column(name="paid_at")
	private Timestamp paidAt;
	
	private Double amount;
	
	@Column(name="order_no")
	private String orderNo;
	
	@Column(name="transaction_id")
	private String transactionId;
	
	@Fetch(value=FetchMode.JOIN)
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="auction_id", nullable=false, insertable=false, updatable=false)
	private Auction auction;


	public AuctionOrder(Integer id, String orderNo, Integer auctionId, Integer auctionOrderStatusId,
			Timestamp createAt, Timestamp updatedAt, Timestamp paymentVerifyExpiresAt, Timestamp paidAt, Double amount,
			String transactionId, Auction auction) {

		this.id = id;
		this.orderNo = orderNo;
		this.auctionId = auctionId;
		this.auctionOrderStatusId = auctionOrderStatusId;
		this.createAt = createAt;
		this.updatedAt = updatedAt;
		this.paymentVerifyExpiresAt = paymentVerifyExpiresAt;
		this.paidAt = paidAt;
		this.amount = amount;
		this.transactionId = transactionId;
		this.auction = auction;

	}

	public AuctionOrder() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getAuctionId() {
		return auctionId;
	}

	public void setAuctionId(Integer auctionId) {
		this.auctionId = auctionId;
	}

	public Integer getAuctionOrderStatusId() {
		return auctionOrderStatusId;
	}

	public void setAuctionOrderStatusId(Integer auctionOrderStatusId) {
		this.auctionOrderStatusId = auctionOrderStatusId;
	}

	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Timestamp getPaymentVerifyExpiresAt() {
		return paymentVerifyExpiresAt;
	}

	public void setPaymentVerifyExpiresAt(Timestamp paymentVerifyExpiresAt) {
		this.paymentVerifyExpiresAt = paymentVerifyExpiresAt;
	}

	public Timestamp getPaidAt() {
		return paidAt;
	}

	public void setPaidAt(Timestamp paidAt) {
		this.paidAt = paidAt;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	
	public Auction getAuction() {
		return auction;
	}

	public void setAuction(Auction auction) {
		this.auction = auction;
	}

	@Override
	public String toString() {
		return "AuctionOrder [id=" + id + ", orderNo=" + orderNo + ", auctionId=" + auctionId
				+ ", auctionOrderStatusId=" + auctionOrderStatusId + ", createAt=" + createAt + ", updatedAt="
				+ updatedAt + ", paymentVerifyExpiresAt=" + paymentVerifyExpiresAt + ", paidAt=" + paidAt + ", amount="
				+ amount + ", transactionId=" + transactionId + ", auction=" + auction + "]";
	}
}
