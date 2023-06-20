package com.nhom1.productservice.command.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ProductRepository  extends JpaRepository<Product, String> {

	@Query(nativeQuery = true, value="select * from Product p where p.brand_id = :brand_id")
	public List<Product> getProductsByBrandId(@Param("brand_id") String brand_id);
	
	
	@Query(nativeQuery = true, value="select * from Product p where p.category_id = :category_id")
	public List<Product> getProductsByCategoryId(@Param("category_id") String category_id);
	

	@Query(nativeQuery = true, value="SELECT price FROM Product p where p.id = :id")
	public int findProductPriceByProductID(@Param("id") String id);
}
