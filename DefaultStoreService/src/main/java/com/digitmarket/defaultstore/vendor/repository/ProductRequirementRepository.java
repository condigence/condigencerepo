package com.digitmarket.defaultstore.vendor.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.digitmarket.defaultstore.vendor.model.ProductRequirement;


@Repository("productRequirementRepository")
public interface ProductRequirementRepository extends CrudRepository<ProductRequirement, UUID> {

	public List<ProductRequirement> findAllByOrderByProductRequirementIdDesc();
}
