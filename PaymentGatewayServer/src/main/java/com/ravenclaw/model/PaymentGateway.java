package com.ravenclaw.model;

public class PaymentGateway {

	private String pgstatus;
	private int transactionid;
	
    public PaymentGateway(){
		this.pgstatus = null;
		this.transactionid = 0;
	}
	
    
	public String getPgstatus() {
		return pgstatus;
	}

    //set the status that has been sent to pg server
	public void setPgstatus(String pgstatus) {
		this.pgstatus = pgstatus;
	}

	public int getTransactionid() {
		return transactionid;
	}

    //generate transaction id to be sent to the merchant
	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}
}
