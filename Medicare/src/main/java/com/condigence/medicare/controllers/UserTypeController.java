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

import com.condigence.medicare.model.Role;
import com.condigence.medicare.repository.RoleRepository;
import com.condigence.medicare.util.CustomErrorType;

@RestController
public class UserTypeController {

	public static final Logger logger = LoggerFactory.getLogger(UserTypeController.class);

	@Autowired
	RoleRepository userTypeRepository;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value = "/roles")
	public ResponseEntity<List<Role>> listAllUserTypes() {
		List<Role> usertypes = (ArrayList<Role>) userTypeRepository.findAll();
		if (usertypes.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Role>>(usertypes, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value = "/roles/{id}")
	public ResponseEntity<?> getUserType(@PathVariable("id") int id) {
		logger.info("Fetching User Type with id {}", id);
		Role usertype = userTypeRepository.findOne(id);
		if (usertype == null) {
			logger.error("User Type with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Role with id " + id + " not found"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Role>(usertype, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(value = "/roles")
	public ResponseEntity<?> createUserType(@RequestBody Role usertype, UriComponentsBuilder ucBuilder) {
		logger.info("Creating User Type : {}", usertype);

		if (userTypeRepository.exists(usertype.getId())) {
			logger.error("Unable to create. A User Type with name {} already exist", usertype.getRole());
			return new ResponseEntity(
					new CustomErrorType(
							"Unable to create. A User Type with name " + usertype.getRole()+ " already exist."),
					HttpStatus.CONFLICT);
		}
		userTypeRepository.save(usertype);

		//HttpHeaders headers = new HttpHeaders();
	//	headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(usertype.getId()).toUri());
		return new ResponseEntity<Role>(usertype, HttpStatus.CREATED);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PutMapping(value = "/roles/{id}")
	public ResponseEntity<?> updateUserType(@PathVariable("id") int id, @RequestBody Role usertype) {
		logger.info("Updating User Type with id {}", id);

		Role newUserType = userTypeRepository.findOne(id);

		if (newUserType == null) {
			logger.error("Unable to update. User Type with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate. User Type with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		newUserType.setRole(usertype.getRole());

		userTypeRepository.save(newUserType);
		return new ResponseEntity<Role>(newUserType, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping(value = "/roles/{id}")
	public ResponseEntity<?> deleteUserType(@PathVariable("id") int id) {
		logger.info("Fetching & Deleting User Type with id {}", id);

		Role userType = userTypeRepository.findOne(id);
		if (userType == null) {
			logger.error("Unable to delete. User Type with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to delete. User Type with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		userType.setDeleted(true);
		userTypeRepository.save(userType);
		return new ResponseEntity<Role>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping(value = "/roles")
	public ResponseEntity<Role> deleteAllUserType() {
		logger.info("Deleting All UserTypes");
		userTypeRepository.deleteAll();
		return new ResponseEntity<Role>(HttpStatus.NO_CONTENT);
	}

}