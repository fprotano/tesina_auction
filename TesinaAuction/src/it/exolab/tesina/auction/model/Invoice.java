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
@Table
public class Invoice {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer id;
		
	@Column(name="invoice_no")
	public Integer invoiceNo;
	
	@Column(name="user_id")
	public Integer userId;
	
	@Column(name="auction_order_id")
	public Integer auctionOrderId;
	
	@Column(name="create_at")
	private Timestamp createAt;
	
	public Double amount, iva, total;

	
	public Invoice() {

	}

	public Invoice(Integer id, Integer invoiceNo, Integer userId, Integer auctionOrderId, Timestamp createAt,
			Double amount, Double iva, Double total) {
		super();
		this.id = id;
		this.invoiceNo = invoiceNo;
		this.userId = userId;
		this.auctionOrderId = auctionOrderId;
		this.createAt = createAt;
		this.amount = amount;
		this.iva = iva;
		this.total = total;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(Integer invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getAuctionOrderId() {
		return auctionOrderId;
	}

	public void setAuctionOrderId(Integer auctionOrderId) {
		this.auctionOrderId = auctionOrderId;
	}

	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getIva() {
		return iva;
	}

	public void setIva(Double iva) {
		this.iva = iva;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Invoice [id=" + id + ", invoiceNo=" + invoiceNo + ", userId=" + userId + ", auctionOrderId="
				+ auctionOrderId + ", createAt=" + createAt + ", amount=" + amount + ", iva=" + iva + ", total=" + total
				+ "]";
	}
	
	
	
	
	

}
