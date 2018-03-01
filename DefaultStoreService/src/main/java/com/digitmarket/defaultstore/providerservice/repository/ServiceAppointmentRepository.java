package com.digitmarket.defaultstore.providerservice.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.digitmarket.defaultstore.providerservice.model.ServiceAppointment;

@Repository("serviceAppointementRepository")
public interface ServiceAppointmentRepository extends CrudRepository<ServiceAppointment, UUID> {

	public List<ServiceAppointment> findAllByOrderByAppointmentIdDesc();

	public ArrayList<ServiceAppointment> findAllByOrderByServiceIdDesc(UUID id);
}
