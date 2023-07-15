package com.nhom1.invoiceservice.query.model;


public class DetailedInvoiceResponseModel {
	private String productID;
	private int productPrice;
	private int quantity;
	private int totalPrice;
	private String productName;
	private boolean isReviewed;
	private String images;
	private String categorySlug;
	
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public boolean isReviewed() {
		return isReviewed;
	}
	public void setReviewed(boolean isReviewed) {
		this.isReviewed = isReviewed;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public String getCategorySlug() {
		return categorySlug;
	}
	public void setCategorySlug(String categorySlug) {
		this.categorySlug = categorySlug;
	}
	
}
