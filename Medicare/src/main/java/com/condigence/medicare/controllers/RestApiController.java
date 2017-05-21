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

import com.condigence.medicare.model.UserType;
import com.condigence.medicare.repository.UserTypeRepository;
import com.condigence.medicare.util.CustomErrorType;

@RestController
@RequestMapping("/api")
public class RestApiController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	UserTypeRepository userTypeRepository; // which will do all data
											// retrieval/manipulation work

	// -------------------Retrieve All
	// UserType---------------------------------------------

	@RequestMapping(value = "/usertype/", method = RequestMethod.GET)
	public ResponseEntity<List<UserType>> listAllUserTypes() {
		List<UserType> usertypes = (ArrayList<UserType>) userTypeRepository.findAll();
		if (usertypes.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<UserType>>(usertypes, HttpStatus.OK);
	}

	// // -------------------Retrieve Single
	// // User------------------------------------------

	@RequestMapping(value = "/usertype/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getUserType(@PathVariable("id") int id) {
		logger.info("Fetching User Type with id {}", id);
		UserType usertype = userTypeRepository.findOne(id);
		if (usertype == null) {
			logger.error("User Type with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("UserType with id " + id + " not found"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UserType>(usertype, HttpStatus.OK);
	}

	// // -------------------Create a
	// // User-------------------------------------------

	@RequestMapping(value = "/usertype/", method = RequestMethod.POST)
	public ResponseEntity<?> createUserType(@RequestBody UserType usertype, UriComponentsBuilder ucBuilder) {
		logger.info("Creating User Type : {}", usertype);

		if (userTypeRepository.exists(usertype.getId())) {
			logger.error("Unable to create. A User Type with name {} already exist", usertype.getType());
			return new ResponseEntity(
					new CustomErrorType(
							"Unable to create. A User Type with name " + usertype.getType() + " already exist."),
					HttpStatus.CONFLICT);
		}
		userTypeRepository.save(usertype);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(usertype.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	//
	// // ------------------- Update a User
	// // ------------------------------------------------
	//
	@RequestMapping(value = "/usertype/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUserType(@PathVariable("id") int id, @RequestBody UserType usertype) {
		logger.info("Updating User Type with id {}", id);

		UserType newUserType = userTypeRepository.findOne(id);

		if (newUserType == null) {
			logger.error("Unable to update. User Type with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate. User Type with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		newUserType.setType(usertype.getType());

		userTypeRepository.save(newUserType);
		return new ResponseEntity<UserType>(newUserType, HttpStatus.OK);
	}

	// // ------------------- Delete a User Type -------------------------

	@RequestMapping(value = "/usertype/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUserType(@PathVariable("id") int id) {
		logger.info("Fetching & Deleting User Type with id {}", id);

		UserType userType = userTypeRepository.findOne(id);
		if (userType == null) {
			logger.error("Unable to delete. User Type with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to delete. User Type with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		userTypeRepository.delete(id);
		return new ResponseEntity<UserType>(HttpStatus.NO_CONTENT);
	}

	// // ------------------- Delete All Users Type -----------------

	@RequestMapping(value = "/usertype/", method = RequestMethod.DELETE)
	public ResponseEntity<UserType> deleteAllUserType() {
		logger.info("Deleting All UserTypes");
		userTypeRepository.deleteAll();
		return new ResponseEntity<UserType>(HttpStatus.NO_CONTENT);
	}

}