package com.condigence.medicare.repository;

import org.springframework.data.repository.CrudRepository;

import com.condigence.medicare.model.Profile;

public interface ProfileRepository extends CrudRepository<Profile, Integer> {
	
	public Profile findById(int id);


}
