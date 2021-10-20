package com.trungtamjava.hellospringboot.com.trungtamjava.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "manufacturer")
public class Manufacturer {
	@Id
	@Column(name = "m_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "m_name")
	private String name;
	@OneToOne
	@JoinColumn(name = "p_id")
	private Product product;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Manufacturer(int id, String name, Product product) {
		super();
		this.id = id;
		this.name = name;
		this.product = product;
	}
	public Manufacturer() {
		super();
	}
	


}
