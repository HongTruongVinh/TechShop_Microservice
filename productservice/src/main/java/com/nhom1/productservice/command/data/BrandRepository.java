package com.nhom1.productservice.command.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BrandRepository  extends JpaRepository<Brand, String> {

	@Query(nativeQuery = true, value="select * from onlshop_product.brand b where b._id = :id")
	public Brand findBrandById(@Param("id") String id);
	
	@Query(nativeQuery = true, value="select * from onlshop_product.brand")
	public List<Brand> findAllBrand();
}
