package com.condigence.medicare.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.condigence.medicare.model.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {

	List<Appointment> findById(String id);

	int findByCanceledAppointment();
}
