package com.nhom1.productservice.command.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ProductRepository extends JpaRepository<Product, String> {

	@Query(nativeQuery = true, value = "select * from onlshop_product.product p where p.brandID = :brand_id")
	public List<Product> getProductsByBrandId(@Param("brand_id") String brand_id);

	@Query(nativeQuery = true, value = "select * from onlshop_product.product p where p.categoryID = :category_id")
	public List<Product> getProductsByCategoryId(@Param("category_id") String category_id);

	@Query(nativeQuery = true, value = "SELECT price FROM onlshop_product.product p where p._id = :id")
	public int findProductPriceByProductID(@Param("id") String id);

	@Query(nativeQuery = true, value = "SELECT p._id, p.categoryID, p.brandID, p.productName, p.productRate, p.productPrice, p.shortDescrip, p.longDescrip, p.shortTech, p.stock, p.warranty, p.purchased, p.specs, p.isSale, p.totalReviews, p.images, p.isDeleted FROM onlshop_product.product p, onlshop_product.category c, onlshop_product.brand b WHERE p.categoryID = c._id AND p.brandID = b._id ORDER BY p.purchased DESC limit 12")
	public List<Product> findTrendingProducts();

	@Query(nativeQuery = true, value = "SELECT p._id, p.categoryID, p.brandID, p.productName, p.productRate, p.productPrice, p.shortDescrip, p.longDescrip, p.shortTech, p.stock, p.warranty, p.purchased, p.specs, p.isSale, p.totalReviews, p.images, p.isDeleted FROM onlshop_product.product p, onlshop_product.category c, onlshop_product.brand b WHERE p.categoryID = c._id AND p.brandID = b._id AND c._id = :id ORDER BY p.purchased DESC")
	public List<Product> findTopPurchasedByCategoryId(@Param("id") String categoryID);

	@Query(nativeQuery = true, value = "SELECT p._id, p.categoryID, p.brandID, p.productName, p.productRate, p.productPrice, p.shortDescrip, p.longDescrip, p.shortTech, p.stock, p.warranty, p.purchased, p.specs, p.isSale, p.totalReviews, p.images, p.isDeleted FROM onlshop_product.product p, onlshop_product.category c, onlshop_product.brand b WHERE p.categoryID = c._id AND p.brandID = b._id AND c.categorySlug = :categorySlug")
	public List<Product> findByCategorySlug(@Param("categorySlug") String categorySlug);

	@Query(nativeQuery = true, value = "SELECT p._id, p.categoryID, p.brandID, p.productName, p.productRate, p.productPrice, p.shortDescrip, p.longDescrip, p.shortTech, p.stock, p.warranty, p.purchased, p.specs, p.isSale, p.totalReviews, p.images, p.isDeleted FROM onlshop_product.product p, onlshop_product.category c, onlshop_product.brand b WHERE p.categoryID = c._id AND p.brandID = b._id AND p._id != :productID AND c._id = (SELECT categoryID FROM onlshop_product.product p where p._id = :productID) ")
	public List<Product> findRelatedProductsByCategory(@Param("productID") String productID);

	@Query(nativeQuery = true, value = "SELECT p._id, p.categoryID, p.brandID, p.productName, p.productRate, p.productPrice, p.shortDescrip, p.longDescrip, p.shortTech, p.stock, p.warranty, p.purchased, p.specs, p.isSale, p.totalReviews, p.images, p.isDeleted FROM onlshop_product.product p, onlshop_product.category c, onlshop_product.brand b WHERE p.categoryID = c._id AND p.brandID = b._id AND p._id != :productID AND b._id = (SELECT brandID FROM onlshop_product.product p where p._id = :productID)")
	public List<Product> findRelatedProductsByBrand(@Param("productID") String productID);
}
