package com.nhom1.commonservice.model;

public class ProductResponseCommonModel {
	private String productID;
	private String categoryName;
	private String brandName;
	private float productRate;
	private String productName;
	private Integer productPrice;
	private String shortDescrip;
	private String longDescrip;
	private String shortTech;
	private Integer stock;
	private Integer warranty;
	private Integer purchased;
	private String specs;
	private String categorySlug;
	private String images;
	
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public float getProductRate() {
		return productRate;
	}
	public void setProductRate(Float productRate) {
		this.productRate = productRate;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}
	public String getShortDescrip() {
		return shortDescrip;
	}
	public void setShortDescrip(String shortDescrip) {
		this.shortDescrip = shortDescrip;
	}
	public String getLongDescrip() {
		return longDescrip;
	}
	public void setLongDescrip(String longDescrip) {
		this.longDescrip = longDescrip;
	}
	public String getShortTech() {
		return shortTech;
	}
	public void setShortTech(String shortTech) {
		this.shortTech = shortTech;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Integer getWarranty() {
		return warranty;
	}
	public void setWarranty(Integer warranty) {
		this.warranty = warranty;
	}
	public Integer getPurchased() {
		return purchased;
	}
	public void setPurchased(Integer purchased) {
		this.purchased = purchased;
	}
	public String getSpecs() {
		return specs;
	}
	public void setSpecs(String specs) {
		this.specs = specs;
	}
	public String getCategorySlug() {
		return categorySlug;
	}
	public void setCategorySlug(String categorySlug) {
		this.categorySlug = categorySlug;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
}
