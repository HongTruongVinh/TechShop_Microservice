package com.nhom1.productservice.query.projection;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nhom1.productservice.command.data.SaleProduct;
import com.nhom1.productservice.command.data.SaleProductRepository;
import com.nhom1.productservice.query.model.SaleProductResponseModel;
import com.nhom1.productservice.query.queries.GetAllSaleProductQuery;
import com.nhom1.productservice.query.queries.GetSaleProductQuery;

@Component
public class SaleProductProjection {
	@Autowired
	private SaleProductRepository saleProductRepository;
	
	@QueryHandler
	public SaleProductResponseModel handle(GetSaleProductQuery getSaleProductQuery) {
		SaleProductResponseModel model = new SaleProductResponseModel();
		SaleProduct entity = saleProductRepository.getById(getSaleProductQuery.getId());
		BeanUtils.copyProperties(entity, model);
		
		return model;
	}
	
	@QueryHandler
	public List<SaleProductResponseModel> handle(GetAllSaleProductQuery getAllSaleProductQuery){
		List<SaleProduct> listEntity = saleProductRepository.findAll();
		List<SaleProductResponseModel> listSaleProduct = new ArrayList<>();
		
		listEntity.forEach(s -> {
			SaleProductResponseModel model = new SaleProductResponseModel();
			BeanUtils.copyProperties(s, model);
			listSaleProduct.add(model);
		});
		return listSaleProduct;
	}
	
}
