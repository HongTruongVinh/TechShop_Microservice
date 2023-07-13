package com.nhom1.productservice.command.data;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "saleproduct")
public class SaleProduct {
	@Id
	private String _id;
	private Date startSele;
	private Date endSele;
	private Integer productPrice;
	private short isDelete;
	
	public String getId() {
		return _id;
	}
	public void setId(String id) {
		this._id = id;
	}
	public Date getEndSele() {
		return endSele;
	}
	public void setEndSele(Date endSele) {
		this.endSele = endSele;
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

	public Integer getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}
}
