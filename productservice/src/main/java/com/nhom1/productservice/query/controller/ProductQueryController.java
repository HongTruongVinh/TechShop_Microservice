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
import com.nhom1.productservice.query.queries.GetProductsByCategory;
import com.nhom1.productservice.query.queries.GetRelatedBrandProductsQuery;
import com.nhom1.productservice.query.queries.GetRelatedCategoryProductsQuery;
import com.nhom1.productservice.query.queries.GetTopPurchasedByCategoryIdQuery;
import com.nhom1.productservice.query.queries.GetTrendingProductsQuery;

@RestController
@RequestMapping("/api/v1/product")
public class ProductQueryController {

	@Autowired
	private QueryGateway queryGateway;
	
	@GetMapping("")
	public List<ProductResponseModel> getAllProduct() {
		GetAllProductQuery getAllProductQuery = new GetAllProductQuery();


		List<ProductResponseModel> list = queryGateway.query(getAllProductQuery, 
				ResponseTypes.multipleInstancesOf(ProductResponseModel.class)).join();
		
		return list;
	}
	
	@GetMapping("/{productID}")
	public ProductResponseModel getDetailedProduct(@PathVariable String productID) {
		GetProductQuery getProductQuery = new GetProductQuery();
		getProductQuery.setId(productID);
		
		ProductResponseModel ProductResponseModel = queryGateway.query(getProductQuery, 
				ResponseTypes.instanceOf(ProductResponseModel.class)).join();
		
		return ProductResponseModel;
	}
	
	@GetMapping("/category/{categorySlug}")
	public List<ProductResponseModel> getProductsByCategory(@PathVariable String categorySlug) {
		GetProductsByCategory query = new GetProductsByCategory();
		query.setCategorySlug(categorySlug);
		
		List<ProductResponseModel> list = queryGateway.query(query, 
				ResponseTypes.multipleInstancesOf(ProductResponseModel.class)).join();
		
		return list;
	}
	
	@GetMapping("/toppurchased/{categoryID}")
	public List<ProductResponseModel> GetTopPurchasedByCategoryId(@PathVariable String categoryID) {
		GetTopPurchasedByCategoryIdQuery query = new GetTopPurchasedByCategoryIdQuery();
		query.setId(categoryID);

		List<ProductResponseModel> list = queryGateway.query(query, 
				ResponseTypes.multipleInstancesOf(ProductResponseModel.class)).join();
		
		return list;
	}

	@GetMapping("/trending")
	public List<ProductResponseModel> getTrendingProducts() {
		GetTrendingProductsQuery getTrendingProductsQuery = new GetTrendingProductsQuery();

		List<ProductResponseModel> list = queryGateway.query(getTrendingProductsQuery, 
				ResponseTypes.multipleInstancesOf(ProductResponseModel.class)).join();
		
		return list;
	}
	
	@GetMapping("related-category/{productID}")
	public List<ProductResponseModel> getRelatedCategoryProducts(@PathVariable String productID) {
		GetRelatedCategoryProductsQuery query = new GetRelatedCategoryProductsQuery();
		query.setProductID(productID);
		
		List<ProductResponseModel> list = queryGateway.query(query, 
				ResponseTypes.multipleInstancesOf(ProductResponseModel.class)).join();
		
		return list;
	}
	
	@GetMapping("related-brand/{productID}")
	public List<ProductResponseModel> getRelatedBrandProducts(@PathVariable String productID) {
		GetRelatedBrandProductsQuery query = new GetRelatedBrandProductsQuery();
		query.setProductID(productID);
		
		List<ProductResponseModel> list = queryGateway.query(query, 
				ResponseTypes.multipleInstancesOf(ProductResponseModel.class)).join();
		
		return list;
	}
	
	///////////////////////////////////////////////////////////////////////////////////
	
	
	
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
