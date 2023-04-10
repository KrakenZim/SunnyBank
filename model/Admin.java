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


@Entity
@Table(name="admin")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int staffId;
	
	@NotNull
	@Size(min = 2, max = 50)
	@Column(nullable = false, length = 50)
	private String name;
	
	@NotNull
	@Email
	@Column(nullable = false, length = 50)
	private String email;
	
	@NotNull
	@Size(min = 8)
	@Column(nullable = false, length = 250)
	private String password;
	
	
	public Admin() {
		
	}

	public Admin(int staffId, String name, String email, String password) {
		super();
		this.staffId = staffId;
		this.name = name;
		this.email = email;
		this.password = password;
	}



	public int getStaffId() {
		return staffId;
	}


	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
}
	
	
	