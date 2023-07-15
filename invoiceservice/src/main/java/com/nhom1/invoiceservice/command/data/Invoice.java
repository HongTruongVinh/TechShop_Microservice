package com.nhom1.invoiceservice.command.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
	private String _id;
	private String userID;
	private int totalCost;
	private String invoiceDate;
	private String shippingDate;
	private String note;
	private boolean otherShippingAddress;
	private String statusInvoice= "PENDING";
	private String userInvoiceIndex;
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public int getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	public String getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public String getShippingDate() {
		return shippingDate;
	}
	public void setShippingDate(String shippingDate) {
		this.shippingDate = shippingDate;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public boolean isOtherShippingAddress() {
		return otherShippingAddress;
	}
	public void setOtherShippingAddress(boolean otherShippingAddress) {
		this.otherShippingAddress = otherShippingAddress;
	}
	public String getStatusInvoice() {
		return statusInvoice;
	}
	public void setStatusInvoice(String statusInvoice) {
		this.statusInvoice = statusInvoice;
	}
	public String getUserInvoiceIndex() {
		return userInvoiceIndex;
	}
	public void setUserInvoiceIndex(String userInvoiceIndex) {
		this.userInvoiceIndex = userInvoiceIndex;
	}
	
}
