package com.digitmarket.defaultstore.vendor.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.digitmarket.defaultstore.vendor.model.Product;


@Repository("productRepository")
public interface ProductRepository extends CrudRepository<Product, UUID> {

	public List<Product> findAllByOrderByProductIdDesc();

	public Product findByProductId(UUID productId);

}
