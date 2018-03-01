package com.digitmarket.defaultstore.config.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.digitmarket.defaultstore.config.model.StoreConfiguration;


@Repository("storeConfigRepository")
public interface StoreConfigRepository extends CrudRepository<StoreConfiguration, UUID> {

	public List<StoreConfiguration> findAllByOrderByStoreIdDesc();
	
}
