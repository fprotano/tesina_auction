package it.exolab.tesina.auction.model;

import java.time.LocalDateTime;

public class AuctionOrderTransactionLog {
	private Integer id;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private Integer auctionOrderId;
	private String paramName;
	private String paramValue;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public AuctionOrderTransactionLog(LocalDateTime createdAt, LocalDateTime updatedAt, Integer auctionOrderId,
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
