package com.nhom1.productservice.command.data;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")//categories
public class Category {
	@Id
	private String _id;
	private String categoryName;
	private String categorySlug;
	private short categoryExact;
	private short isDeleted;

	
	public String getId() {
		return _id;
	}
	
	public void setId(String id) {
		this._id = id;
	}

	public String getName() {
		return categoryName;
	}

	public void setName(String name) {
		this.categoryName = name;
	}

	public String getSlug() {
		return categorySlug;
	}

	public void setSlug(String slug) {
		this.categorySlug = slug;
	}

	public short getExact() {
		return categoryExact;
	}

	public void setExact(short exact) {
		this.categoryExact = exact;
	}

	public short getIsDelete() {
		return isDeleted;
	}

	public void setIsDelete(short isDelete) {
		this.isDeleted = isDelete;
	}
	
}
