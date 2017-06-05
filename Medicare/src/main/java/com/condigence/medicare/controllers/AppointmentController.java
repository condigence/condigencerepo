package com.condigence.medicare.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.condigence.medicare.model.Appointment;
import com.condigence.medicare.repository.AppointmentRepository;
import com.condigence.medicare.util.CustomErrorType;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

	public static final Logger logger = LoggerFactory.getLogger(AppointmentController.class);

	@Autowired
	AppointmentRepository appointmentRepository;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> createAppointment(@RequestBody Appointment appointment, UriComponentsBuilder ucBuilder) {
		logger.info("Creating User Type : {}", appointment);

		if (appointmentRepository.exists(appointment.getId())) {
			logger.error("Unable to Appoinment. A appointment with name {} already exist", appointment.getName());
			return new ResponseEntity(
					new CustomErrorType(
							"Unable to create. A Appointment with name " + appointment.getName() + " already exist."),
					HttpStatus.CONFLICT);
		}
		appointmentRepository.save(appointment);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/appointment/{id}").buildAndExpand(appointment.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getAppointment(@PathVariable("id") int id) {
		logger.info("Fetching Appointment with id {}", id);
		Appointment appointment = appointmentRepository.findOne(id);
		if (appointment == null) {
			logger.error("User Type with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Appointment with id " + id + " not found"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Appointment>(appointment, HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateAppointment(@PathVariable("id") int id, @RequestBody Appointment appointment1) {
		logger.info("Updating User Type with id {}", id);

		Appointment appointment = appointmentRepository.findOne(id);

		if (appointment1 == null) {
			logger.error("Unable to update. Appointment with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate. Appointment with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		//appointment.setContactNo(appointment1.getContactNo());

		appointmentRepository.save(appointment1);
		return new ResponseEntity<Appointment>(appointment, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteAppointment(@PathVariable("id") int id) {
		logger.info("Fetching & Deleting User Type with id {}", id);

		Appointment appointment = appointmentRepository.findOne(id);
		if (appointment == null) {
			logger.error("Unable to delete. User Type with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to delete. User Type with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		appointmentRepository.delete(id);
		return new ResponseEntity<Appointment>(HttpStatus.NO_CONTENT);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Appointment>> listAllAppointments() {
		List<Appointment> appointmentList = (ArrayList<Appointment>) appointmentRepository.findAll();
		if (appointmentList.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Appointment>>(appointmentList, HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
	public ResponseEntity<Appointment> deleteAllUserType() {
		logger.info("Deleting All UserTypes");
		appointmentRepository.deleteAll();
		return new ResponseEntity<Appointment>(HttpStatus.NO_CONTENT);
	}

}
