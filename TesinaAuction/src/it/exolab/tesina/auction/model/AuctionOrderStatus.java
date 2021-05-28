package it.exolab.tesina.auction.model;

public class AuctionOrderStatus {

	private Integer id;
	private String title;

	public AuctionOrderStatus(String title) {
		super();

		this.title = title;
	}

	public AuctionOrderStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "AuctionOrderStatus [id=" + id + ", title=" + title + "]";
	}

}
