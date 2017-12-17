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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.condigence.medicare.dto.AppointmentDTO;
import com.condigence.medicare.dto.Billing;
import com.condigence.medicare.model.Appointment;
import com.condigence.medicare.model.ServiceType;
import com.condigence.medicare.repository.AppointmentRepository;
import com.condigence.medicare.services.AppointmentService;
import com.condigence.medicare.services.BillingService;
import com.condigence.medicare.util.CustomErrorType;

@RestController
public class AppointmentController {

	public static final Logger logger = LoggerFactory.getLogger(AppointmentController.class);

	@Autowired
	AppointmentRepository appointmentRepository;

	@Autowired
	AppointmentService appointmentService;

	@Autowired
	BillingService billingService;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping(value = "/appointments")
	public ResponseEntity<?> createAppointment(@RequestBody AppointmentDTO appointment,
			UriComponentsBuilder ucBuilder) {
		logger.info("Creating Appointment : {}", appointment);
		appointmentService.save(appointment);

		HttpHeaders headers = new HttpHeaders();
		// headers.setLocation(ucBuilder.path("/home"));
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping(value = "/appointments/{id}")
	public ResponseEntity<?> getAppointment(@PathVariable("id") Long id) {
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
	@PutMapping(value = "/appointments/{id}")
	public ResponseEntity<?> updateAppointment(@PathVariable("id") Long id, @RequestBody Appointment appointment1) {
		logger.info("Updating User Type with id {}", id);

		Appointment appointment = appointmentRepository.findOne(id);

		if (appointment1 == null) {
			logger.error("Unable to update. Appointment with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate. Appointment with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		appointmentRepository.save(appointment1);
		return new ResponseEntity<Appointment>(appointment, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping(value = "/appointments/{id}")
	public ResponseEntity<?> deleteAppointment(@PathVariable("id") Long id) {
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
	@GetMapping(value = "/appointments")
	public ResponseEntity<List<AppointmentDTO>> listAllAppointments() {
		List<AppointmentDTO> appointmentList = (ArrayList<AppointmentDTO>) appointmentService.findAppointments();

		if (appointmentList.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<AppointmentDTO>>(appointmentList, HttpStatus.OK);
	}

	@DeleteMapping(value = "/appointments")
	public ResponseEntity<Appointment> deleteAllUserType() {
		logger.info("Deleting All UserTypes");
		appointmentRepository.deleteAll();
		return new ResponseEntity<Appointment>(HttpStatus.NO_CONTENT);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/bill/{id}", method = RequestMethod.GET)
	public ResponseEntity<Billing> createBilling(@PathVariable("id") Long id) {

		logger.info("Fetching appointment of patient   with id {}", id);

		Appointment appointment = appointmentRepository.findOne(id);

		Billing billing = billingService.getBill(appointment);

		System.out.println(" Patient Bill No :" + billing.getBillNo());
		System.out.println(" Patient Name :" + billing.getName());
		System.out.println(" Patient Bill Date :" + billing.getDate());

		for (ServiceType s : billing.getListofServices()) {
			System.out.println(" service  Name : " + s.getName() + " Service Price : " + s.getPrice());
		}
		System.out.println(" Patient  Total Price :" + billing.getTotalPrice());

		if (billing == null) {
			logger.error("Unable to delete. User Type with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to delete. User Type with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		// appointmentRepository.delete(id);

		return new ResponseEntity<Billing>(billing, HttpStatus.OK);
	}

}
