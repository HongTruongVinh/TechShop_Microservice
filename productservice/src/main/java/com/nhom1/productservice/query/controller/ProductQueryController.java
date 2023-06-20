package com.nhom1.productservice.query.controller;

import java.util.List;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nhom1.productservice.query.model.ProductResponseModel;
import com.nhom1.productservice.query.queries.GetAllProductQuery;
import com.nhom1.productservice.query.queries.GetBrandQuery;
import com.nhom1.productservice.query.queries.GetCategoriesQuery;
import com.nhom1.productservice.query.queries.GetPriceProductByIdQuery;
import com.nhom1.productservice.query.queries.GetProductQuery;

@RestController
@RequestMapping("/api/v1/product")
public class ProductQueryController {

	@Autowired
	private QueryGateway queryGateway;
	
	@GetMapping("/{id}")
	public ProductResponseModel getProductDetail(@PathVariable String id) {
		GetProductQuery getProductQuery = new GetProductQuery();
		getProductQuery.setId(id);
		
		ProductResponseModel ProductResponseModel = queryGateway.query(getProductQuery, 
				ResponseTypes.instanceOf(ProductResponseModel.class)).join();
		
		return ProductResponseModel;
	}
	
	@GetMapping()
	public List<ProductResponseModel> getAllProductDetail() {
		GetAllProductQuery getAllProductQuery = new GetAllProductQuery();


		List<ProductResponseModel> list = queryGateway.query(getAllProductQuery, 
				ResponseTypes.multipleInstancesOf(ProductResponseModel.class)).join();
		
		return list;
	}
	
	@GetMapping("IdBrand/{IdBrand}")
	public List<ProductResponseModel> getProductsByBrandId(@PathVariable String IdBrand) {
		GetBrandQuery query = new GetBrandQuery();
		query.setId(IdBrand);

		List<ProductResponseModel> list = queryGateway.query(query, 
				ResponseTypes.multipleInstancesOf(ProductResponseModel.class)).join();
		
		return list;
	}
	
	@GetMapping("IdCategory/{IdCategory}")
	public List<ProductResponseModel> getProductsByCategoryId(@PathVariable String IdCategory) {
		GetCategoriesQuery query = new GetCategoriesQuery();
		query.setId(IdCategory);

		List<ProductResponseModel> list = queryGateway.query(query, 
				ResponseTypes.multipleInstancesOf(ProductResponseModel.class)).join();
		
		return list;
	}
	
	@GetMapping("/price/{id}")
	public int getPriceProduct(@PathVariable String id) {
		GetPriceProductByIdQuery query = new GetPriceProductByIdQuery();
		query.setId(id);
		
		Integer price = queryGateway.query(query, 
				ResponseTypes.instanceOf(Integer.class)).join();
		
		return price;
	}
}
