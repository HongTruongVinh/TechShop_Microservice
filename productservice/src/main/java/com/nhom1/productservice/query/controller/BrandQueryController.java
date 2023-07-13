package com.nhom1.productservice.query.controller;

import java.util.List;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nhom1.productservice.query.model.BrandResponseModel;
import com.nhom1.productservice.query.queries.GetAllBrandQuery;
import com.nhom1.productservice.query.queries.GetBrandQuery;

@RestController
@RequestMapping("/api/v1/brand")
public class BrandQueryController {
	@Autowired
	private QueryGateway queryGateway;
	
	@GetMapping("/{id}")
	public BrandResponseModel getBrandDetail(@PathVariable String id) {
		GetBrandQuery getbrandQuery = new GetBrandQuery();
		getbrandQuery.setId(id);
		
		BrandResponseModel BrandResponseModel = queryGateway.query(getbrandQuery, 
				ResponseTypes.instanceOf(BrandResponseModel.class)).join();
		
		return BrandResponseModel;
	}
	
	@GetMapping("")
	public List<BrandResponseModel> getAllBrandDetail() {
		GetAllBrandQuery getAllBrandQuery = new GetAllBrandQuery();


		List<BrandResponseModel> list = queryGateway.query(getAllBrandQuery, 
				ResponseTypes.multipleInstancesOf(BrandResponseModel.class)).join();
		
		return list;
	}

}
