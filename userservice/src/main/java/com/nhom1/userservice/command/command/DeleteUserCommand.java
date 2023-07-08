package com.nhom1.userservice.command.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class DeleteUserCommand {
	@TargetAggregateIdentifier
	private String userID;

	public String getUserId() {
		return userID;
	}

	public void setEmployeeId(String userID) {
		this.userID = userID;
	}

	public DeleteUserCommand(String userID) {
		super();
		this.userID = userID;
	}
}
