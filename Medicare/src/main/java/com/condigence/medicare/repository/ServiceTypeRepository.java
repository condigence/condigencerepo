package com.condigence.medicare.repository;

import org.springframework.data.repository.CrudRepository;

import com.condigence.medicare.model.ServiceType;

public interface ServiceTypeRepository extends CrudRepository<ServiceType, Integer> {
}
