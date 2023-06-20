package com.nhom1.productservice.query.controller;

import java.util.List;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nhom1.productservice.query.model.SaleProductResponseModel;
import com.nhom1.productservice.query.queries.GetAllSaleProductQuery;
import com.nhom1.productservice.query.queries.GetCategoriesQuery;

@RestController
@RequestMapping("/api/v1/saleproduct")
public class SaleProductQueryController {
	@Autowired
	private QueryGateway queryGateway;
	
	@GetMapping("/{id}")
	public SaleProductResponseModel getSaleProductDetail(@PathVariable String id) {
		GetCategoriesQuery getProdutQuery = new GetCategoriesQuery();
		getProdutQuery.setId(id);
		
		SaleProductResponseModel SaleProductResponseModel = queryGateway.query(getProdutQuery, 
				ResponseTypes.instanceOf(SaleProductResponseModel.class)).join();
		
		return SaleProductResponseModel;
	}
	
	@GetMapping()
	public List<SaleProductResponseModel> getAllSaleProductDetail() {
		GetAllSaleProductQuery getAllSaleProductQuery = new GetAllSaleProductQuery();


		List<SaleProductResponseModel> list = queryGateway.query(getAllSaleProductQuery, 
				ResponseTypes.multipleInstancesOf(SaleProductResponseModel.class)).join();
		
		return list;
	}
}
