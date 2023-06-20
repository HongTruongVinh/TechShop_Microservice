package com.nhom1.productservice.query.projection;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nhom1.productservice.command.data.Brand;
import com.nhom1.productservice.command.data.BrandRepository;
import com.nhom1.productservice.command.data.Category;
import com.nhom1.productservice.command.data.CategoryRepository;
import com.nhom1.productservice.command.data.Product;
import com.nhom1.productservice.command.data.ProductRepository;
import com.nhom1.productservice.query.model.BrandResponseModel;
import com.nhom1.productservice.query.model.CategoryResponseModel;
import com.nhom1.productservice.query.model.ProductResponseModel;
import com.nhom1.productservice.query.queries.GetAllProductQuery;
import com.nhom1.productservice.query.queries.GetBrandQuery;
import com.nhom1.productservice.query.queries.GetCategoriesQuery;
import com.nhom1.productservice.query.queries.GetPriceProductByIdQuery;
import com.nhom1.productservice.query.queries.GetProductQuery;

@Component
public class ProductProjection {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private BrandRepository brandRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	@QueryHandler
	public ProductResponseModel handle(GetProductQuery getProductQuery) {
		ProductResponseModel model = new ProductResponseModel();
		Product entity = productRepository.getById(getProductQuery.getId());
		BeanUtils.copyProperties(entity, model);
		
		return model;
	}
	
	@QueryHandler
	public List<ProductResponseModel> handle(GetAllProductQuery getAllProductQuery){
		List<Product> listEntity = productRepository.findAll();
		List<ProductResponseModel> listProduct = new ArrayList<>();
		
		listEntity.forEach(s -> {
			ProductResponseModel model = new ProductResponseModel();
			BeanUtils.copyProperties(s, model);
			listProduct.add(model);
		});
		return listProduct;
	}
	

	@QueryHandler
	public List<ProductResponseModel> handle(GetBrandQuery query){
		
		Brand entity = brandRepository.getById(query.getId());
		
		BrandResponseModel brandModel = new BrandResponseModel();
		BeanUtils.copyProperties(entity, brandModel);
		
		List<ProductResponseModel> list = new ArrayList<>();
		
		List<Product> listProductEntity =  productRepository.getProductsByBrandId(brandModel.getId());
		
		listProductEntity.forEach(s -> {
			ProductResponseModel model = new ProductResponseModel();
			BeanUtils.copyProperties(s, model);
			list.add(model);
		});
		
		return list;
	}
	
	@QueryHandler
	public List<ProductResponseModel> handle(GetCategoriesQuery query){
		
		Category entity = categoryRepository.getById(query.getId());
		
		CategoryResponseModel categoryModle = new CategoryResponseModel();
		BeanUtils.copyProperties(entity, categoryModle);
		
		List<ProductResponseModel> list = new ArrayList<>();
		
		List<Product> listProductEntity =  productRepository.getProductsByCategoryId(categoryModle.getId());
		
		listProductEntity.forEach(s -> {
			ProductResponseModel model = new ProductResponseModel();
			BeanUtils.copyProperties(s, model);
			list.add(model);
		});
		
		return list;
	}
	
	@QueryHandler
	public Integer handle(GetPriceProductByIdQuery query) {
		
		Integer price = productRepository.findProductPriceByProductID(query.getId());
		
		return price;
	}
}
