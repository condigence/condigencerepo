package com.condigence.medicare.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.condigence.medicare.model.Appointment;
import com.condigence.medicare.model.User;
import com.condigence.medicare.repository.AppointmentRepository;
import com.condigence.medicare.repository.UserRepository;

@RestController
@RequestMapping("/search")
public class SearchController {

	public static final Logger logger = LoggerFactory.getLogger(SearchController.class);

	@Autowired
	AppointmentRepository appointmentRepository;

	@Autowired
	UserRepository userRepository;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/{entity}/by/{attribute}/{string}", method = RequestMethod.GET)
	public ResponseEntity<List<?>> listAllAppointments(@PathVariable("entity") String entity,
			@PathVariable("attribute") String attribute, @PathVariable("string") String string) {

		// entity = "appointment";
		// attribute = "contactNo";
		// string = "9742086574";
		// http://localhost:9900/search/appointment/by/contactNo/9742083546

		List<?> objList = null;

		if (entity.equalsIgnoreCase("appointment")) {
			objList = new ArrayList<>();
			if (attribute.equalsIgnoreCase("name")) {
				objList = (ArrayList<Appointment>) appointmentRepository.findByName(string);
				if (objList.isEmpty()) {
					return new ResponseEntity(HttpStatus.NO_CONTENT);
				}
			} else if (attribute.equalsIgnoreCase("contactNo")) {
				objList = (ArrayList<Appointment>) appointmentRepository.findByContactNo(Long.parseLong(string));
				if (objList.isEmpty()) {
					return new ResponseEntity(HttpStatus.NO_CONTENT);
				}
			}
			return new ResponseEntity<List<?>>(objList, HttpStatus.OK);

		}

		if (entity.equalsIgnoreCase("user")) {
			objList = new ArrayList<>();
			if (attribute.equalsIgnoreCase("userName")) {

				objList = (ArrayList<User>) userRepository.findByName(string);

				if (objList.isEmpty()) {
					return new ResponseEntity(HttpStatus.NO_CONTENT);
				}
			} else if (attribute.equalsIgnoreCase("lastName")) {
				objList = (ArrayList<User>) userRepository.findByLastName(string);
				if (objList.isEmpty()) {
					return new ResponseEntity(HttpStatus.NO_CONTENT);
				}
			}
			return new ResponseEntity<List<?>>(objList, HttpStatus.OK);

		} else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

	}

}
