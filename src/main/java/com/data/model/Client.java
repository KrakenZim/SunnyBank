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
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Size(min = 2, max = 50)
	@Column(nullable = false, length = 50)
	private String name;
	
	@NotNull
	@Column(nullable = false, length = 10)
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date dob;
	
	@NotNull
	@Email
	@Column(nullable = false, unique = true, length = 50)
	private String email;
	
	@NotNull
	@Column(nullable = false, length = 50)
	private String address;
	
	@NotNull
	@Pattern(regexp="^\\d{10}$", message="must be 10 digit number")
	private String cellphone;
	
	@NotNull
	@Size(min = 6, message="must be min 6 characters")
	@Column(nullable = false, length = 250)
	private String password;

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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	
}
