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
public class AuctionOrder {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer id;
	
	@Column(name="order_no")
	public Integer orderNo;
	
	@Column(name="auction_id")
	public Integer auctionId;
	
	@Column(name="auction_order_status_id")
	public Integer auctionOrderStatusId;
	
	@Column(name="create_at")
	private LocalDateTime createAt;
	
	@Column(name="update_at")
	private LocalDateTime updatedAt;
	
	@Column(name="payment_verify_expires_at")
	private LocalDateTime paymentVerifyExpiresAt;
	
	@Column(name="paid_at")
	private LocalDateTime paidAt;
	
	private Double amount;
	
	@Column(name="transaction_id")
	private String transactionId;

	
	public AuctionOrder(Integer orderNo, Integer auctionId, Integer auctionOrderStatusId, LocalDateTime createAt,
			LocalDateTime updatedAt, LocalDateTime paymentVerifyExpiresAt, LocalDateTime paidAt, Double amount,
			String transactionId) {
		this.orderNo = orderNo;
		this.auctionId = auctionId;
		this.auctionOrderStatusId = auctionOrderStatusId;
		this.createAt = createAt;
		this.updatedAt = updatedAt;
		this.paymentVerifyExpiresAt = paymentVerifyExpiresAt;
		this.paidAt = paidAt;
		this.amount = amount;
		this.transactionId = transactionId;
	}

	public AuctionOrder() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
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

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public LocalDateTime getPaymentVerifyExpiresAt() {
		return paymentVerifyExpiresAt;
	}

	public void setPaymentVerifyExpiresAt(LocalDateTime paymentVerifyExpiresAt) {
		this.paymentVerifyExpiresAt = paymentVerifyExpiresAt;
	}

	public LocalDateTime getPaidAt() {
		return paidAt;
	}

	public void setPaidAt(LocalDateTime paidAt) {
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

	@Override
	public String toString() {
		return "AuctionOrder [id=" + id + ", orderNo=" + orderNo + ", auctionId=" + auctionId
				+ ", auctionOrderStatusId=" + auctionOrderStatusId + ", createAt=" + createAt + ", updatedAt="
				+ updatedAt + ", paymentVerifyExpiresAt=" + paymentVerifyExpiresAt + ", paidAt=" + paidAt + ", amount="
				+ amount + ", transactionId=" + transactionId + "]";
	}
}
