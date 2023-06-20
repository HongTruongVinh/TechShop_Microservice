package com.nhom1.productservice.query.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nhom1.productservice.command.data.Brand;
import com.nhom1.productservice.command.data.Category;
import com.nhom1.productservice.command.data.SaleProduct;

@JsonIgnoreProperties(value= {"saleProducts", "category", "brand"})
public class ProductResponseModel {
	private String id;
	private String name;
	private float rate;
	private Integer price;
	private String shortDescrip;
	private String longDescrip;
	private String tech;
	private Integer stock;
	private Integer warranty;
	private Integer purchased;
	private String specs;
	private short isSale;
	private Integer totalReviews;
	private Integer images;
	private short isDelete;
	
	
	private Category category;
	
	private Brand brand;
	
	private List<SaleProduct> saleProducts;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
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

	public String getTech() {
		return tech;
	}

	public void setTech(String tech) {
		this.tech = tech;
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

	public short getIsSale() {
		return isSale;
	}

	public void setIsSale(short isSale) {
		this.isSale = isSale;
	}

	public Integer getTotalReviews() {
		return totalReviews;
	}

	public void setTotalReviews(Integer totalReviews) {
		this.totalReviews = totalReviews;
	}

	public Integer getImages() {
		return images;
	}

	public void setImages(Integer images) {
		this.images = images;
	}

	public short getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(short isDelete) {
		this.isDelete = isDelete;
	}
	/*
	 * public Category getCategory() { return category; }
	 * 
	 * public void setCategory(Category category) { this.category = category; }
	 * 
	 * public Brand getBrand() { return brand; }
	 * 
	 * public void setBrand(Brand brand) { this.brand = brand; }
	 * 
	 * public List<SaleProduct> getSaleProducts() { return saleProducts; }
	 * 
	 * public void setSaleProducts(List<SaleProduct> saleProducts) {
	 * this.saleProducts = saleProducts; }
	 */
}
