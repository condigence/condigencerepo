package com.digitmarket.defaultstore.vendor.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.digitmarket.defaultstore.vendor.model.ProductDependency;


@Repository("productDependencyRepository")
public interface ProductDependencyRepository extends CrudRepository<ProductDependency, UUID> {

	public List<ProductDependency> findAllByOrderByProductDependencyIdDesc();
}
