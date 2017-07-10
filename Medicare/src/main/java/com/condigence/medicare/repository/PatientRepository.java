package com.condigence.medicare.repository;

import org.springframework.data.repository.CrudRepository;

import com.condigence.medicare.model.Patient;

public interface PatientRepository extends CrudRepository<Patient, Integer>{

}
