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
@RequestMapping("/search")
public class SearchController {

	public static final Logger logger = LoggerFactory.getLogger(SearchController.class);

	// @SuppressWarnings({ "rawtypes", "unchecked" })
	// @RequestMapping(value = "/{entity}/by/{attribute}/{string}", method =
	// RequestMethod.GET)
	// public ResponseEntity<List<Searchable>> listAllAppointments() {
	// List<Searchable> objList = (ArrayList<Searchable>)
	// searchRepository.findAll();
	// if (objList.isEmpty()) {
	// return new ResponseEntity(HttpStatus.NO_CONTENT);
	// // You many decide to return HttpStatus.NOT_FOUND
	// }
	// return new ResponseEntity<List<Searchable>>(objList, HttpStatus.OK);
	// }

}
