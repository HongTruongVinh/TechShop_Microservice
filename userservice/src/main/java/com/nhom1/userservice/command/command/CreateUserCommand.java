package com.nhom1.userservice.command.command;

import java.util.Date;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateUserCommand {
	@TargetAggregateIdentifier
	private String userID;
	private String email;
	private String fullname;
	private String pswd;
	private Date DOB;
	private String phone;
	private String address;
	private String roleID = "1";
	private String gender;
	private int totalInvoices = 0;
	private short isDeleted;
	
	public CreateUserCommand(String userID, String email, String fullname, String pswd, Date DOB, String phone, String address,
			String roleID, String gender, int totalInvoices, short isDeleted) {
		super();
		this.userID = userID;
		this.email = email;
		this.fullname = fullname;
		this.pswd = pswd;
		this.DOB = DOB;
		this.phone = phone;
		this.address = address;
		this.roleID = roleID;
		this.gender = gender;
		this.totalInvoices = totalInvoices;
		this.isDeleted = isDeleted;
	}
	
	public int getTotalInvoices() {
		return totalInvoices;
	}
	public void setTotalInvoices(int totalInvoices) {
		this.totalInvoices = totalInvoices;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
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
	public String getRoleID() {
		return roleID;
	}
	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public short getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(short isDeleted) {
		this.isDeleted = isDeleted;
	}
}
