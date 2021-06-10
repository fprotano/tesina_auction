package it.exolab.tesina.auction.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="role")
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="title")
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
	
	@Transient
	@OneToMany(mappedBy="staffRole", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Staff> staff;

	@Override
	public String toString() {
		return "Role [id=" + id + ", title=" + title + "]";
	}

}
