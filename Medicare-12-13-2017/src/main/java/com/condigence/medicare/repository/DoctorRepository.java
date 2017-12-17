package com.condigence.medicare.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.condigence.medicare.model.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {
	
	public Doctor findOne(Long id);
	
	public List<Doctor> findByName(String name);
	
	public List<Doctor> findByContactNo(Long number);

}
