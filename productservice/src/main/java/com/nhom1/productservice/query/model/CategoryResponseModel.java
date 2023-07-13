package com.nhom1.productservice.query.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nhom1.productservice.command.data.Product;

@JsonIgnoreProperties(value= {"products"})
public class CategoryResponseModel {
	private String categoryID;
	private String categoryName;
	private String categorySlug;
	private Boolean categoryExact;
	
	public String getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategorySlug() {
		return categorySlug;
	}
	public void setCategorySlug(String categorySlug) {
		this.categorySlug = categorySlug;
	}
	public Boolean getCategoryExact() {
		return categoryExact;
	}
	public void setCategoryExact(Boolean categoryExact) {
		this.categoryExact = categoryExact;
	}
}
