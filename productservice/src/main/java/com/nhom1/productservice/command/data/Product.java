package com.nhom1.productservice.command.data;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
	private String _id;
	private String categoryID;
	private String brandID;
	private String productName;
	private String productRate;
	private String productPrice;
	@Lob 
	private String shortDescrip;
	@Lob 
	private String longDescrip;
	@Lob 
	private String shortTech;
	private String stock;
	private String warranty;
	private String purchased;
	@Lob 
	private String specs;
	private String isSale;
	private String totalReviews;
	@Lob 
	private String images;
	private String isDeleted;
	

	public String getId() {
		return _id;
	}

	public void setId(String id) {
		this._id = id;
	}
	
	public String getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}

	public String getBrandID() {
		return brandID;
	}

	public void setBrandID(String brandID) {
		this.brandID = brandID;
	}

	public String getName() {
		return productName;
	}

	public void setName(String name) {
		this.productName = name;
	}

	public float getRate() {
		return Float.parseFloat(this.productRate);
	}

	public void setRate(float rate) {
		this.productRate = String.valueOf(rate);
	}

	public Integer getPrice() {
		return  Integer.parseInt(productPrice);
	}

	public void setPrice(Integer price) {
		this.productPrice = String.valueOf(price);
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
		return shortTech;
	}

	public void setTech(String tech) {
		this.shortTech = tech;
	}

	public Integer getStock() {
		return Integer.parseInt(stock);
	}

	public void setStock(Integer stock) {
		this.stock = String.valueOf(stock);
	}

	public Integer getWarranty() {
		return  Integer.parseInt(warranty);
	}

	public void setWarranty(Integer warranty) {
		this.warranty =  String.valueOf(warranty);
	}

	public Integer getPurchased() {
		return  Integer.parseInt(purchased);
	}

	public void setPurchased(Integer purchased) {
		this.purchased = String.valueOf(purchased);
	}

	public String getSpecs() {
		return specs;
	}

	public void setSpecs(String specs) {
		this.specs = specs;
	}

	public short getIsSale() {
		Short _isSale = 0;
		
		if(isSale == "1") {
			_isSale = 1;
		}
		return _isSale;
	}

	public void setIsSale(short _isSale) {

		if(_isSale == 0) {
			this.isSale = "0";
		}
		else {
			this.isSale = "1";
		}
	}

	public Integer getTotalReviews() {
		return Integer.parseInt(totalReviews);
	}

	public void setTotalReviews(Integer totalReviews) {
		this.totalReviews = String.valueOf(totalReviews);
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public short getIsDelete() {
		Short _isDeleted = 0;
		
		if(isDeleted == "1") {
			_isDeleted = 1;
		}
		
		return _isDeleted;
	}

	public void setIsDelete(short _isDeleted) {
		
		if(_isDeleted == 0) {
			this.isDeleted = "0";
		}
		else {
			this.isDeleted = "1";
		}
	}

	


}
