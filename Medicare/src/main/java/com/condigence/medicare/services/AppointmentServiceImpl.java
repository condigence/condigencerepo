package com.condigence.medicare.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.condigence.medicare.dto.AppointmentDTO;
import com.condigence.medicare.model.Appointment;
import com.condigence.medicare.model.Patient;
import com.condigence.medicare.repository.AppointmentRepository;
import com.condigence.medicare.repository.PatientRepository;

@Service("appointmentService")
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	AppointmentRepository appointmentRepository;

	@Autowired
	PatientRepository patientRepository;

	@Override
	public List<AppointmentDTO> findAppointments() {
		List<Appointment> appointmentList = (ArrayList<Appointment>) appointmentRepository.findAll();
		List<Patient> patientList = (ArrayList<Patient>) patientRepository.findAll();
		List<AppointmentDTO> appointmentDTOs = new ArrayList<>();

		for (Appointment appointment : appointmentList) {
			AppointmentDTO appointmentDTO = new AppointmentDTO();
			appointmentDTO.setAppointmentId(appointment.getId());
			appointmentDTO.setReferredByDoctorId(appointment.getReferredByDoctorId());
			appointmentDTO.setServiceTypeId(appointment.getServiceTypeId());
			appointmentDTO.setDateTime(appointment.getDateTime());
			appointmentDTO.setSlot(appointment.getSlot());
			appointmentDTO.setStatus(appointment.getStatus());
			appointmentDTO.setToken(appointment.getToken());
			appointmentDTO.setCancled(appointment.isCancled());
			appointmentDTO.setCreatedByUserId(appointment.getCreatedByUserId());
			appointmentDTO.setDeleted(appointment.isDeleted());
			appointmentDTO.setModified(appointment.isModified());
			appointmentDTO.setModifiedDateTime(appointment.getModifiedDateTime());

			for (Patient patient : patientList) {
				if (appointment.getPatientId() == patient.getId()) {
					appointmentDTO.setPatientId(patient.getId());
					appointmentDTO.setFirstName(patient.getFirstName());
					appointmentDTO.setLastName(patient.getLastName());
					appointmentDTO.setAge(patient.getAge());
					appointmentDTO.setGender(patient.getGender().charAt(0));
					appointmentDTO.setContactNo(patient.getContactNo());
					appointmentDTO.setEmail(patient.getEmail());
					appointmentDTO.setAddress(patient.getAddress());
				}
			}
			appointmentDTOs.add(appointmentDTO);
		}
		return appointmentDTOs;
	}

	@Override
	public void save(AppointmentDTO appointmentDto) {
		Appointment appointment = new Appointment();
		Patient patient = new Patient();
		appointment.setCancled(appointmentDto.isCancled());
		appointment.setCreatedByUserId(appointmentDto.getCreatedByUserId());
		appointment.setDateTime(appointmentDto.getDateTime());
		appointment.setDeleted(appointmentDto.isDeleted());
		appointment.setModified(appointmentDto.isModified());
		appointment.setModifiedDateTime(appointmentDto.getModifiedDateTime());
		appointment.setReferredByDoctorId(appointmentDto.getReferredByDoctorId());
		appointment.setServiceTypeId(appointmentDto.getServiceTypeId());
		appointment.setSlot(appointmentDto.getSlot());
		appointment.setStatus(appointmentDto.getStatus());
		appointment.setToken(appointmentDto.getToken());
		appointmentRepository.save(appointment);

		patient.setAddress(appointmentDto.getAddress());
		patient.setAge(appointmentDto.getAge());
		patient.setContactNo(appointmentDto.getContactNo());
		patient.setEmail(appointmentDto.getEmail());
		patient.setFirstName(appointmentDto.getFirstName());
		patient.setGender(appointmentDto.getGender().toString());
		patient.setId(appointmentDto.getPatientId());
		patient.setLastName(appointmentDto.getLastName());

		patientRepository.save(patient);
	}

}
