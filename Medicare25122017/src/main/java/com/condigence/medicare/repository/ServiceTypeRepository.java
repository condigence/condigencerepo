package com.condigence.medicare.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.condigence.medicare.model.ServiceType;

public interface ServiceTypeRepository extends CrudRepository<ServiceType, Long> {

	public List<ServiceType> findAllByOrderByIdDesc();
	
	public ServiceType findById(Long id);

	public ServiceType findByName(String search);

}
