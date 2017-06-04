package com.condigence.medicare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.condigence.medicare.model.ServiceType;

public interface SearchServiceTypeRepository extends JpaRepository<ServiceType, Integer> {

	/**
	 * Finds Service Type by using the name as a search criteria.
	 * 
	 * @param ServiceType
	 * 
	 */
	public ServiceType findByName(String search);

}
