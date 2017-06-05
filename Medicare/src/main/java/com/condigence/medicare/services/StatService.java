package com.condigence.medicare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.condigence.medicare.dto.Dashboard;
import com.condigence.medicare.repository.AppointmentRepository;
import com.condigence.medicare.repository.DoctorRepository;
import com.condigence.medicare.repository.PatientRepository;
import com.condigence.medicare.repository.ProfileRepository;
import com.condigence.medicare.repository.ServiceTypeRepository;
import com.condigence.medicare.repository.UserRepository;
import com.condigence.medicare.repository.UserTypeRepository;

@Service
public class StatService {


	@Autowired
	AppointmentRepository appointmentRepository;

	@Autowired
	DoctorRepository doctorRepository;

	@Autowired
	PatientRepository patientRepository;

	@Autowired
	ProfileRepository profileRepository;

	@Autowired
	ServiceTypeRepository serviceTypeRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserTypeRepository userTypeRepository;

	public Dashboard getStats() {

		Dashboard dashboard = new Dashboard();		
		
		long appointmentcount = appointmentRepository.count();
		dashboard.setTotalAppointments(String.valueOf(appointmentcount));
		
		long doctorcount = doctorRepository.count();
		dashboard.setTotalDoctors(String.valueOf(doctorcount));
		
		long patientcount = patientRepository.count();
		dashboard.setTotalPatients((String.valueOf(patientcount)));
		
		long usercount = userRepository.count();
		dashboard.setTotalUsers(String.valueOf(usercount));
		
		long serviceTypecount = serviceTypeRepository.count();
		dashboard.setTotalServices((String.valueOf(serviceTypecount)));
		
		return dashboard;

	}

}
