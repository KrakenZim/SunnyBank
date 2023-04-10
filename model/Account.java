package com.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountId;
	
	@NotNull
	@Column(nullable = false, length = 50)
	private String Type;
	
	@NotNull
	@Column(nullable = false, length = 5)
	private int clientId;
	
	@Column(nullable = false, length = 25)
	private long balance;
	
	
	public Account() {
		
	}
	
	public Account(int accountId, String type, int clientId, long balance) {
		super();
		this.accountId = accountId;
		Type = type;
		this.clientId = clientId;
		this.balance = balance;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}
	
}
