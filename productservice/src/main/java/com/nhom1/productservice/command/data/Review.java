package com.nhom1.productservice.command.data;


import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "review")//Reviews
public class Review {
	@Id
	private String _id;
	private String userID;
	private String productID;
	private String reviewContent;
	private Date reviewDate;
	private float rate;
	private short isDeleted;
	
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}
	
	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public String getId() {
		return _id;
	}
	
	public void setId(String id) {
		this._id = id;
	}

	public short getIsDelete() {
		return isDeleted;
	}

	public void setIsDelete(short isDelete) {
		this.isDeleted = isDelete;
	}
	


}