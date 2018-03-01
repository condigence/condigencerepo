package com.digitmarket.defaultstore.providerservice.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.digitmarket.defaultstore.providerservice.model.ServiceProviderIdentification;


@Repository("serviceProviderIdentificationRepository")
public interface ServiceProviderIdentificationRepository extends CrudRepository<ServiceProviderIdentification, UUID> {

	public List<ServiceProviderIdentification> findAllByOrderByServiceIdentificationIdDesc();
}
