package com.condigence.medicare.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.condigence.medicare.model.Doctor;
import com.condigence.medicare.repository.DoctorRepository;
import com.condigence.medicare.util.CustomErrorType;

@RestController
@CrossOrigin(origins = { "*" }, maxAge = 4800, allowCredentials = "false")
public class DoctorController {

	public static final Logger logger = LoggerFactory.getLogger(DoctorController.class);

	@Autowired
	DoctorRepository doctorRepository;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping(value = "/doctors")
	public ResponseEntity<?> createDoctor(@RequestBody Doctor doctor, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Doctor : {}", doctor);
		doctorRepository.save(doctor);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/add/{id}").buildAndExpand(doctor.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping(value = "doctors/{id}")
	public ResponseEntity<?> getDoctor(@PathVariable("id") int id) {
		logger.info("Fetching Doctor with id {}", id);
		Doctor doctor = doctorRepository.findOne(id);
		if (doctor == null) {
			logger.error("Doctor with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Doctor with id " + id + " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PutMapping(value = "doctors/{id}")
	public ResponseEntity<?> updateDoctor(@PathVariable("id") int id, @RequestBody Doctor doctor) {
		logger.info("Updating Doctor with id {}", id);
		doctorRepository.save(doctor);
		return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping(value = "doctors/{id}")
	public ResponseEntity<?> deleteDoctor(@PathVariable("id") int id) {
		logger.info("Fetching & Deleting Doctor with id {}", id);

		Doctor doctor = doctorRepository.findOne(id);
		if (doctor == null) {
			logger.error("Unable to delete. Doctor with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to delete. Doctor with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		doctorRepository.delete(id);
		return new ResponseEntity<Doctor>(HttpStatus.NO_CONTENT);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping(value = "/doctors")
	public ResponseEntity<List<Doctor>> listAllAppointments() {
		List<Doctor> doctorList = (ArrayList<Doctor>) doctorRepository.findAll();
		if (doctorList.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Doctor>>(doctorList, HttpStatus.OK);
	}

	@DeleteMapping(value = "/doctors")
	public ResponseEntity<Doctor> deleteAllDoctors() {
		logger.info("Deleting All Appointments");
		doctorRepository.deleteAll();
		return new ResponseEntity<Doctor>(HttpStatus.NO_CONTENT);
	}
}
