package com.condigence.medicare.repository;

import org.springframework.data.repository.CrudRepository;

import com.condigence.medicare.model.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {

}
