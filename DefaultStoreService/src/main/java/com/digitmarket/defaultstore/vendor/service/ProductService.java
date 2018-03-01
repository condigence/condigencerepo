package com.digitmarket.defaultstore.vendor.service;

import java.util.List;

import com.digitmarket.defaultstore.vendor.bean.ProductBean;
import com.digitmarket.defaultstore.vendor.bean.ProductImageBean;
import com.digitmarket.defaultstore.vendor.dto.ProductDTO;
import com.digitmarket.defaultstore.vendor.dto.ProductImageDTO;


/**
 * @author user
 *
 */
public interface ProductService {

	public List<ProductDTO> findAll();

	public ProductDTO save(ProductBean appointment);	
	
	public ProductImageDTO saveProductImage(ProductImageBean productImageBean);

}
