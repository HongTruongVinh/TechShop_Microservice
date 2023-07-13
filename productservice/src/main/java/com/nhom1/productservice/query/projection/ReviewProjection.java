package com.nhom1.productservice.query.projection;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nhom1.productservice.command.data.Review;
import com.nhom1.productservice.command.data.ReviewRepository;
import com.nhom1.productservice.query.model.ReviewResponseModel;
import com.nhom1.productservice.query.queries.GetReviewsOfProductQuery;

@Component
public class ReviewProjection {
	@Autowired
	private ReviewRepository reviewRepository;
	
	@QueryHandler
	public List<ReviewResponseModel> handle(GetReviewsOfProductQuery query) {
		List<Review> listEntity = reviewRepository.findReviewsOfProduct(query.getProductID());
		List<ReviewResponseModel> list = new ArrayList<>();
		
		listEntity.forEach(s -> {
			ReviewResponseModel model = new ReviewResponseModel();
			BeanUtils.copyProperties(s, model);
			list.add(model);
		});
		
		return list;
	}
}
