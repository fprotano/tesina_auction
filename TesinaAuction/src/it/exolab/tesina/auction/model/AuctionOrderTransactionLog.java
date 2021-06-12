package it.exolab.tesina.auction.model;

import java.sql.Timestamp;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="auction_order_transaction_log")
public class AuctionOrderTransactionLog {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="create_at")
	private Timestamp createdAt;
	
	@Column(name="update_at")
	private Timestamp updatedAt;
	
	@Column(name="auction_order_id")
	private Integer auctionOrderId;
	
	private String paramName;
	
	private String paramValue;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Integer getAuctionOrderId() {
		return auctionOrderId;
	}
	public void setAuctionOrderId(Integer auctionOrderId) {
		this.auctionOrderId = auctionOrderId;
	}
	public String getParamName() {
		return paramName;
	}
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	public String getParamValue() {
		return paramValue;
	}
	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}
	public AuctionOrderTransactionLog(Timestamp createdAt, Timestamp updatedAt, Integer auctionOrderId,
			String paramName, String paramValue) {
		super();
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.auctionOrderId = auctionOrderId;
		this.paramName = paramName;
		this.paramValue = paramValue;
	}
	public AuctionOrderTransactionLog() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AuctionOrderTransactionLog [id=" + id + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", auctionOrderId=" + auctionOrderId + ", paramName=" + paramName + ", paramValue=" + paramValue
				+ "]";
	}

}
