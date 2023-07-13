package com.nhom1.invoiceservice.command.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceCreateEvent {
   private int invoiceID;
	private int userID;
	private int totalCost;
	private String invoiceDate;
	private String shippingDate;
	private String note;
	private boolean otherShippingAddress;
	private String statusInvoice= "PENDING";
	private String userInvoiceIndex;
	public int getInvoiceID() {
		return invoiceID;
	}
	public void setInvoiceID(int invoiceID) {
		this.invoiceID = invoiceID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
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
