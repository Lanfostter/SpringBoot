package com.trungtamjava.hellospringboot.com.trungtamjava.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Tom
 *
 */
@Entity
@Table(name = "users")
public class User {
	@Id
	@Column(name = "u_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "u_name")
	private String name;
	@Column(name = "u_username")
	private String username;
	@Column(name = "u_password")
	private String password;
	@Column(name = "u_role")
	private String role;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private IDCard idCard;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public IDCard getIdCard() {
		return idCard;
	}

	public void setIdCard(IDCard idCard) {
		this.idCard = idCard;
	}

	public User(int id, String name, String username, String password, String role, IDCard idCard) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.role = role;
		this.idCard = idCard;
	}

	public User() {
		super();
	}

}
