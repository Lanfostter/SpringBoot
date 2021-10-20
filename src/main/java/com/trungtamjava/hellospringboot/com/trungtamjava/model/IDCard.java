package com.trungtamjava.hellospringboot.com.trungtamjava.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "IDCard")

public class IDCard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "idcard")
	private String idNumber;
	@Temporal(TemporalType.DATE)
	@Column(name = "issued_on")
	private Date issuedon;
	@Temporal(TemporalType.DATE)
	@Column(name = "expire")
	private Date expiredate;
	@OneToOne
	@JoinColumn(name = "u_id")
	private User user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public Date getIssuedon() {
		return issuedon;
	}
	public void setIssuedon(Date issuedon) {
		this.issuedon = issuedon;
	}
	public Date getExpiredate() {
		return expiredate;
	}
	public void setExpiredate(Date expiredate) {
		this.expiredate = expiredate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public IDCard(int id, String idNumber, Date issuedon, Date expiredate, User user) {
		super();
		this.id = id;
		this.idNumber = idNumber;
		this.issuedon = issuedon;
		this.expiredate = expiredate;
		this.user = user;
	}
	public IDCard() {
		super();
	}


}