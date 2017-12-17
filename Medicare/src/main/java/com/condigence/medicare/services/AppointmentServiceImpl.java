package com.condigence.medicare.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.condigence.medicare.dto.AppointmentDTO;
import com.condigence.medicare.model.Appointment;
import com.condigence.medicare.model.Commission;
import com.condigence.medicare.model.Doctor;
import com.condigence.medicare.model.Patient;
import com.condigence.medicare.model.Role;
import com.condigence.medicare.model.ServiceType;
import com.condigence.medicare.model.User;
import com.condigence.medicare.repository.AppointmentRepository;
import com.condigence.medicare.repository.CommissionRepository;
import com.condigence.medicare.repository.DoctorRepository;
import com.condigence.medicare.repository.PatientRepository;
import com.condigence.medicare.repository.ServiceTypeRepository;
import com.condigence.medicare.repository.UserRepository;

@Service("appointmentService")
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	AppointmentRepository appointmentRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	DoctorRepository doctorRepository;

	@Autowired
	ServiceTypeRepository serviceTypeRepository;

	@Autowired
	PatientRepository patientRepository;

	@Autowired
	CommissionRepository commissionRepository;

	@Override
	public List<AppointmentDTO> findAppointments() {
		List<Appointment> appointmentList = (ArrayList<Appointment>) appointmentRepository.findAll();
		List<AppointmentDTO> appointmentDTOs = new ArrayList<>();

		for (Appointment appointment : appointmentList) {
			AppointmentDTO appointmentDTO = new AppointmentDTO();
			appointmentDTO.setAppointmentId(appointment.getId());

			Doctor doctor = new Doctor();
			doctor.setId(appointment.getReferredByDoctor().getId());
			doctor.setName(appointment.getReferredByDoctor().getName());
			appointmentDTO.setReferredByDoctor(doctor);

			Set<ServiceType> set = new HashSet<>();

			for (ServiceType obj : appointment.getServices()) {
				ServiceType serviceType = new ServiceType();
				serviceType.setId(obj.getId());
				serviceType.setName(obj.getName());
				set.add(serviceType);
			}

			appointmentDTO.setServiceType(new ArrayList<>(set));

			appointmentDTO.setDateTime("2017-05-25 14:56:59");
			appointmentDTO.setSlot(appointment.getSlot());
			appointmentDTO.setStatus(appointment.getStatus());
			appointmentDTO.setToken(appointment.getToken());
			appointmentDTO.setCancled(appointment.isCancled());

			User user = new User();
			user.setId(appointment.getCreatedByUser().getId());
			user.setName(appointment.getCreatedByUser().getName());
			appointmentDTO.setCreatedByUserId(user);
			appointmentDTO.setDeleted(appointment.isDeleted());
			appointmentDTO.setModified(appointment.isModified());
			appointmentDTO.setModifiedDateTime("2017-05-25 14:56:59");
			Patient patient = new Patient();
			patient.setAddress(appointment.getPatient().getAddress());
			patient.setAge(appointment.getPatient().getAge());
			patient.setContactNo(appointment.getPatient().getContactNo());
			patient.setEmail(appointment.getPatient().getEmail());
			patient.setFirstName(appointment.getPatient().getFirstName());
			patient.setGender(appointment.getPatient().getGender().toString());
			patient.setId(appointment.getPatient().getId());
			patient.setLastName(appointment.getPatient().getLastName());
			appointmentDTO.setPatient(patient);
			appointmentDTOs.add(appointmentDTO);
		}
		return appointmentDTOs;
	}

	@Override
	public void save(AppointmentDTO appointmentDto) {
		Appointment appointment = new Appointment();

		appointment.setCancled(appointmentDto.isCancled());

		User user = userRepository.findOne(appointmentDto.getCreatedByUserId().getId());
		appointment.setCreatedByUser(user);

		Doctor doctor = doctorRepository.findOne(appointmentDto.getReferredByDoctor().getId());
		appointment.setReferredByDoctor(doctor);

		Set<ServiceType> servicesSet = new HashSet<>();
		for (String obj : appointmentDto.getServices()) {
			ServiceType serviceType = serviceTypeRepository.findOne(Long.valueOf(obj));
			servicesSet.add(serviceType);
		}
		appointment.setServices(servicesSet);

		Patient patient = new Patient();
		patient.setAddress(appointmentDto.getAddress());
		patient.setAge(appointmentDto.getAge());
		patient.setContactNo(appointmentDto.getContactNo());
		patient.setEmail(appointmentDto.getEmail());
		patient.setFirstName(appointmentDto.getFirstName());
		patient.setGender(appointmentDto.getGender().toString());
		patient.setId(appointmentDto.getAppointmentId());
		patient.setLastName(appointmentDto.getLastName());

		//appointment.setDateTime("2017-05-25 14:56:59");
		appointment.setDeleted(appointmentDto.isDeleted());
		appointment.setModified(appointmentDto.isModified());
		//appointment.setModifiedDateTime(appointmentDto.getModifiedDateTime());
		appointment.setSlot(appointmentDto.getSlot());
		appointment.setStatus(appointmentDto.getStatus());
		appointment.setToken(appointmentDto.getToken());
		appointment.setPatient(patient);

		Appointment app = appointmentRepository.save(appointment);

		Commission commission = new Commission();
		commission.setAppointmentId(app.getId());		
		float totalCommission = calculateTotalCommission(app);		
		commission.setTotalCommission((int)totalCommission);		
		commissionRepository.save(commission);

	}

	private float calculateTotalCommission(Appointment app) {
		int fixPercentOfDoc = 10;		
		int totalPrice = 0;
		for(ServiceType serviceType :app.getServices()) {
			totalPrice = (int) (totalPrice + serviceType.getPrice());
		}		
		float percent = (fixPercentOfDoc * totalPrice) /  100.0f;		
		return  percent;
	}

	@Override
	public List<AppointmentDTO> findAppointmentsByPatientName(String name) {
		List<Appointment> appointments = appointmentRepository
				.findBypatient(patientRepository.findByFirstName(name).get(0));

		List<AppointmentDTO> appointmentDTOs = new ArrayList<>();
		for (Appointment appointment : appointments) {
			AppointmentDTO appointmentDTO = new AppointmentDTO();
			appointmentDTO.setAppointmentId(appointment.getId());

			Doctor doctor = new Doctor();
			doctor.setId(appointment.getReferredByDoctor().getId());
			doctor.setName(appointment.getReferredByDoctor().getName());
			appointmentDTO.setReferredByDoctor(doctor);

			Set<ServiceType> set = new HashSet<>();

			for (ServiceType obj : appointment.getServices()) {
				ServiceType serviceType = new ServiceType();
				serviceType.setId(obj.getId());
				serviceType.setName(obj.getName());
				set.add(serviceType);
			}

			appointmentDTO.setServiceType(new ArrayList<>(set));

			appointmentDTO.setDateTime("2017-12-06 14:56:59");
			appointmentDTO.setSlot(appointment.getSlot());
			appointmentDTO.setStatus(appointment.getStatus());
			appointmentDTO.setToken(appointment.getToken());
			appointmentDTO.setCancled(appointment.isCancled());

			User user = new User();
			user.setId(appointment.getCreatedByUser().getId());
			user.setName(appointment.getCreatedByUser().getName());
			appointmentDTO.setCreatedByUserId(user);
			appointmentDTO.setDeleted(appointment.isDeleted());
			appointmentDTO.setModified(appointment.isModified());
			appointmentDTO.setModifiedDateTime("2017-12-06 14:56:59");
			Patient patient = new Patient();
			patient.setAddress(appointment.getPatient().getAddress());
			patient.setAge(appointment.getPatient().getAge());
			patient.setContactNo(appointment.getPatient().getContactNo());
			patient.setEmail(appointment.getPatient().getEmail());
			patient.setFirstName(appointment.getPatient().getFirstName());
			patient.setGender(appointment.getPatient().getGender().toString());
			patient.setId(appointment.getPatient().getId());
			patient.setLastName(appointment.getPatient().getLastName());
			appointmentDTO.setPatient(patient);
			appointmentDTOs.add(appointmentDTO);
		}

		return appointmentDTOs;
	}

	@Override
	public List<AppointmentDTO> findAppointmentsByPatientContact(String contact) {
		List<Appointment> appointments = appointmentRepository
				.findBypatient(patientRepository.findByContactNo(Long.parseLong(contact)).get(0));

		List<AppointmentDTO> appointmentDTOs = new ArrayList<>();
		for (Appointment appointment : appointments) {
			AppointmentDTO appointmentDTO = new AppointmentDTO();
			appointmentDTO.setAppointmentId(appointment.getId());

			Doctor doctor = new Doctor();
			doctor.setId(appointment.getReferredByDoctor().getId());
			doctor.setName(appointment.getReferredByDoctor().getName());
			appointmentDTO.setReferredByDoctor(doctor);

			Set<ServiceType> set = new HashSet<>();

			for (ServiceType obj : appointment.getServices()) {
				ServiceType serviceType = new ServiceType();
				serviceType.setId(obj.getId());
				serviceType.setName(obj.getName());
				set.add(serviceType);
			}

			appointmentDTO.setServiceType(new ArrayList<>(set));

			//appointmentDTO.setDateTime(appointment.getDateTime());
			appointmentDTO.setSlot(appointment.getSlot());
			appointmentDTO.setStatus(appointment.getStatus());
			appointmentDTO.setToken(appointment.getToken());
			appointmentDTO.setCancled(appointment.isCancled());

			User user = new User();
			user.setId(appointment.getCreatedByUser().getId());
			user.setName(appointment.getCreatedByUser().getName());
			appointmentDTO.setCreatedByUserId(user);
			appointmentDTO.setDeleted(appointment.isDeleted());
			appointmentDTO.setModified(appointment.isModified());
			appointmentDTO.setModifiedDateTime("2017-12-06 14:56:59");
			Patient patient = new Patient();
			patient.setAddress(appointment.getPatient().getAddress());
			patient.setAge(appointment.getPatient().getAge());
			patient.setContactNo(appointment.getPatient().getContactNo());
			patient.setEmail(appointment.getPatient().getEmail());
			patient.setFirstName(appointment.getPatient().getFirstName());
			patient.setGender(appointment.getPatient().getGender().toString());
			patient.setId(appointment.getPatient().getId());
			patient.setLastName(appointment.getPatient().getLastName());
			appointmentDTO.setPatient(patient);
			appointmentDTOs.add(appointmentDTO);
		}

		return appointmentDTOs;
	}

}
