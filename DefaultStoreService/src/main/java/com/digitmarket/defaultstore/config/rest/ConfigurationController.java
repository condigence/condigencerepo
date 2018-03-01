package com.digitmarket.defaultstore.config.rest;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digitmarket.defaultstore.common.util.CustomErrorType;
import com.digitmarket.defaultstore.config.bean.StoreConfigBean;
import com.digitmarket.defaultstore.config.dto.StoreConfigDTO;
import com.digitmarket.defaultstore.config.model.StoreConfiguration;
import com.digitmarket.defaultstore.config.repository.StoreConfigRepository;
import com.digitmarket.defaultstore.config.services.StoreConfigService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 * @category The ConfigurationController class is the main application configuration entry point
 *           API. It is expected that all configuration activity takes place through
 *           this class only.
 *
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@Api(value = "configure", description = "Rest API for configuration related operations", tags = "Config API")
public class ConfigurationController {

	public static final Logger logger = LoggerFactory.getLogger(ConfigurationController.class);
	
	@Autowired
	StoreConfigService storeConfigService;
	
	@Autowired
	StoreConfigRepository storeConfigRepository;
	
	Timestamp currentTimestamp = new Timestamp(Calendar.getInstance().getTime().getTime());
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value = "/configure")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 404, message = "The resource not found") })
	public ResponseEntity<List<StoreConfigDTO>> getStoreConfig() {
		List<StoreConfigDTO> storeConfigDTO = (ArrayList<StoreConfigDTO>) storeConfigService.findAll();
		if (storeConfigDTO.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<StoreConfigDTO>>(storeConfigDTO, HttpStatus.OK);
	}
	
	@PostMapping(value = "/configure")
	public ResponseEntity<?> saveConfigDetails(@RequestBody StoreConfigBean storeConfigBean) {			
		StoreConfigDTO storeConfigDTO = storeConfigService.saveConfigDetails(storeConfigBean);
		return new ResponseEntity<StoreConfigDTO>(storeConfigDTO, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping(value = "/configure/{id}")
	public ResponseEntity<?> deleteStoreConfigDetails(@PathVariable("id") UUID id) {
		logger.info("Fetching & Deleting Store Configuration Details with id {}", id);

		StoreConfiguration storeConfigDetail = storeConfigRepository.findOne(id);
		if (storeConfigDetail == null) {
			logger.error("Unable to delete", id);
			return new ResponseEntity(
					new CustomErrorType("Unable to delete"),
					HttpStatus.NOT_FOUND);
		}		
		storeConfigService.deleteStoreConfigDetail(id);
		
		List<StoreConfiguration> storeConfigDetails = (ArrayList<StoreConfiguration>) storeConfigRepository.findAll();
		return new ResponseEntity<List<StoreConfiguration>>(storeConfigDetails, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/configure/", method = RequestMethod.DELETE)
	public ResponseEntity<StoreConfiguration> deleteAllStoreConfigDetails() {
		logger.info("Deleting All Store Configuration Details");
		storeConfigRepository.deleteAll();
		return new ResponseEntity<StoreConfiguration>(HttpStatus.NO_CONTENT);
	}
	
	
}
