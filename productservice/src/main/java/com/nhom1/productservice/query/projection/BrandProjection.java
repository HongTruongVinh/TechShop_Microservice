package com.nhom1.productservice.query.projection;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nhom1.productservice.command.data.Brand;
import com.nhom1.productservice.command.data.BrandRepository;
import com.nhom1.productservice.query.model.BrandResponseModel;
import com.nhom1.productservice.query.queries.GetAllBrandQuery;
import com.nhom1.productservice.query.queries.GetBrandQuery;
@Component
public class BrandProjection {
	
	@Autowired
	private BrandRepository brandRepository;
	
	@QueryHandler
	public BrandResponseModel handle(GetBrandQuery getBrandQuery) {
		BrandResponseModel model = new BrandResponseModel();
		Brand entity = brandRepository.getById(getBrandQuery.getId());
		BeanUtils.copyProperties(entity, model);
		
		return model;
	}
	
	@QueryHandler
	public List<BrandResponseModel> handle(GetAllBrandQuery getAllBrandQuery){
		List<Brand> listEntity = brandRepository.findAllBrand();
		List<BrandResponseModel> listBrand = new ArrayList<>();
		
		listEntity.forEach(s -> {
			BrandResponseModel model = new BrandResponseModel();
			BeanUtils.copyProperties(s, model);
			listBrand.add(model);
		});
		return listBrand;
	}
	
}
