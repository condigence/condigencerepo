package com.condigence.medicare.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.condigence.medicare.dto.UserDTO;
import com.condigence.medicare.model.Role;
import com.condigence.medicare.model.User;
import com.condigence.medicare.repository.RoleRepository;
import com.condigence.medicare.repository.UserRepository;
import com.condigence.medicare.util.CustomErrorType;

@RestController
@RequestMapping("/user")
public class UserController {

	public static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	RoleRepository roleRepository;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody UserDTO userdto, UriComponentsBuilder ucBuilder) {
		logger.info("Creating User : {}", userdto);

		if (StringUtils.isEmpty(userdto.getEmail()) && userRepository.findByEmail(userdto.getEmail()) != null) {
			logger.error("Unable to Appoinment. A appointment with name {} already	 exist", userdto.getName());
			return new ResponseEntity(
					new CustomErrorType(
							"Unable to create. A Appointment with name " + userdto.getName() + " already exist."),
					HttpStatus.CONFLICT);
		}

		User user = new User();
		user.setName(userdto.getName());
		user.setLastName(userdto.getLastName());
		user.setPassword(passwordEncoder.encode(userdto.getPassword()));
		user.setEmail(userdto.getEmail());
		user.setActive(true);

		Set<Role> roles = new HashSet<Role>();
		Role role = roleRepository.findByRole("ADMIN");
		roles.add(role);

		user.setRoles(roles);

		userRepository.save(user);

		// HttpHeaders headers = new HttpHeaders();
		// headers.setLocation(ucBuilder.path("/api/addAppointment/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<String>("User created", HttpStatus.CREATED);
	}

	//
	// @SuppressWarnings({ "rawtypes", "unchecked" })
	// @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	// public ResponseEntity<?> getUser(@PathVariable("id") int id) {
	// logger.info("Fetching Appointment with id {}", id);
	// User user = userRepository.findOne(id);
	// if (user == null) {
	// logger.error("User Type with id {} not found.", id);
	// return new ResponseEntity(new CustomErrorType("Appointment with id " + id
	// + " not found"),
	// HttpStatus.NOT_FOUND);
	// }
	// return new ResponseEntity<User>(user, HttpStatus.OK);
	// }
	//
	//
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateAppointment(@PathVariable("id") long id, @RequestBody UserDTO userdto) {
		logger.info("Updating User Type with id {}", id);

		User user = userRepository.findOne(id);

		if (user == null) {
			logger.error("Unable to update. User with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate.Appointment with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		user.setName(userdto.getName());

		userRepository.save(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting User Type with id {}", id);

		User user = userRepository.findOne(id);
		if (user == null) {
			logger.error("Unable to delete. User Type with id {} not found.", id);
			return new ResponseEntity(
					new CustomErrorType("Unable to delete. User	 Type with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		userRepository.delete(id);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers() {
		List<User> userList = (ArrayList<User>) userRepository.findAll();
		if (userList.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteAllUsers() {
		logger.info("Deleting All Users");
		userRepository.deleteAll();
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}

}
