package com.digitmarket.defaultstore.providerservice.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.digitmarket.defaultstore.providerservice.model.ServiceProviderMap;


@Repository("serviceProviderMapRepository")
public interface ServiceProviderMapRepository extends CrudRepository<ServiceProviderMap, UUID> {

	public List<ServiceProviderMap> findAllByOrderByServiceMapIdDesc();
}
