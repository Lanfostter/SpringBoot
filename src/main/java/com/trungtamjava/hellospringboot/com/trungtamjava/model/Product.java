
package com.trungtamjava.hellospringboot.com.trungtamjava.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//ORM: Object Relation Mapping
@Entity
@Table(name = "products")
public class Product {
	@Id // primary key
	@Column(name = "p_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment private
	int id;
	@Column(name = "p_name")
	private String name;

	@Column(name = "p_quantity")
	private int quantity;

	@Column(name = "p_importdate")
	private Date importdate;

	@Column(name = "p_expirydate")
	private Date expirydate;
	@Column(name = "p_price")
	private double price;
	@OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
	private Manufacturer manufacturer;

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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getImportdate() {
		return importdate;
	}

	public void setImportdate(Date importdate) {
		this.importdate = importdate;
	}

	public Date getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Product(int id, String name, int quantity, Date importdate, Date expirydate, double price,
			Manufacturer manufacturer) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.importdate = importdate;
		this.expirydate = expirydate;
		this.price = price;
		this.manufacturer = manufacturer;
	}

	public Product() {
		super();
	}

	

}
