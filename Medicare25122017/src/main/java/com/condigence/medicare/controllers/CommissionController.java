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

import com.condigence.medicare.dto.CommissionDTO;
import com.condigence.medicare.model.Commission;
import com.condigence.medicare.repository.CommissionRepository;
import com.condigence.medicare.services.CommissionService;
import com.condigence.medicare.util.CustomErrorType;

@RestController
public class CommissionController {

	public static final Logger logger = LoggerFactory.getLogger(DoctorController.class);

	@Autowired
	CommissionRepository commissionRepository;

	@Autowired
	CommissionService commissionService;

	@PostMapping(value = "/commissions")
	public ResponseEntity<?> createCommission(@RequestBody Commission commission, UriComponentsBuilder ucBuilder) {
		logger.info("Creating commission : {}", commission);
		commissionRepository.save(commission);
		HttpHeaders headers = new HttpHeaders();
		// headers.setLocation(ucBuilder.path("/api/addAppointment/{id}").buildAndExpand(patient.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping(value = "/commissions/{id}")
	public ResponseEntity<?> getCommission(@PathVariable("id") Long id) {
		logger.info("Fetching Patient with id {}", id);
		Commission commission = commissionRepository.findOne(id);
		if (commission == null) {
			logger.error("Commission with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Commission with id " + id + " not found"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Commission>(commission, HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PutMapping(value = "/commissions/{id}")
	public ResponseEntity<?> updateCommission(@PathVariable("id") Long id, @RequestBody Commission commission1) {
		logger.info("Updating commission with id {}", id);

		Commission commission = commissionRepository.findOne(id);

		if (commission1 == null) {
			logger.error("Unable to update. Commission with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate. Commission with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		commissionRepository.save(commission);
		return new ResponseEntity<Commission>(commission, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping(value = "/commissions/{id}")
	public ResponseEntity<?> deletePatient(@PathVariable("id") Long id) {
		logger.info("Fetching & Deleting commission with id {}", id);

		Commission commission = commissionRepository.findOne(id);
		if (commission == null) {
			logger.error("Unable to delete. commission with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to delete.commission with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		commissionRepository.delete(id);
		return new ResponseEntity<Commission>(HttpStatus.NO_CONTENT);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping(value = "/commissions")
	public ResponseEntity<List<CommissionDTO>> listAllCommissions() {
		List<CommissionDTO> patientList = (ArrayList<CommissionDTO>) commissionService.findAll();
		if (patientList.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<CommissionDTO>>(patientList, HttpStatus.OK);
	}

	@DeleteMapping(value = "/commissions")
	public ResponseEntity<Commission> deleteAllCommission() {
		logger.info("Deleting All Commissions");
		commissionRepository.deleteAll();
		return new ResponseEntity<Commission>(HttpStatus.NO_CONTENT);
	}

}
