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

import com.condigence.medicare.model.Condyn;
import com.condigence.medicare.repository.CondynRepository;

@RestController
@RequestMapping("/condyn")
public class CondynController {

	public static final Logger logger = LoggerFactory.getLogger(CondynController.class);

	@Autowired
	CondynRepository condynRepository;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Condyn>> listAllCondyns() {
		List<Condyn> Condyns = (ArrayList<Condyn>) condynRepository.findAll();
		if (Condyns.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Condyn>>(Condyns, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getCondyn(@PathVariable("id") int id) {
		logger.info("Fetching with id {}", id);
		Condyn Condyn = condynRepository.findOne(id);

		return new ResponseEntity<Condyn>(Condyn, HttpStatus.OK);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<List<Condyn>> createCondyn(@RequestBody Condyn Condyn, UriComponentsBuilder ucBuilder) {
		logger.info("Creating : {}", Condyn);
		condynRepository.save(Condyn);
		List<Condyn> Condyns = (ArrayList<Condyn>) condynRepository.findAll();
		return new ResponseEntity<List<Condyn>>(Condyns, HttpStatus.OK);
	}

	//
	// // ------------------- Update a Service Type
	// // ------------------------------------------------
	//
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<List<Condyn>> updateCondyn(@RequestBody Condyn condyn) {
		logger.info("Updating  with id {}", condyn.getId());
		Condyn condynNew = condynRepository.findOne(condyn.getId());

		condynNew.setName(condyn.getName());
		condynNew.setAge(condyn.getAge());
		condynRepository.save(condynNew);
		List<Condyn> Condyns = (ArrayList<Condyn>) condynRepository.findAll();
		return new ResponseEntity<List<Condyn>>(Condyns, HttpStatus.OK);
	}

	// // ------------------- Delete a Service Type -------------------------
	/**
	 * This method will delete  by it's id value.
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<List<Condyn>> deleteCondyn(@PathVariable("id") int id) {
		logger.info("Fetching & Deleting  with id {}", id);

		Condyn Condyn = condynRepository.findOne(id);
		condynRepository.delete(Condyn.getId());			
		List<Condyn> newcondyns = (ArrayList<Condyn>) condynRepository.findAll();
		return new ResponseEntity<List<Condyn>>(newcondyns, HttpStatus.OK);
	}

	// // ------------------- Delete All Condyns Type -----------------

	@RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
	public ResponseEntity<List<Condyn>> deleteAllCondyn() {
		logger.info("Deleting All ");
		condynRepository.deleteAll();
		List<Condyn> Condyns = (ArrayList<Condyn>) condynRepository.findAll();
		if (Condyns.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Condyn>>(Condyns, HttpStatus.OK);
	}

}
