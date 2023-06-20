package com.nhom1.productservice.command.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class DeleteCategoryCommand {
	@TargetAggregateIdentifier
	private String id;
	
	
	public DeleteCategoryCommand(String id) {
		super();
		this.id = id;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
	
}
