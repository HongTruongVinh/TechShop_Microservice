package com.nhom1.invoiceservice.query.model;

import java.util.List;


public class InvoiceResponseModel {
	List<DetailedInvoiceResponseModel> detailedInvoices;
	ShippingInfoResponseModel shippingInfo;

	private String email;
	private int totalPrice;
	private String note;
	private String statusInvoice;
	private String shippingDate;
	private String invoiceDate;
	
	
	public List<DetailedInvoiceResponseModel> getDetailedInvoices() {
		return detailedInvoices;
	}
	public void setDetailedInvoices(List<DetailedInvoiceResponseModel> detailedInvoices) {
		this.detailedInvoices = detailedInvoices;
	}
	public ShippingInfoResponseModel getShippingInfo() {
		return shippingInfo;
	}
	public void setShippingInfo(ShippingInfoResponseModel shippingInfo) {
		this.shippingInfo = shippingInfo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getStatusInvoice() {
		return statusInvoice;
	}
	public void setStatusInvoice(String statusInvoice) {
		this.statusInvoice = statusInvoice;
	}
	public String getShippingDate() {
		return shippingDate;
	}
	public void setShippingDate(String shippingDate) {
		this.shippingDate = shippingDate;
	}
	public String getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	
	
}
