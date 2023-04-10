package com.data.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cId;
	
	@NotNull
	@Size(min = 2, max = 50)
	@Column(nullable = false, length = 50)
	private String cName;
	
	@NotNull
	@Column(nullable = false, length = 10)
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date dob;
	
	@NotNull
	@Email
	@Column(nullable = false, length = 50)
	private String cEmail;
	
	@NotNull
	@Column(nullable = false, length = 50)
	private String address;
	
	@NotNull
	@Size(min = 6, max = 50)
	@Column(nullable = false, length = 250)
	private String cPassword;
	
	@NotNull
	@Column(nullable = false, length = 25)
	private int accountID;
	
	public Client() {
		
	} 

	public Client(int cId, String cName, Date dob, String cEmail, String address, String cPassword, int accountID) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.dob = dob;
		this.cEmail = cEmail;
		this.address = address;
		this.cPassword = cPassword;
		this.accountID = accountID;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	@DateTimeFormat(pattern="yyyy-mm-dd")
	public Date getDob() {
		return dob;
	}

	@DateTimeFormat(pattern="yyyy-mm-dd")
	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getcEmail() {
		return cEmail;
	}

	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getcPassword() {
		return cPassword;
	}

	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	
}
