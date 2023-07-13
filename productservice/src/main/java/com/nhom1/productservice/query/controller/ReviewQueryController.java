package com.nhom1.productservice.query.controller;

import java.util.List;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nhom1.productservice.query.model.ReviewResponseModel;
import com.nhom1.productservice.query.queries.GetReviewsOfProductQuery;

@RestController
@RequestMapping("api/v1/review")
public class ReviewQueryController {
	
	@Autowired
	private QueryGateway queryGateway;
	
	@GetMapping("/{productID}")
	public List<ReviewResponseModel> getAllReviewsByProductID(@PathVariable String productID, @RequestParam int limit, @RequestParam int page) 
	{
		GetReviewsOfProductQuery query = new GetReviewsOfProductQuery();
		query.setProductID(productID);
		query.setLimit(limit);
		query.setPage(page);
		
		List<ReviewResponseModel> list = queryGateway.query(query, 
				ResponseTypes.multipleInstancesOf(ReviewResponseModel.class)).join();
		
		return list;
	}
	

}