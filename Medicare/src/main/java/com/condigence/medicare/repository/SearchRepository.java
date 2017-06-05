package com.condigence.medicare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.condigence.medicare.model.UserType;

public interface SearchRepository extends JpaRepository<UserType, Integer> {

	/**
	 * Finds User Type by using the name as a search criteria.
	 * 
	 * @param UserType
	 * @return A list of User Type whose last name is an exact match with the
	 *         given name. If no User Type is found, this method returns null.
	 */
	public UserType findByType(String search);

}
