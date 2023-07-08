package com.nhom1.userservice.command.event;

public class UserDeletedEvent {
	private String userID;

	public String getUserId() {
		return userID;
	}

	public void setEmployeeId(String userID) {
		this.userID = userID;
	}
}
