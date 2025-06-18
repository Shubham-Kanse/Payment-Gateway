package com.ravenclaw.model;

import java.util.Date;

public class CustomerInfo {
	
	String name;
	int amount;
	Date date=new Date();
	public CustomerInfo() {
		super();
	}
	public CustomerInfo(String name, int amount, Date date) {
		super();
		this.name = name;
		this.amount = amount;
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	

}
