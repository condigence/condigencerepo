package com.digitmarket.defaultstore.vendor.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.digitmarket.defaultstore.vendor.model.Product;
import com.digitmarket.defaultstore.vendor.model.ProductImage;


@Repository("productImageRepository")
public interface ProductImageRepository extends CrudRepository<ProductImage, UUID> {

	public List<Product> findAllByOrderByProductImageIdDesc();

}
