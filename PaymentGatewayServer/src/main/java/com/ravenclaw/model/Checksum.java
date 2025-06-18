package com.ravenclaw.model;

public class Checksum {
	String uid;
	int amount ;
    public Checksum() {
		// TODO Auto-generated constructor stub
	}
	public Checksum(String uid, int amount) {
		super();
		this.uid = uid;
		this.amount = amount;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
    
}
