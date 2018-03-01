package com.digitmarket.defaultstore.providerservice.rest;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

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
import com.digitmarket.defaultstore.common.util.CustomErrorType;
import com.digitmarket.defaultstore.providerservice.bean.ServiceAppointmentBean;
import com.digitmarket.defaultstore.providerservice.bean.ServiceDetailsBean;
import com.digitmarket.defaultstore.providerservice.bean.ServiceProviderDetailsBean;
import com.digitmarket.defaultstore.providerservice.bean.ServiceProviderMapBean;
import com.digitmarket.defaultstore.providerservice.bean.ServiceRequestAppointmentBean;
import com.digitmarket.defaultstore.providerservice.bean.ServiceReviewCommentsBean;
import com.digitmarket.defaultstore.providerservice.dto.ServiceAppointmentDTO;
import com.digitmarket.defaultstore.providerservice.dto.ServiceDetailsDTO;
import com.digitmarket.defaultstore.providerservice.dto.ServiceProviderDetailsDTO;
import com.digitmarket.defaultstore.providerservice.dto.ServiceProviderMapDTO;
import com.digitmarket.defaultstore.providerservice.dto.ServiceRequestDTO;
import com.digitmarket.defaultstore.providerservice.dto.ServiceReviewCommentsDTO;
import com.digitmarket.defaultstore.providerservice.model.ServiceAppointment;
import com.digitmarket.defaultstore.providerservice.model.ServiceDetails;
import com.digitmarket.defaultstore.providerservice.model.ServiceProviderDetails;
import com.digitmarket.defaultstore.providerservice.model.ServiceProviderMap;
import com.digitmarket.defaultstore.providerservice.model.ServiceRequest;
import com.digitmarket.defaultstore.providerservice.model.ServiceReviewComments;
import com.digitmarket.defaultstore.providerservice.repository.ServiceAppointmentRepository;
import com.digitmarket.defaultstore.providerservice.repository.ServiceDetailsRepository;
import com.digitmarket.defaultstore.providerservice.repository.ServiceProviderDetailsRepository;
import com.digitmarket.defaultstore.providerservice.repository.ServiceProviderIdentificationRepository;
import com.digitmarket.defaultstore.providerservice.repository.ServiceProviderMapRepository;
import com.digitmarket.defaultstore.providerservice.repository.ServiceRequestRepository;
import com.digitmarket.defaultstore.providerservice.repository.ServiceReviewCommentsRepository;
import com.digitmarket.defaultstore.providerservice.services.ServiceDetailsService;

import io.swagger.annotations.Api;

/**
 
 * 
 * @category The ServiceDetailsController class is the main service provider entry point of Service
 *           API. It is expected that all service provider activity takes place through
 *           this class only.
 *
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@Api(value = "service", tags = "Service API")
public class ServiceDetailsController {

	public static final Logger logger = LoggerFactory.getLogger(ServiceDetailsController.class);

	@Autowired
	ServiceDetailsService serviceDetailsService;
	
	@Autowired
	ServiceDetailsRepository serviceDetailsRepository;
	
	@Autowired
	ServiceProviderDetailsRepository serviceProviderDetailsRepository;
	
	@Autowired
	ServiceAppointmentRepository serviceAppointmentRepository;
	
	@Autowired
	ServiceProviderIdentificationRepository serviceProviderIdentificationRepository;
	
	@Autowired
	ServiceProviderMapRepository serviceProviderMapRepository;
	
	@Autowired
	ServiceRequestRepository serviceRequestRepository;
	
	@Autowired
	ServiceReviewCommentsRepository serviceReviewComentsRepository;
	
	Timestamp currentTimestamp = new Timestamp(Calendar.getInstance().getTime().getTime());
	/**
	 * @param productBean
	 * @return ResponseEntity for the created product.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value = "/servicedetails")
	public ResponseEntity<List<ServiceDetailsDTO>> getAllServiceDetails() {
		List<ServiceDetailsDTO> serviceDetails = (ArrayList<ServiceDetailsDTO>) serviceDetailsService.getServiceDetails();
		if (serviceDetails.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ServiceDetailsDTO>>(serviceDetails, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value = "/servicedetails/{id}")
	public ResponseEntity<List<ServiceDetailsDTO>> getServiceDetailsById(@PathVariable("id") UUID id) {
		List<ServiceDetailsDTO> serviceDetails = (ArrayList<ServiceDetailsDTO>) serviceDetailsService.getServiceDetailsbyID(id);
		if (serviceDetails.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ServiceDetailsDTO>>(serviceDetails, HttpStatus.OK);
	}
	
	@PostMapping(value = "/servicedetails")
	public ResponseEntity<?> saveServiceDetails(HttpServletRequest request,@RequestBody ServiceDetailsBean serviceDetailsBean) {
		ServiceDetailsDTO serviceDetailsDTO = serviceDetailsService.saveServiceDetails(serviceDetailsBean);
		return new ResponseEntity<ServiceDetailsDTO>(serviceDetailsDTO, HttpStatus.OK);
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PutMapping(value = "/servicedetails/{id}/{status}")
	public ResponseEntity<?> updateServiceStatus(@PathVariable("id") UUID id,@PathVariable("status") String serviceStatus, @RequestBody ServiceDetailsDTO serviceDTO) {
		logger.info("Updating ServiceDetails Status with id {}", id);

		ServiceDetails newServiceDetails = serviceDetailsRepository.findOne(id);

		if (newServiceDetails == null) {
			logger.error("Unable to update. ", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate. id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		newServiceDetails.setServiceStatus(serviceStatus);
		newServiceDetails.setLastUpdatedOn(currentTimestamp);		
		serviceDetailsRepository.save(newServiceDetails);
		return new ResponseEntity<ServiceDetails>(newServiceDetails, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PutMapping(value = "/servicedetails/{id}")
	public ResponseEntity<?> updateServiceDetails(@PathVariable("id") UUID id, @RequestBody ServiceDetailsDTO serviceDTO) {
		logger.info("Updating ServiceDetails with id {}", id);

		ServiceDetails newServiceDetails = serviceDetailsRepository.findOne(id);

		if (newServiceDetails == null) {
			logger.error("Unable to update. ", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate. id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		newServiceDetails.setServiceName(serviceDTO.getServiceName());
		newServiceDetails.setLastUpdatedOn(currentTimestamp);
		newServiceDetails.setServiceStatus(serviceDTO.getServiceStatus());
		serviceDetailsRepository.save(newServiceDetails);
		return new ResponseEntity<ServiceDetails>(newServiceDetails, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/servicedetails", method = RequestMethod.DELETE)
	public ResponseEntity<ServiceDetails> deleteAllServiceDetails() {
		logger.info("Deleting All Users");
		serviceDetailsRepository.deleteAll();
		return new ResponseEntity<ServiceDetails>(HttpStatus.NO_CONTENT);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value = "/serviceAppointment")
	public ResponseEntity<List<ServiceAppointmentDTO>> getAllServiceAppointment() {
		List<ServiceAppointmentDTO> serviceAppointment = (ArrayList<ServiceAppointmentDTO>) serviceDetailsService.getAllServiceAppointment();
		if (serviceAppointment.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ServiceAppointmentDTO>>(serviceAppointment, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value = "/serviceAppointment/{id}")
	public ResponseEntity<List<ServiceAppointmentDTO>> getServiceAppointmentByUserId(@PathVariable("id") UUID id) {
		
		ServiceRequest newServiceRequest = serviceRequestRepository.findOne(id);
		UUID customerId = newServiceRequest.getRequestId();
		
		List<ServiceAppointmentDTO> serviceAppointment = (ArrayList<ServiceAppointmentDTO>) serviceDetailsService.getServiceAppointmentByUserId(customerId);
		if (serviceAppointment.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ServiceAppointmentDTO>>(serviceAppointment, HttpStatus.OK);
	}
	
	@PostMapping(value = "/serviceAppointment")
	public ResponseEntity<?> saveServiceAppointment(@RequestBody ServiceAppointmentBean serviceAppointmentBean) {			
		ServiceAppointmentDTO serviceAppointmentDTO = serviceDetailsService.saveAppointmentDetails(serviceAppointmentBean);
		return new ResponseEntity<ServiceAppointmentDTO>(serviceAppointmentDTO, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PutMapping(value = "/serviceAppointment/{id}")
	public ResponseEntity<?> updateAppointmentDetails(@PathVariable("id") UUID id, @RequestBody ServiceAppointmentDTO appointmentDTO) {
		logger.info("Updating ServiceAppointment with id {}", id);

		ServiceAppointment newServiceAppointment = serviceAppointmentRepository.findOne(id);

		if (newServiceAppointment == null) {
			logger.error("Unable to update. ", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate. id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		newServiceAppointment.setAppointmentStartTime(appointmentDTO.getAppointmentStartTime());
		newServiceAppointment.setAppointmentEndTime(appointmentDTO.getAppointmentEndTime());
		newServiceAppointment.setAppointmentDeliveryOn(appointmentDTO.getAppointmentDeliveryOn());
		newServiceAppointment.setLastUpdatedOn(currentTimestamp);
		
		serviceAppointmentRepository.save(newServiceAppointment);
		return new ResponseEntity<ServiceAppointment>(newServiceAppointment, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping(value = "/serviceAppointment/{id}")
	public ResponseEntity<?> deleteServiceAppointment(@PathVariable("id") UUID id) {
		logger.info("Fetching & Deleting ServiceDetails with id {}", id);

		ServiceAppointment serviceAppointment = serviceAppointmentRepository.findOne(id);
		if (serviceAppointment == null) {
			logger.error("Unable to delete", id);
			return new ResponseEntity(
					new CustomErrorType("Unable to delete"),
					HttpStatus.NOT_FOUND);
		}		
		serviceDetailsService.deleteAppointmentDetail(id);
		
		List<ServiceAppointment> serviceDetails = (ArrayList<ServiceAppointment>) serviceAppointmentRepository.findAll();
		return new ResponseEntity<List<ServiceAppointment>>(serviceDetails, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/serviceAppointment", method = RequestMethod.DELETE)
	public ResponseEntity<ServiceAppointment> deleteAllServiceAppointment() {
		logger.info("Deleting All Users");
		serviceAppointmentRepository.deleteAll();
		return new ResponseEntity<ServiceAppointment>(HttpStatus.NO_CONTENT);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value = "/serviceProviderDetails")
	public ResponseEntity<List<ServiceProviderDetailsDTO>> getProviderDetails() {
		List<ServiceProviderDetailsDTO> serviceProviderDetails = (ArrayList<ServiceProviderDetailsDTO>) serviceDetailsService.getServiceProviderDetails();
		if (serviceProviderDetails.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ServiceProviderDetailsDTO>>(serviceProviderDetails, HttpStatus.OK);
	}
	
	@PostMapping(value = "/serviceProviderDetails")
	public ResponseEntity<?> saveProviderDetails(@RequestBody ServiceProviderDetailsBean serviceProviderDetailsBean) {			
		ServiceProviderDetailsDTO serviceProviderDetailsDTO = serviceDetailsService.saveServiceProviderDetails(serviceProviderDetailsBean);
		return new ResponseEntity<ServiceProviderDetailsDTO>(serviceProviderDetailsDTO, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PutMapping(value = "/serviceProviderDetails/{id}")
	public ResponseEntity<?> updateProviderDetails(@PathVariable("id") UUID id, @RequestBody ServiceProviderDetailsDTO providerDetailsDTO) {
		logger.info("Updating ServiceProviderDetails with id {}", id);

		ServiceProviderDetails newServiceProviderDetails = serviceProviderDetailsRepository.findOne(id);

		if (newServiceProviderDetails == null) {
			logger.error("Unable to update. ", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate. id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		
		newServiceProviderDetails.setProviderFirstName(providerDetailsDTO.getProviderFirstName());		
		newServiceProviderDetails.setProviderLastName(providerDetailsDTO.getProviderLastName());
		newServiceProviderDetails.setProviderHomeAddress(providerDetailsDTO.getProviderHomeAddress());
		newServiceProviderDetails.setProviderContact_Number(providerDetailsDTO.getProviderContact_Number());
		newServiceProviderDetails.setProviderAlternativeContactNumber(providerDetailsDTO.getProviderAlternativeContactNumber());
		newServiceProviderDetails.setProviderEmail(providerDetailsDTO.getProviderEmail());
		newServiceProviderDetails.setProviderPhoto(providerDetailsDTO.getProviderPhoto());
		newServiceProviderDetails.setProviderWorkAddress(providerDetailsDTO.getProviderWorkAddress());
		newServiceProviderDetails.setLastUpdatedOn(currentTimestamp);
		
		serviceProviderDetailsRepository.save(newServiceProviderDetails);
		return new ResponseEntity<ServiceProviderDetails>(newServiceProviderDetails, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping(value = "/serviceProviderDetails/{id}")
	public ResponseEntity<?> deleteProviderDetails(@PathVariable("id") UUID id) {
		logger.info("Fetching & Deleting ServiceDetails with id {}", id);

		ServiceAppointment serviceAppointment = serviceAppointmentRepository.findOne(id);
		if (serviceAppointment == null) {
			logger.error("Unable to delete", id);
			return new ResponseEntity(
					new CustomErrorType("Unable to delete"),
					HttpStatus.NOT_FOUND);
		}		
		serviceDetailsService.deleteAppointmentDetail(id);
		
		List<ServiceAppointment> serviceDetails = (ArrayList<ServiceAppointment>) serviceAppointmentRepository.findAll();
		return new ResponseEntity<List<ServiceAppointment>>(serviceDetails, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/serviceProviderDetails/", method = RequestMethod.DELETE)
	public ResponseEntity<ServiceAppointment> deleteAllProviderDetails() {
		logger.info("Deleting All Users");
		serviceAppointmentRepository.deleteAll();
		return new ResponseEntity<ServiceAppointment>(HttpStatus.NO_CONTENT);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value = "/serviceProviderMap")
	public ResponseEntity<List<ServiceProviderMapDTO>> getProviderMapDetails() {
		List<ServiceProviderMapDTO> serviceProviderMap = (ArrayList<ServiceProviderMapDTO>) serviceDetailsService.getServiceProviderMapDetails();
		if (serviceProviderMap.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ServiceProviderMapDTO>>(serviceProviderMap, HttpStatus.OK);
	}
	
	@PostMapping(value = "/serviceProviderMap")
	public ResponseEntity<?> saveProviderMapDetails(@RequestBody ServiceProviderMapBean serviceProviderMapBean) {			
		ServiceProviderMapDTO serviceProviderMapDTO = serviceDetailsService.saveServiceProviderMapDetails(serviceProviderMapBean);
		return new ResponseEntity<ServiceProviderMapDTO>(serviceProviderMapDTO, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PutMapping(value = "/serviceProviderMap/{id}")
	public ResponseEntity<?> updateProviderMap(@PathVariable("id") UUID id, @RequestBody ServiceProviderMapDTO providerMapDTO) {
		logger.info("Updating ServiceProviderMap with id {}", id);

		ServiceProviderMap newServiceProviderMap = serviceProviderMapRepository.findOne(id);

		if (newServiceProviderMap == null) {
			logger.error("Unable to update. ", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate. id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		
		newServiceProviderMap.setExperienceInMonths(providerMapDTO.getExperienceInMonths());
		newServiceProviderMap.setServiceBillingRatePerHour(providerMapDTO.getServiceBillingRatePerHour());
		newServiceProviderMap.setLastUpdatedOn(currentTimestamp);		
		newServiceProviderMap.setServiceOfferingDescription(providerMapDTO.getServiceOfferingDescription());		
		
		serviceProviderMapRepository.save(newServiceProviderMap);
		return new ResponseEntity<ServiceProviderMap>(newServiceProviderMap, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping(value = "/serviceProviderMap/{id}")
	public ResponseEntity<?> deleteProviderMapDetails(@PathVariable("id") UUID id) {
		logger.info("Fetching & Deleting serviceProviderMap with id {}", id);

		ServiceProviderMap serviceProviderMap = serviceProviderMapRepository.findOne(id);
		if (serviceProviderMap == null) {
			logger.error("Unable to delete", id);
			return new ResponseEntity(
					new CustomErrorType("Unable to delete"),
					HttpStatus.NOT_FOUND);
		}		
		serviceDetailsService.deleteServiceProviderMap(id);
		
		List<ServiceProviderMap> serviceMap = (ArrayList<ServiceProviderMap>) serviceProviderMapRepository.findAll();
		return new ResponseEntity<List<ServiceProviderMap>>(serviceMap, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/serviceProviderMap", method = RequestMethod.DELETE)
	public ResponseEntity<ServiceProviderMap> deleteAllProviderMap() {
		logger.info("Deleting All serviceProviderIdentification");
		serviceProviderMapRepository.deleteAll();
		return new ResponseEntity<ServiceProviderMap>(HttpStatus.NO_CONTENT);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value = "/serviceRequest")
	public ResponseEntity<List<ServiceRequestDTO>> getServiceRequestDetails() {
		List<ServiceRequestDTO> serviceRequest = (ArrayList<ServiceRequestDTO>) serviceDetailsService.getServiceRequestDetails();
		if (serviceRequest.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ServiceRequestDTO>>(serviceRequest, HttpStatus.OK);
	}
	
	@PostMapping(value = "/serviceRequest")
	public ResponseEntity<?> saveRequestDetails(@RequestBody ServiceRequestAppointmentBean serviceRequestAppointmentBean) {			
		ServiceRequestDTO serviceRequestDTO = serviceDetailsService.saveServiceRequestDetails(serviceRequestAppointmentBean);
		return new ResponseEntity<ServiceRequestDTO>(serviceRequestDTO, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PutMapping(value = "/serviceRequest/{id}")
	public ResponseEntity<?> updateServiceRequest(@PathVariable("id") UUID id, @RequestBody ServiceRequestDTO serviceRequestDTO) {
		logger.info("Updating ServiceRequest with id {}", id);

		ServiceRequest newServiceRequest = serviceRequestRepository.findOne(id);

		if (newServiceRequest == null) {
			logger.error("Unable to update. ", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate. id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}	
		
		newServiceRequest.setRequestDate(serviceRequestDTO.getRequestDate());
		newServiceRequest.setCustomerAddressId(serviceRequestDTO.getCustomerAddressId());		
		newServiceRequest.setExpectedStartTime(serviceRequestDTO.getExpectedStartTime());
		newServiceRequest.setLastUpdatedOn(currentTimestamp);
		newServiceRequest.setRequestDescription(serviceRequestDTO.getRequestDescription());		
		newServiceRequest.setTentativeEffortsReqdInHrs(serviceRequestDTO.getTentativeEffortsReqdInHrs());
		
		serviceRequestRepository.save(newServiceRequest);
		return new ResponseEntity<ServiceRequest>(newServiceRequest, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping(value = "/serviceRequest/{id}")
	public ResponseEntity<?> deleteRequestDetails(@PathVariable("id") UUID id) {
		logger.info("Fetching & Deleting serviceRequest with id {}", id);

		ServiceRequest serviceRequest = serviceRequestRepository.findOne(id);
		if (serviceRequest == null) {
			logger.error("Unable to delete", id);
			return new ResponseEntity(
					new CustomErrorType("Unable to delete"),
					HttpStatus.NOT_FOUND);
		}		
		serviceDetailsService.deleteServiceRequest(id);
		
		List<ServiceRequest> serviceRequestdata = (ArrayList<ServiceRequest>) serviceRequestRepository.findAll();
		return new ResponseEntity<List<ServiceRequest>>(serviceRequestdata, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/serviceRequest/", method = RequestMethod.DELETE)
	public ResponseEntity<ServiceRequest> deleteAllServiceRequest() {
		logger.info("Deleting All serviceProviderIdentification");
		serviceRequestRepository.deleteAll();
		return new ResponseEntity<ServiceRequest>(HttpStatus.NO_CONTENT);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value = "/serviceReviewComments")
	public ResponseEntity<List<ServiceReviewCommentsDTO>> getServiceReviewComments() {
		List<ServiceReviewCommentsDTO> serviceReviewComments = (ArrayList<ServiceReviewCommentsDTO>) serviceDetailsService.getServiceReviewCommentDetails();
		if (serviceReviewComments.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ServiceReviewCommentsDTO>>(serviceReviewComments, HttpStatus.OK);
	}
	
	@PostMapping(value = "/serviceReviewComments")
	public ResponseEntity<?> saveReviewComments(@RequestBody ServiceReviewCommentsBean serviceReviewCommentsBean) {			
		ServiceReviewCommentsDTO serviceReviewCommentsDTO = serviceDetailsService.saveServiceReviewCommentDetails(serviceReviewCommentsBean);
		return new ResponseEntity<ServiceReviewCommentsDTO>(serviceReviewCommentsDTO, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping(value = "/serviceReviewComments/{id}")
	public ResponseEntity<?> deleteReviewComments(@PathVariable("id") UUID id) {
		logger.info("Fetching & Deleting ReviewComments with id {}", id);

		ServiceReviewComments serviceReviewComments = serviceReviewComentsRepository.findOne(id);
		if (serviceReviewComments == null) {
			logger.error("Unable to delete", id);
			return new ResponseEntity(
					new CustomErrorType("Unable to delete"),
					HttpStatus.NOT_FOUND);
		}		
		serviceDetailsService.deleteServiceReviewComments(id);
		
		List<ServiceReviewComments> serviceReviewCommentsdata = (ArrayList<ServiceReviewComments>) serviceReviewComentsRepository.findAll();
		return new ResponseEntity<List<ServiceReviewComments>>(serviceReviewCommentsdata, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/serviceReviewComments", method = RequestMethod.DELETE)
	public ResponseEntity<ServiceReviewComments> deleteAllServiceReviewComments() {
		logger.info("Deleting All ReviewComments");
		serviceReviewComentsRepository.deleteAll();
		return new ResponseEntity<ServiceReviewComments>(HttpStatus.NO_CONTENT);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value = "/servicedetails/subcat/{id}/location/{loc}")
	@CrossOrigin(origins = "/*", allowedHeaders = "*", maxAge = 3600)
	public ResponseEntity<List<ServiceDetailsDTO>> getServiceByParentCategoryId(@PathVariable("id") String id,@PathVariable("loc") String loc) {
		
		// Need to write serviceDetail implementation
		//List<ServiceDetailsDTO> serviceRequest = serviceDetailsRepository.findByCategoryId(id);
		//TODO : FIX ME
		
		// Get the service list by categoryId
		
		// filter service list by location
		
		
		
		List<ServiceDetailsDTO> serviceRequest = new ArrayList<>();	
		ServiceDetailsDTO detailsDTO = new ServiceDetailsDTO();
		//detailsDTO.setCategoryId(id);
		serviceRequest.add(detailsDTO);
		detailsDTO.setServiceName("sxgbsgsg");
		if (serviceRequest.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ServiceDetailsDTO>>(serviceRequest, HttpStatus.OK);
	}
	
	
}