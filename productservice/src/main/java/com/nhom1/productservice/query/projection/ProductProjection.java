package com.nhom1.productservice.query.projection;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import com.nhom1.productservice.query.queries.GetProductsByCategory;
import com.nhom1.productservice.query.queries.GetRelatedBrandProductsQuery;
import com.nhom1.productservice.query.queries.GetRelatedCategoryProductsQuery;
import com.nhom1.productservice.query.queries.GetTopPurchasedByCategoryIdQuery;
import com.nhom1.productservice.query.queries.GetTrendingProductsQuery;
import com.nhom1.productservice.query.queries.getProductToAdvise;
import org.springframework.data.domain.Sort;

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
		Product entity = productRepository.getById(getProductQuery.getId());

		ProductResponseModel model = setResponseModel(entity);

		return model;
	}

	@QueryHandler
	public List<ProductResponseModel> handle(GetAllProductQuery getAllProductQuery) {
		List<Product> listEntity = productRepository.findAll();
		List<ProductResponseModel> listProduct = new ArrayList<>();

		listEntity.forEach(s -> {
			ProductResponseModel model = setResponseModel(s);
			listProduct.add(model);
		});
		return listProduct;
	}

	@QueryHandler
	public List<ProductResponseModel> handle(GetBrandQuery query) {

		Brand entity = brandRepository.getById(query.getId());

		BrandResponseModel brandModel = new BrandResponseModel();
		BeanUtils.copyProperties(entity, brandModel);

		List<ProductResponseModel> list = new ArrayList<>();

		List<Product> listProductEntity = productRepository.getProductsByBrandId(brandModel.get_id());

		listProductEntity.forEach(s -> {
			ProductResponseModel model = setResponseModel(s);
			list.add(model);
		});

		return list;
	}

	@QueryHandler
	public List<ProductResponseModel> handle(GetCategoriesQuery query) {

		Category entity = categoryRepository.getById(query.getId());

		CategoryResponseModel categoryModle = new CategoryResponseModel();
		BeanUtils.copyProperties(entity, categoryModle);

		List<ProductResponseModel> list = new ArrayList<>();

		List<Product> listProductEntity = productRepository.getProductsByCategoryId(categoryModle.getCategoryID());

		listProductEntity.forEach(s -> {
			ProductResponseModel model = setResponseModel(s);
			list.add(model);
		});

		return list;
	}

	@QueryHandler
	public Integer handle(GetPriceProductByIdQuery query) {

		Integer price = productRepository.findProductPriceByProductID(query.getId());

		return price;
	}

	@QueryHandler
	public List<ProductResponseModel> handle(GetTrendingProductsQuery getTrendingProductsQuery) {
		List<Product> listEntity = productRepository.findTrendingProducts();
		List<ProductResponseModel> listProduct = new ArrayList<>();

		listEntity.forEach(s -> {
			try {
				ProductResponseModel model = setResponseModel(s);
				listProduct.add(model);
			} catch (Exception e) {
				System.out.println("productID = " + s.getId() + "  ;  categoryID = " + s.getCategoryID());

			}
		});
		return listProduct;
	}

	@QueryHandler
	public List<ProductResponseModel> handle(GetTopPurchasedByCategoryIdQuery query) {
		List<Product> listEntity = productRepository.findTopPurchasedByCategoryId(query.getId());

		List<ProductResponseModel> listProduct = new ArrayList<>();
		listEntity.forEach(s -> {
			ProductResponseModel model = setResponseModel(s);
			listProduct.add(model);
		});

		return listProduct;
	}

	@QueryHandler
	public List<ProductResponseModel> handle(GetProductsByCategory query) {
		List<Product> listEntity = productRepository.findByCategorySlug(query.getCategorySlug());

		List<ProductResponseModel> listProduct = new ArrayList<>();
		listEntity.forEach(s -> {
			ProductResponseModel model = setResponseModel(s);
			listProduct.add(model);
		});

		return listProduct;
	}

	@QueryHandler
	public List<ProductResponseModel> handle(GetRelatedCategoryProductsQuery query) {
		List<Product> listEntity = productRepository.findRelatedProductsByCategory(query.getProductID());

		List<ProductResponseModel> listProduct = new ArrayList<>();
		listEntity.forEach(s -> {
			ProductResponseModel model = setResponseModel(s);
			listProduct.add(model);
		});

		return listProduct;
	}

	@QueryHandler
	public List<ProductResponseModel> handle(GetRelatedBrandProductsQuery query) {
		List<Product> listEntity = productRepository.findRelatedProductsByBrand(query.getProductID());

		List<ProductResponseModel> listProduct = new ArrayList<>();
		listEntity.forEach(s -> {
			ProductResponseModel model = setResponseModel(s);
			listProduct.add(model);
		});

		return listProduct;
	}

	@QueryHandler
	public List<ProductResponseModel> handle(getProductToAdvise query) {
		Sort sort = Sort.by(Sort.Direction.DESC, "productRate");
		List<Product> products = productRepository.findAll(sort);

		List<Brand> brands = brandRepository.findBrandByNameBrand(query.getbrandName());
		String brandID = brands.size() > 0 ? brands.get(0).get_id() : "";
		System.out.println(brandID);
		List<Category> categorys = categoryRepository.findCategoryByNamCategories(query.getcategoryName());
		String categoryID = categorys.size() > 0 ? categorys.get(0).getId() : "";
		System.out.println(categoryID);

		List<ProductResponseModel> ProductsToAdvise = new ArrayList<ProductResponseModel>();
		System.out.println(query.getPriceMax());
		for (Product product : products) {
			if (product.getCategoryID().equals(categoryID) &&
					product.getBrandID().equals(brandID)
					&& product.getPrice() >= query.getPriceMin() && product.getPrice() <= query.getPriceMax()) {
				ProductResponseModel productDTO = setResponseModel(product);
				ProductsToAdvise.add(productDTO);
			}
			if (ProductsToAdvise.size() == 1)
				break;
		}
		return ProductsToAdvise;
	}

	public ProductResponseModel setResponseModel(Product s) {
		ProductResponseModel model = new ProductResponseModel();

		Category category = categoryRepository.findCategoryById(s.getCategoryID());

		Brand brand = brandRepository.findBrandById(s.getCategoryID());

		if (category != null) {
			model.setCategoryName(category.getName());
			model.setCategorySlug(category.getSlug());
		}

		if (brand != null) {
			model.setBrandName(brand.getBrandName());
		}

		model.setProductID(s.getId());
		model.setProductName(s.getName());
		model.setProductPrice(s.getPrice());
		model.setProductRate(s.getRate());
		model.setPurchased(s.getPurchased());
		model.setShortDescrip(s.getShortDescrip());
		model.setShortTech(s.getTech());
		model.setSpecs(s.getSpecs());
		model.setStock(s.getStock());
		model.setWarranty(s.getWarranty());
		model.setImages(s.getImages());
		model.setLongDescrip(s.getLongDescrip());

		return model;
	}
}
