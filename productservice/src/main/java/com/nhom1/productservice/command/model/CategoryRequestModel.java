package com.nhom1.productservice.command.model;

public class CategoryRequestModel {
	private String id;
	private String name;
	private String slug;
	private short exact;
	private short isDelete;
	
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

	public short getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(short isDelete) {
		this.isDelete = isDelete;
	}
}
