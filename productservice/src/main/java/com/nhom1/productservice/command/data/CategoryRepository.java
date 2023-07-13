package com.nhom1.productservice.command.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends JpaRepository<Category, String> {

	@Query(nativeQuery = true, value = "select * from onlshop_product.category p where p._id = :id")
	public Category findCategoryById(@Param("id") String id);

	@Query(nativeQuery = true, value = "select * from onlshop_product.category p where p.categoryName = :categoryName")
	public List<Category> findCategoryByNamCategories(@Param("categoryName") String categoryName);

	@Query(nativeQuery = true, value = "select * from onlshop_product.category")
	public List<Category> findAllCategory();

}
