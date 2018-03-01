package com.digitmarket.defaultstore.providerservice.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.digitmarket.defaultstore.providerservice.model.ServiceRequest;

@Repository("serviceRequestRepository")
public interface ServiceRequestRepository extends CrudRepository<ServiceRequest, UUID> {

	public List<ServiceRequest> findAllByOrderByRequestIdDesc();
}
