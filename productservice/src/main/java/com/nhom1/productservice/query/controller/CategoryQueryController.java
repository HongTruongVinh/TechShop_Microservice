package com.nhom1.productservice.query.controller;

import java.util.List;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nhom1.productservice.query.model.CategoryResponseModel;
import com.nhom1.productservice.query.queries.GetAllCategoryQuery;
import com.nhom1.productservice.query.queries.GetCategoriesQuery;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryQueryController {
	
	@Autowired
	private QueryGateway queryGateway;
	
	@GetMapping("/{id}")
	public CategoryResponseModel getCategoryDetail(@PathVariable String id) {
		GetCategoriesQuery getCategoriesQuery = new GetCategoriesQuery();
		getCategoriesQuery.setId(id);
		
		CategoryResponseModel categoryResponseModel = queryGateway.query(getCategoriesQuery, 
				ResponseTypes.instanceOf(CategoryResponseModel.class)).join();
		
		return categoryResponseModel;
	}
	
	@GetMapping()
	public List<CategoryResponseModel> getAllCategoryDetail() {
		GetAllCategoryQuery getAllCategoryQuery = new GetAllCategoryQuery();


		List<CategoryResponseModel> list = queryGateway.query(getAllCategoryQuery, 
				ResponseTypes.multipleInstancesOf(CategoryResponseModel.class)).join();
		
		return list;
	}

}
