package com.ravenclaw.model;

public class MerchantStatus {

	String vendorStatus;
	
	public MerchantStatus() {
		this.vendorStatus = null;
	}

    //this will set the transaction status as sent to the vendor
	public String getVendorStatus() {
		return vendorStatus;
	}

	public void setVendorStatus(String vendorStatus) {
		this.vendorStatus = vendorStatus;
	}
}
