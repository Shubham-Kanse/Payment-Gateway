package com.ravenclaw.model;

import org.springframework.stereotype.Service;
//stores unique value and checksum
@Service
public class PayVal {

	
	int amt;
	String Uid;
	public PayVal() {
		// TODO Auto-generated constructor stub
	}
	public PayVal(int amt, String uid) {
		super();
		this.amt = amt;
		Uid = uid;
	}
	public int getAmt() {
		return amt;
	}
	public void setAmt(int amt) {
		this.amt = amt;
	}
	public String getUid() {
		return Uid;
	}
	public void setUid(String uid) {
		Uid = uid;
	}
	
}
