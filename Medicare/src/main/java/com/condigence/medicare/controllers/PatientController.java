package com.condigence.medicare.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.condigence.medicare.model.Patient;
import com.condigence.medicare.repository.PatientRepository;
import com.condigence.medicare.util.CustomErrorType;

@RestController
public class PatientController {

	public static final Logger logger = LoggerFactory.getLogger(DoctorController.class);

	@Autowired
	PatientRepository patientRepository;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping(value = "/patients")
	public ResponseEntity<?> createPatient(@RequestBody Patient patient, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Patient : {}", patient);

		if (patientRepository.exists(patient.getId())) {
			logger.error("Unable to patient. A patient with name {} already exist", patient.getFirstName());
			return new ResponseEntity(
					new CustomErrorType(
							"Unable to create. A Patient with name " + patient.getFirstName() + " already exist."),
					HttpStatus.CONFLICT);
		}
		patientRepository.save(patient);

		HttpHeaders headers = new HttpHeaders();
		// headers.setLocation(ucBuilder.path("/api/addAppointment/{id}").buildAndExpand(patient.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping(value = "/patients/{id}")
	public ResponseEntity<?> getPatient(@PathVariable("id") Long id) {
		logger.info("Fetching Patient with id {}", id);
		Patient patient = patientRepository.findOne(id);
		if (patient == null) {
			logger.error("User Type with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Patient with id " + id + " not found"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Patient>(patient, HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PutMapping(value = "/patients/{id}")
	public ResponseEntity<?> updatePatient(@PathVariable("id") Long id, @RequestBody Patient patient1) {
		logger.info("Updating Patient with id {}", id);

		Patient patient = patientRepository.findOne(id);

		if (patient1 == null) {
			logger.error("Unable to update. Patient with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate. Patient with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		patient.setContactNo(patient1.getContactNo());
		patient.setAddress(patient1.getAddress());
		patient.setAge(patient1.getAge());
		patient.setEmail(patient1.getEmail());
		patient.setFirstName(patient1.getFirstName());
	//	patient.setGender(patient1.getGender());

		patientRepository.save(patient);
		return new ResponseEntity<Patient>(patient, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping(value = "/patients/{id}")
	public ResponseEntity<?> deletePatient(@PathVariable("id") Long id) {
		logger.info("Fetching & Deleting Patient with id {}", id);

		Patient patient = patientRepository.findOne(id);
		if (patient == null) {
			logger.error("Unable to delete. patient with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to delete.patient with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		//patientRepository.delete(id);
		
		patient.setDeleted(true);
		patientRepository.save(patient);
		
		
		return new ResponseEntity<Patient>(HttpStatus.NO_CONTENT);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping(value = "/patients")
	public ResponseEntity<List<Patient>> listAllPatients() {
		List<Patient> patientList = (ArrayList<Patient>) patientRepository.findAllByOrderByIdDesc();
		if (patientList.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Patient>>(patientList, HttpStatus.OK);
	}

	@DeleteMapping(value = "/patients")
	public ResponseEntity<Patient> deleteAllPatient() {
		logger.info("Deleting All Appointments");
		patientRepository.deleteAll();
		return new ResponseEntity<Patient>(HttpStatus.NO_CONTENT);
	}

}
