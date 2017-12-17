package com.condigence.medicare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.condigence.medicare.dto.Dashboard;
import com.condigence.medicare.repository.AppointmentRepository;
import com.condigence.medicare.repository.DoctorRepository;
import com.condigence.medicare.repository.PatientRepository;
import com.condigence.medicare.repository.ServiceTypeRepository;
import com.condigence.medicare.repository.UserRepository;
import com.condigence.medicare.repository.RoleRepository;

@Service
public class StatService {

	@Autowired
	AppointmentRepository appointmentRepository;

	@Autowired
	DoctorRepository doctorRepository;

	@Autowired
	PatientRepository patientRepository;

	@Autowired
	ServiceTypeRepository serviceTypeRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository userTypeRepository;

	public Dashboard getStats() {

		Dashboard dashboard = new Dashboard();

		long appointmentcount = appointmentRepository.count();
		dashboard.setTotalAppointments(appointmentcount);

		// long canceledappointmentcount =
		// appointmentRepository.findByCanceledAppointment();
		// dashboard.setCancelAppointments(canceledappointmentcount);

		long doctorcount = doctorRepository.count();
		dashboard.setTotalDoctors(doctorcount);

		long patientcount = patientRepository.count();
		dashboard.setTotalPatients(patientcount);

		long usercount = userRepository.count();
		dashboard.setTotalUsers(usercount);

		long serviceTypecount = serviceTypeRepository.count();
		dashboard.setTotalServices(serviceTypecount);

		long userTypecount = userTypeRepository.count();
		dashboard.setTotalRoles(userTypecount);

		return dashboard;

	}

}
