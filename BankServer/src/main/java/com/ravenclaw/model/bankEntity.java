package com.ravenclaw.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Service;

@Entity(name="bank")
public class bankEntity {

	//Date date=new Date();
	@Id
	@Column
	int id;
	@Column
	String name;
	@Column(name="cardtype")
	String cardType;
	@Column(name="cardnumber")
	BigInteger cardNumber;
	@Column(name="expirydate")
	String expiryDate;
	@Column
	int cvv;
	@Column
	int balance;
	@Column
	String email;
	
	public bankEntity() {}
	
	public bankEntity(String v1, String v2, BigInteger v3, String v4, int v5, int v6)
	{
		name=v1;
		cardType=v2;
		cardNumber=v3;
		expiryDate=v4;
		cvv=v5;
		balance=v6;
	}
	
	public bankEntity(int v1, String v2, String v3, BigInteger v8, String v4, int v5, int v6, String v7)
	{
		id=v1;
		name=v2;
		cardType=v3;
		cardNumber=v8;
		expiryDate=v4;
		cvv=v5;
		balance=v6;
		email=v7;
	}

	public BigInteger getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(BigInteger cardNumber) {
		this.cardNumber = cardNumber;
	}

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

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
