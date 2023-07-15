package com.nhom1.invoiceservice.command.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingInfoRequestModel {
    private String shippingInfoID;
    private String invoiceID;
    private String fullName;
    private String phoneNumber;
    private String address;
    
	public ShoppingInfoRequestModel(String shippingInfoID, String invoiceID, String fullName, String phoneNumber,
			String address) {
		super();
		this.shippingInfoID = shippingInfoID;
		this.invoiceID = invoiceID;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public String getShippingInfoID() {
		return shippingInfoID;
	}

	public void setShippingInfoID(String shippingInfoID) {
		this.shippingInfoID = shippingInfoID;
	}

	public String getInvoiceID() {
		return invoiceID;
	}

	public void setInvoiceID(String invoiceID) {
		this.invoiceID = invoiceID;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
