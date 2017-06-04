package com.condigence.medicare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.condigence.medicare.model.Profile;

public interface SearchProfileRepository extends JpaRepository<Profile, Integer> {

	/**
	 * Finds Profile by using the id as a search criteria.
	 * 
	 * @param Profile
	 * 
	 */
	public Profile findById(int id);

}
