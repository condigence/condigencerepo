package com.digitmarket.defaultstore.providerservice.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.digitmarket.defaultstore.providerservice.model.ServiceDetails;

@Repository("serviceDetailsRepository")
public interface ServiceDetailsRepository extends CrudRepository<ServiceDetails, UUID> {

	public List<ServiceDetails> findAllByOrderByServiceIdDesc();
	
	public List<ServiceDetails> findAllByOrderByServiceIdDesc(UUID serviceId);
	
	public ServiceDetails findByServiceId(UUID serviceId);
	
	public List<ServiceDetails> findByCategoryId(UUID categoryId);
}
