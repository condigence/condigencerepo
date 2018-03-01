package com.digitmarket.defaultstore.vendor.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitmarket.defaultstore.vendor.bean.ProductBean;
import com.digitmarket.defaultstore.vendor.bean.ProductDependencyBean;
import com.digitmarket.defaultstore.vendor.bean.ProductImageBean;
import com.digitmarket.defaultstore.vendor.bean.ProductRequirementBean;
import com.digitmarket.defaultstore.vendor.dto.ProductDTO;
import com.digitmarket.defaultstore.vendor.dto.ProductImageDTO;
import com.digitmarket.defaultstore.vendor.model.Category;
import com.digitmarket.defaultstore.vendor.model.Product;
import com.digitmarket.defaultstore.vendor.model.ProductDependency;
import com.digitmarket.defaultstore.vendor.model.ProductImage;
import com.digitmarket.defaultstore.vendor.model.ProductRequirement;
import com.digitmarket.defaultstore.vendor.repository.ProductImageRepository;
import com.digitmarket.defaultstore.vendor.repository.ProductRepository;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	ProductImageRepository productImageRepository;

	Timestamp currentTimestamp = new Timestamp(Calendar.getInstance().getTime().getTime());

	@Override
	public List<ProductDTO> findAll() {
		List<Product> productList = (ArrayList<Product>) productRepository.findAllByOrderByProductIdDesc();
		List<ProductDTO> productDTOs = new ArrayList<>();
		for (Product product : productList) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProductDescription(product.getProductDescription());
			productDTO.setProductId(product.getProductId());
			productDTO.setProductTitle(product.getProductTitle());
			productDTO.setProductVersion(product.getProductVersion());
			productDTO.setLastUpdatedOn(product.getLastUpdatedOn());
			productDTOs.add(productDTO);
		}
		return productDTOs;
	}

	@Override
	public ProductDTO save(ProductBean productBean) {
		Product product = new Product();
		product.setProductDescription(productBean.getProductDescription());
		product.setProductId(UUID.randomUUID());
		product.setProductTitle(productBean.getProductTitle());
		product.setProductVersion(productBean.getProductVersion());
		product.setLastUpdatedOn(currentTimestamp);
		product.setProductStatus("ACTIVE");

		Category category = new Category();
		category.setCategoryId(productBean.getCategoryId());
		product.setCategories(new HashSet<Category>(Arrays.asList(category)));

		Set<ProductRequirement> requirements = new HashSet<>();
		for (ProductRequirementBean prb : productBean.getProductRequirements()) {
			ProductRequirement productRequirement = new ProductRequirement();
			productRequirement.setProduct(product);
			productRequirement.setRequirementName(prb.getRequirementName());
			productRequirement.setRequirementRefrence(prb.getRequirementRefrence());
			productRequirement.setProductRequirementId(UUID.randomUUID());
			requirements.add(productRequirement);
		}
		product.setRequirements(requirements);

		Set<ProductDependency> dependencies = new HashSet<>();
		for (ProductDependencyBean pdb : productBean.getProductDependencies()) {
			ProductDependency dependency = new ProductDependency();
			dependency.setDependencyName(pdb.getDependencyName());
			dependency.setDependencyRefrence(pdb.getDependencyRefrence());
			dependency.setProductDependencyId(UUID.randomUUID());
			dependency.setProduct(product);
			dependencies.add(dependency);
		}
		product.setDependencies(dependencies);

		Product savedProduct = productRepository.save(product);
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductId(savedProduct.getProductId());
		return productDTO;
	}

	@Override
	public ProductImageDTO saveProductImage(ProductImageBean productImageBean) {
		ProductImage productImage = new ProductImage();
		productImage.setImageName(productImageBean.getImageName());
		productImage.setProductImageId(UUID.randomUUID());
		productImage.setImagePath(productImageBean.getImagePath());
		productImage.setLastUpdatedOn(currentTimestamp);
		productImage.setFkProductId(productImageBean.getProductId());
		ProductImage savedProductImage = productImageRepository.save(productImage);
		ProductImageDTO productImageDTO = new ProductImageDTO();
		productImageDTO.setProductIimageId(savedProductImage.getProductImageId());
		return productImageDTO;
	}

}
