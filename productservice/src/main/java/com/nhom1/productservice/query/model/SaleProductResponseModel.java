package com.nhom1.productservice.query.model;

import java.util.Date;

import com.nhom1.productservice.command.data.Product;

public class SaleProductResponseModel {
	private String id;
	private Date startSele;
	private Date endSele;
	private Integer IntproductPrice;
	private short isDelete;
	
	private Product product;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getEndSele() {
		return endSele;
	}
	public void setEndSele(Date endSele) {
		this.endSele = endSele;
	}
	public Integer getIntproductPrice() {
		return IntproductPrice;
	}
	public void setIntproductPrice(Integer intproductPrice) {
		IntproductPrice = intproductPrice;
	}
	public short getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(short isDelete) {
		this.isDelete = isDelete;
	}
	
	public Date getStartSele() {
		return startSele;
	}
	public void setStartSele(Date startSele) {
		this.startSele = startSele;
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
}
