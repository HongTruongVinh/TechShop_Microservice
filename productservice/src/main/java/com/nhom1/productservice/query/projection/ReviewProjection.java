package com.nhom1.productservice.query.projection;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nhom1.commonservice.model.UserResponeseCommonModel;
import com.nhom1.commonservice.query.GetUserDetailCommonQuery;
import com.nhom1.productservice.command.data.Review;
import com.nhom1.productservice.command.data.ReviewRepository;
import com.nhom1.productservice.query.model.ReviewResponseModel;
import com.nhom1.productservice.query.queries.GetReviewsOfProductQuery;

@Component
public class ReviewProjection {

	@Autowired
	private QueryGateway queryGateway;
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@QueryHandler
	public List<ReviewResponseModel> handle(GetReviewsOfProductQuery query) {
		List<Review> listEntity = reviewRepository.findReviewsOfProduct(query.getProductID());
		List<ReviewResponseModel> list = new ArrayList<>();
		
		listEntity.forEach(s -> {
			ReviewResponseModel model = setReviewModel(s);
			
			GetUserDetailCommonQuery userDetaiCommonQuery = new GetUserDetailCommonQuery();
			userDetaiCommonQuery.setUserID(s.getUserID());
			UserResponeseCommonModel userResponeseCommonModel = queryGateway.query(userDetaiCommonQuery, 
					ResponseTypes.instanceOf(UserResponeseCommonModel.class)).join();
			if(userResponeseCommonModel != null) {
				model.setFullname(userResponeseCommonModel.getFullname());
			}
			
			
			list.add(model);
		});
		
		return list;
	}
	
	public ReviewResponseModel setReviewModel(Review entity) {
		ReviewResponseModel model = new ReviewResponseModel();
		model.setProductID(entity.getProductID());
		model.setRate(entity.getRate());
		model.setReviewContent(entity.getReviewContent());
		model.setReviewDate(entity.getReviewDate().toString());
		model.setReviewID(entity.getId());
		return model;
	}
	
}
