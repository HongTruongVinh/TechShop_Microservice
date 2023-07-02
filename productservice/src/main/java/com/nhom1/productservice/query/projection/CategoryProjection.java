package com.nhom1.productservice.query.projection;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nhom1.commonservice.model.CategoryResponseCommonModel;
import com.nhom1.commonservice.query.GetListCategoryQuery;
import com.nhom1.productservice.command.data.Category;
import com.nhom1.productservice.command.data.CategoryRepository;
import com.nhom1.productservice.query.model.CategoryResponseModel;
import com.nhom1.productservice.query.queries.GetAllCategoryQuery;
import com.nhom1.productservice.query.queries.GetCategoriesQuery;

@Component
public class CategoryProjection {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@QueryHandler
	public CategoryResponseModel handle(GetCategoriesQuery getCategoriesQuery) {
		CategoryResponseModel model = new CategoryResponseModel();
		Category category = categoryRepository.getById(getCategoriesQuery.getId());
		BeanUtils.copyProperties(category, model);
		
		return model;
	}
	
	@QueryHandler
	public List<CategoryResponseModel> handle(GetAllCategoryQuery getAllCategoryQuery){
		List<Category> listEntity = categoryRepository.findAll();
		List<CategoryResponseModel> listCategory = new ArrayList<>();
		
		listEntity.forEach(s -> {
			CategoryResponseModel model = new CategoryResponseModel();
			BeanUtils.copyProperties(s, model);
			listCategory.add(model);
		});
		return listCategory;
	}
	
	@QueryHandler
	public List<CategoryResponseCommonModel> handle(GetListCategoryQuery getListCategoryQuery){
		System.out.print("run getListCtaegory in ProductService");
		List<Category> listEntity = categoryRepository.findAll();
		List<CategoryResponseCommonModel> listCategory = new ArrayList<>();
		
		listEntity.forEach(s -> {
			CategoryResponseCommonModel model = new CategoryResponseCommonModel();
			BeanUtils.copyProperties(s, model);
			listCategory.add(model);
		});
		return listCategory;
	}
	
}
