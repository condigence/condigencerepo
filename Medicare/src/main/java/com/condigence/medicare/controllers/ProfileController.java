package com.condigence.medicare.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.condigence.medicare.model.Profile;
import com.condigence.medicare.repository.ProfileRepository;
import com.condigence.medicare.util.CustomErrorType;

@RestController
@RequestMapping("/profile")
public class ProfileController {

	public static final Logger logger = LoggerFactory.getLogger(ProfileController.class);
	
	@Autowired
	ProfileRepository profileRepository;
	
	// List all Profile---------------------------------------------

		@RequestMapping(value = "/all", method = RequestMethod.GET)
		public ResponseEntity<List<Profile>> listAllProfiles() {
			List<Profile> profiles = (ArrayList<Profile>) profileRepository.findAll();
			if (profiles.isEmpty()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);			
			}
			return new ResponseEntity<List<Profile>>(profiles, HttpStatus.OK);
		}

		// Retrieve Single Profile entity--------
		
		@RequestMapping(value = "/{id}", method = RequestMethod.GET)
		public ResponseEntity<?> getProfile(@PathVariable("id") int id) {
			logger.info("Fetching Profile Type with id {}", id);
			Profile profile = profileRepository.findOne(id);
			if (profile == null) {
				logger.error("Profile Type with id {} not found.", id);
				return new ResponseEntity(new CustomErrorType("Profile with id " + id + " not found"),
						HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Profile>(profile, HttpStatus.OK);
		}

		// Add or Create Profile  -------
		
		@RequestMapping(value = "/add", method = RequestMethod.POST)
		public ResponseEntity<?> createProfile(@RequestBody Profile profile, UriComponentsBuilder ucBuilder) {
			logger.info("Creating Profile Type : {}", profile);

/*			if (profileRepository.exists(profile.getId())) {
				logger.error("Unable to create. A Profile Type with name {} already exist", profile.getFirstName());
				return new ResponseEntity(
						new CustomErrorType(
								"Unable to create. A Profile Type with name " + profile.getFirstName() + " already exist."),
						HttpStatus.CONFLICT);
			}*/
			profileRepository.save(profile);

			//HttpHeaders headers = new HttpHeaders();
			//headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(profile.getId()).toUri());
			return new ResponseEntity<String>(HttpStatus.CREATED);
		}

		
		//  ------------------- Update a Profile Type

		@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
		public ResponseEntity<?> updateProfile(@PathVariable("id") int id, @RequestBody Profile profile) {
			logger.info("Updating Profile Type with id {}", id);

			Profile profileNew = profileRepository.findOne(id);

			if (profileNew == null) {
				logger.error("Unable to update. Profile Type with id {} not found.", id);
				return new ResponseEntity(new CustomErrorType("Unable to upate. Profile Type with id " + id + " not found."),
						HttpStatus.NOT_FOUND);
			}

			profileNew.setFirstName(profile.getFirstName());
			profileNew.setLastName(profile.getLastName());
			profileNew.setAddress(profile.getAddress());
			profileNew.setContact(profile.getContact());
			profile.setGender(profile.getGender());
			profileNew.setUserId(profile.getUserId());
			

			profileRepository.save(profileNew);
			return new ResponseEntity<Profile>(profileNew, HttpStatus.OK);
		}

		// // ------------------- Delete a Profile Type -------------------------

		@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<?> deleteProfile(@PathVariable("id") int id) {
			logger.info("Fetching & Deleting Profile Type with id {}", id);

			Profile profile = profileRepository.findOne(id);
			if (profile == null) {
				logger.error("Unable to delete. Profile Type with id {} not found.", id);
				return new ResponseEntity(new CustomErrorType("Unable to delete. Profile Type with id " + id + " not found."),
						HttpStatus.NOT_FOUND);
			}
			profileRepository.delete(id);
			return new ResponseEntity<Profile>(HttpStatus.NO_CONTENT);
		}

		// // ------------------- Delete All Profile Type -----------------

		@RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
		public ResponseEntity<Profile> deleteAllProfile() {
			logger.info("Deleting All Profile");
			profileRepository.deleteAll();
			return new ResponseEntity<Profile>(HttpStatus.NO_CONTENT);
		}

	
}
