package it.exolab.tesina.auction.model;

public class Role {
	private Integer id;
	private String title;

	public Role(String title) {
		super();
		this.title = title;
	}

	public Role() {
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
		return "Role [id=" + id + ", title=" + title + "]";
	}

}
