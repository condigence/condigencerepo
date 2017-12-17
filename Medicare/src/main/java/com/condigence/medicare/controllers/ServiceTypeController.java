package com.condigence.medicare.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import com.condigence.medicare.model.ServiceType;
import com.condigence.medicare.repository.ServiceTypeRepository;
import com.condigence.medicare.util.CustomErrorType;

@RestController
@CrossOrigin(origins = { "*" }, maxAge = 4800, allowCredentials = "false")
public class ServiceTypeController {

	public static final Logger logger = LoggerFactory.getLogger(ServiceTypeController.class);

	@Autowired
	ServiceTypeRepository serviceTypeRepository;

	/**
	 * @return
	 */
	@GetMapping(value = "/services")
	public ResponseEntity<List<ServiceType>> listAllServiceTypes() {
		List<ServiceType> serviceTypes = (ArrayList<ServiceType>) serviceTypeRepository.findAll();
		if (serviceTypes.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ServiceType>>(serviceTypes, HttpStatus.OK);
	}

	@GetMapping(value = "services/{id}")
	public ResponseEntity<?> getServiceType(@PathVariable("id") Long id) {
		//logger.info("Fetching Service Type with id {}", id);
		ServiceType servicetype = serviceTypeRepository.findOne(id);
		if (servicetype == null) {
		//	logger.error("Service Type with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("ServiceType with id " + id + " not found"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ServiceType>(servicetype, HttpStatus.OK);
	}

	@PostMapping(value = "/services")
	public ResponseEntity<List<ServiceType>> createServiceType(@RequestBody ServiceType servicetype,
			UriComponentsBuilder ucBuilder) {
		//logger.info("Creating Service Type : {}", servicetype);
		//ServiceType service = serviceTypeRepository.findByName(servicetype.getName());
//		if(null == service) {
//			
//		}
		
		serviceTypeRepository.save(servicetype);
		List<ServiceType> serviceTypes = (ArrayList<ServiceType>) serviceTypeRepository.findAll();
		return new ResponseEntity<List<ServiceType>>(serviceTypes, HttpStatus.IM_USED);
	}

	//
	// // ------------------- Update a Service Type
	// // ------------------------------------------------
	//
	@PutMapping(value = "services/{id}")
	public ResponseEntity<List<ServiceType>> updateServiceType(@PathVariable("id") Long id,
			@RequestBody ServiceType serviceType) {
		//logger.info("Updating Service Type with id {}", id);
		ServiceType serviceTypeNew = serviceTypeRepository.findOne(id);

		serviceTypeNew.setName(serviceType.getName());
		serviceTypeNew.setPrice(serviceType.getPrice());
		serviceTypeRepository.save(serviceTypeNew);
		List<ServiceType> serviceTypes = (ArrayList<ServiceType>) serviceTypeRepository.findAll();
		return new ResponseEntity<List<ServiceType>>(serviceTypes, HttpStatus.OK);
	}

	// // ------------------- Delete a Service Type -------------------------
	/**
	 * This method will delete service type by it's id value.
	 */
	@DeleteMapping(value = "services/{id}")
	public ResponseEntity<List<ServiceType>> deleteServiceType(@PathVariable("id") Long id) {
		//logger.info("Fetching & Deleting Service Type with id {}", id);

		ServiceType serviceType = serviceTypeRepository.findOne(id);
		serviceType.setDeleted(true);
		serviceTypeRepository.save(serviceType);
		// serviceTypeRepository.delete(serviceType.getId());

		List<ServiceType> serviceTypes = (ArrayList<ServiceType>) serviceTypeRepository.findAll();
		if (serviceTypes.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ServiceType>>(serviceTypes, HttpStatus.OK);
	}

	// // ------------------- Delete All ServiceTypes Type -----------------

	@DeleteMapping(value = "/services")
	public ResponseEntity<List<ServiceType>> deleteAllServiceType() {
		//logger.info("Deleting All ServiceTypes");
		serviceTypeRepository.deleteAll();
		List<ServiceType> serviceTypes = (ArrayList<ServiceType>) serviceTypeRepository.findAll();
		if (serviceTypes.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ServiceType>>(serviceTypes, HttpStatus.OK);
	}

}
