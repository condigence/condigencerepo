package com.condigence.medicare.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.condigence.medicare.model.Appointment;
import com.condigence.medicare.model.Patient;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {	
	
	List<Appointment> findAllByOrderByIdDesc();
	
	List<Appointment> findBypatient(Patient patient);
	
	List<Appointment> findByDateTimeBetween(String startDate,String endDate );
	
}
