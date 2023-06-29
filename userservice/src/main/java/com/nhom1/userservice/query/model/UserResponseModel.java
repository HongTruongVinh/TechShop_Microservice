package com.nhom1.userservice.query.model;

import java.util.Date;

import com.nhom1.userservice.command.data.Role;

public class UserResponseModel {
	private int userID;
	private String fullname;
	private String phone;
	private String address;
	private String email;
	private String pswd;
	private String gender;
	private Date DOB;
	private short isDeleted;
	private int totalInvoices;

	private Role role;
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date DOB) {
		this.DOB = DOB;
	}
	
	public short getIsDelete() {
		return isDeleted;
	}

	public void setIsDelete(short isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	public int getTotalInvoices() {
		return totalInvoices;
	}

	public void setTotalInvoices(int totalInvoices) {
		this.totalInvoices = totalInvoices;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
	
	public Role getRole() {
		return role;
	}
}
