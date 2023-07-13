package com.nhom1.productservice.command.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReviewRepository extends JpaRepository<Review, String> {
	@Query(nativeQuery = true, value = "SELECT r._id, r.productID, r.isDeleted, r.rate, r.reviewContent, r.reviewDate, r.userID FROM onlshop_product.product p, onlshop_product.review r WHERE r.productID = p._id AND p._id = :productID")
	public List<Review> findReviewsOfProduct(@Param("productID") String productID);
	
	
}
