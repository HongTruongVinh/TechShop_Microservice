package com.nhom1.invoiceservice.command.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailedInvoiceRequestModel {
    private String detailedInvoiceID;
	private String invoiceID;
	private String productID;
	private int quantity;
	private int price;
	private int totalPrice;
	private boolean isReviewed;
	
	public DetailedInvoiceRequestModel(String detailedInvoiceID, String invoiceID, String productID, int quantity, int price,
			int totalPrice, boolean isReviewed) {
		super();
		this.detailedInvoiceID = detailedInvoiceID;
		this.invoiceID = invoiceID;
		this.productID = productID;
		this.quantity = quantity;
		this.price = price;
		this.totalPrice = totalPrice;
		this.isReviewed = isReviewed;
	}
	
	public String getDetailedInvoiceID() {
		return detailedInvoiceID;
	}
	public void setDetailedInvoiceID(String detailedInvoiceID) {
		this.detailedInvoiceID = detailedInvoiceID;
	}
	public String getInvoiceID() {
		return invoiceID;
	}
	public void setInvoiceID(String invoiceID) {
		this.invoiceID = invoiceID;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public boolean isReviewed() {
		return isReviewed;
	}
	public void setReviewed(boolean isReviewed) {
		this.isReviewed = isReviewed;
	}
}
