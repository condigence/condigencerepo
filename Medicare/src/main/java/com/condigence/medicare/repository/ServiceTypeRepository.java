package com.condigence.medicare.repository;

import org.springframework.data.repository.CrudRepository;

import com.condigence.medicare.model.ServiceType;

public interface ServiceTypeRepository extends CrudRepository<ServiceType, Long> {

	public ServiceType findById(Long id);

	public ServiceType findByName(String search);

}
