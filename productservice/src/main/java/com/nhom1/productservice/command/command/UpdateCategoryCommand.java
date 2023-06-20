package com.nhom1.productservice.command.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class UpdateCategoryCommand {
	@TargetAggregateIdentifier
	private String id;
	private String name;
	private String slug;
	private short exact;
	private short isDelate;
	
	
	public UpdateCategoryCommand(String id,String name, String slug, short exact, short isDelate) {
		super();
		this.id = id;
		this.name = name;
		this.slug = slug;
		this.exact = exact;
		this.isDelate = 0;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public short getExact() {
		return exact;
	}

	public void setExact(short exact) {
		this.exact = exact;
	}

	public short getIsDelate() {
		return isDelate;
	}

	public void setIsDelate(short isDelate) {
		this.isDelate = isDelate;
	}
}
