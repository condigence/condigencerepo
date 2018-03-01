package com.digitmarket.defaultstore.providerservice.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitmarket.defaultstore.providerservice.bean.ServiceAppointmentBean;
import com.digitmarket.defaultstore.providerservice.bean.ServiceDetailsBean;
import com.digitmarket.defaultstore.providerservice.bean.ServiceProviderDetailsBean;
import com.digitmarket.defaultstore.providerservice.bean.ServiceProviderIdentificationBean;
import com.digitmarket.defaultstore.providerservice.bean.ServiceProviderMapBean;
import com.digitmarket.defaultstore.providerservice.bean.ServiceRequestAppointmentBean;
import com.digitmarket.defaultstore.providerservice.bean.ServiceRequestBean;
import com.digitmarket.defaultstore.providerservice.bean.ServiceReviewCommentsBean;
import com.digitmarket.defaultstore.providerservice.dto.ServiceAppointmentDTO;
import com.digitmarket.defaultstore.providerservice.dto.ServiceDetailsDTO;
import com.digitmarket.defaultstore.providerservice.dto.ServiceProviderDetailsDTO;
import com.digitmarket.defaultstore.providerservice.dto.ServiceProviderIdentificationDTO;
import com.digitmarket.defaultstore.providerservice.dto.ServiceProviderMapDTO;
import com.digitmarket.defaultstore.providerservice.dto.ServiceRequestDTO;
import com.digitmarket.defaultstore.providerservice.dto.ServiceReviewCommentsDTO;
import com.digitmarket.defaultstore.providerservice.model.ServiceAppointment;
import com.digitmarket.defaultstore.providerservice.model.ServiceDetails;
import com.digitmarket.defaultstore.providerservice.model.ServiceProviderDetails;
import com.digitmarket.defaultstore.providerservice.model.ServiceProviderIdentification;
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

@Service("serviceDetailsService")
public class ServiceDetailsServiceImpl implements ServiceDetailsService {

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
	ServiceReviewCommentsRepository serviceReviewCommentsRepository;

	Timestamp currentTimestamp = new Timestamp(Calendar.getInstance().getTime().getTime());

	@Override
	public List<ServiceDetailsDTO> getServiceDetails() {
		List<ServiceDetails> serviceDetailsList = (ArrayList<ServiceDetails>) serviceDetailsRepository
				.findAllByOrderByServiceIdDesc();
		List<ServiceDetailsDTO> ServiceDetailsDTOs = new ArrayList<>();
		for (ServiceDetails serviceDetails : serviceDetailsList) {
			ServiceDetailsDTO serviceDetailsDTO = new ServiceDetailsDTO();
			serviceDetailsDTO.setCategoryId(serviceDetails.getCategoryId());
			serviceDetailsDTO.setServiceId(serviceDetails.getServiceId());
			serviceDetailsDTO.setServiceName(serviceDetails.getServiceName());
			serviceDetailsDTO.setServiceStatus(serviceDetails.getServiceStatus());
			serviceDetailsDTO.setVendorId(serviceDetails.getVendorId());
			serviceDetailsDTO.setLastUpdatedOn(serviceDetails.getLastUpdatedOn());

			ServiceDetailsDTOs.add(serviceDetailsDTO);
		}
		return ServiceDetailsDTOs;
	}

	@Override
	public List<ServiceDetailsDTO> getServiceDetailsbyID(UUID id) {
		List<ServiceDetails> serviceDetailsList = (ArrayList<ServiceDetails>) serviceDetailsRepository
				.findAllByOrderByServiceIdDesc(id);
		List<ServiceDetailsDTO> ServiceDetailsDTOs = new ArrayList<>();
		for (ServiceDetails serviceDetails : serviceDetailsList) {
			ServiceDetailsDTO serviceDetailsDTO = new ServiceDetailsDTO();
			serviceDetailsDTO.setCategoryId(serviceDetails.getCategoryId());
			serviceDetailsDTO.setServiceId(serviceDetails.getServiceId());
			serviceDetailsDTO.setServiceName(serviceDetails.getServiceName());
			serviceDetailsDTO.setServiceStatus(serviceDetails.getServiceStatus());
			serviceDetailsDTO.setVendorId(serviceDetails.getVendorId());
			serviceDetailsDTO.setLastUpdatedOn(serviceDetails.getLastUpdatedOn());

			ServiceDetailsDTOs.add(serviceDetailsDTO);
		}
		return ServiceDetailsDTOs;
	}

	@Override
	public ServiceDetailsDTO saveServiceDetails(ServiceDetailsBean serviceBean) {
		ServiceDetails serviceDetails = new ServiceDetails();
		serviceDetails.setCategoryId(serviceBean.getCategoryId());
		serviceDetails.setServiceId(UUID.randomUUID());
		serviceDetails.setServiceName(serviceBean.getServiceName());
		serviceDetails.setServiceStatus("ACTIVE");
		serviceDetails.setVendorId(UUID.randomUUID());
		serviceDetails.setLastUpdatedOn(currentTimestamp);

		ServiceDetails savedServiceDetails = serviceDetailsRepository.save(serviceDetails);
		ServiceDetailsDTO serviceDetailsDTO = new ServiceDetailsDTO();
		serviceDetailsDTO.setServiceId(savedServiceDetails.getServiceId());

		ServiceProviderDetails serviceProviderDetails = new ServiceProviderDetails();
		serviceProviderDetails.setProviderDetailsId(UUID.randomUUID());
		serviceProviderDetails.setProviderFirstName(serviceBean.getProviderFirstName());
		serviceProviderDetails.setProviderLastName(serviceBean.getProviderLastName());
		serviceProviderDetails.setProviderHomeAddress(serviceBean.getProviderHomeAddress());
		serviceProviderDetails.setProviderContact_Number(serviceBean.getProviderContact_Number());
		serviceProviderDetails.setProviderAlternativeContactNumber(serviceBean.getProviderAlternativeContactNumber());
		serviceProviderDetails.setProviderEmail(serviceBean.getProviderEmail());
		serviceProviderDetails.setProviderPhoto(serviceBean.getProviderPhoto());
		serviceProviderDetails.setProviderWorkAddress(serviceBean.getProviderWorkAddress());
		serviceProviderDetails.setLastUpdatedOn(currentTimestamp);
		serviceProviderDetails.setServiceId(serviceDetailsDTO.getServiceId());
		serviceProviderDetailsRepository.save(serviceProviderDetails);

		ServiceProviderMap serviceProviderMap = new ServiceProviderMap();
		serviceProviderMap.setServiceMapId(UUID.randomUUID());
		serviceProviderMap.setExperienceInMonths(serviceBean.getExperienceInMonths());
		serviceProviderMap.setServiceBillingRatePerHour(serviceBean.getServiceBillingRatePerHour());
		serviceProviderMap.setLastUpdatedOn(currentTimestamp);
		serviceProviderMap.setServiceId(serviceDetailsDTO.getServiceId());
		serviceProviderMap.setServiceOfferingDescription(serviceBean.getServiceOfferingDescription());
		serviceProviderMapRepository.save(serviceProviderMap);

		return serviceDetailsDTO;
	}

	@Override
	public String deleteServiceDetail(UUID id) {
		serviceDetailsRepository.delete(id);
		return "success";
	}

	@Override
	public List<ServiceAppointmentDTO> getAllServiceAppointment() {
		List<ServiceAppointment> serviceAppointmentList = (ArrayList<ServiceAppointment>) serviceAppointmentRepository
				.findAllByOrderByAppointmentIdDesc();
		List<ServiceAppointmentDTO> ServiceAppointmentDTOs = new ArrayList<>();
		for (ServiceAppointment serviceAppointment : serviceAppointmentList) {
			ServiceAppointmentDTO serviceAppointmentDTO = new ServiceAppointmentDTO();
			serviceAppointmentDTO.setAppointmentId(serviceAppointment.getAppointmentId());
			serviceAppointmentDTO.setRequestId(serviceAppointment.getRequestId());
			serviceAppointmentDTO.setServiceId(serviceAppointment.getServiceId());
			serviceAppointmentDTO.setAppointmentStartTime(serviceAppointment.getAppointmentStartTime());
			serviceAppointmentDTO.setAppointmentDeliveryOn(serviceAppointment.getAppointmentDeliveryOn());
			serviceAppointmentDTO.setAppointmentEndTime(serviceAppointment.getAppointmentEndTime());
			serviceAppointmentDTO.setLastUpdatedOn(serviceAppointment.getLastUpdatedOn());

			ServiceAppointmentDTOs.add(serviceAppointmentDTO);
		}
		return ServiceAppointmentDTOs;
	}

	@Override
	public List<ServiceAppointmentDTO> getServiceAppointmentByUserId(UUID id) {
		List<ServiceAppointment> serviceAppointmentList = (ArrayList<ServiceAppointment>) serviceAppointmentRepository
				.findAllByOrderByServiceIdDesc(id);
		List<ServiceAppointmentDTO> ServiceAppointmentDTOs = new ArrayList<>();
		for (ServiceAppointment serviceAppointment : serviceAppointmentList) {
			ServiceAppointmentDTO serviceAppointmentDTO = new ServiceAppointmentDTO();
			serviceAppointmentDTO.setAppointmentId(serviceAppointment.getAppointmentId());
			serviceAppointmentDTO.setRequestId(serviceAppointment.getRequestId());
			serviceAppointmentDTO.setServiceId(serviceAppointment.getServiceId());
			serviceAppointmentDTO.setAppointmentStartTime(serviceAppointment.getAppointmentStartTime());
			serviceAppointmentDTO.setAppointmentDeliveryOn(serviceAppointment.getAppointmentDeliveryOn());
			serviceAppointmentDTO.setAppointmentEndTime(serviceAppointment.getAppointmentEndTime());
			serviceAppointmentDTO.setLastUpdatedOn(serviceAppointment.getLastUpdatedOn());

			ServiceAppointmentDTOs.add(serviceAppointmentDTO);
		}
		return ServiceAppointmentDTOs;
	}

	@Override
	public ServiceAppointmentDTO saveAppointmentDetails(ServiceAppointmentBean serviceBean) {
		ServiceAppointment serviceAppointment = new ServiceAppointment();

		serviceAppointment.setAppointmentId(UUID.randomUUID());
		serviceAppointment.setRequestId(serviceBean.getRequestId());
		serviceAppointment.setServiceId(serviceBean.getServiceId());
		serviceAppointment.setAppointmentStartTime(serviceBean.getAppointmentStartTime());
		serviceAppointment.setAppointmentDeliveryOn(serviceBean.getAppointmentDeliveryOn());
		serviceAppointment.setAppointmentEndTime(serviceBean.getAppointmentEndTime());
		serviceAppointment.setLastUpdatedOn(currentTimestamp);

		ServiceAppointment savedServiceAppointment = serviceAppointmentRepository.save(serviceAppointment);
		ServiceAppointmentDTO serviceAppointmentDTO = new ServiceAppointmentDTO();
		serviceAppointmentDTO.setAppointmentId(savedServiceAppointment.getAppointmentId());

		return serviceAppointmentDTO;
	}

	@Override
	public String deleteAppointmentDetail(UUID id) {
		serviceDetailsRepository.delete(id);
		return "success";
	}

	@Override
	public List<ServiceProviderDetailsDTO> getServiceProviderDetails() {
		List<ServiceProviderDetails> serviceProviderDetailsList = (ArrayList<ServiceProviderDetails>) serviceProviderDetailsRepository
				.findAllByOrderByProviderDetailsIdDesc();
		List<ServiceProviderDetailsDTO> ServiceProviderDetailsDTOs = new ArrayList<>();
		for (ServiceProviderDetails serviceProviderDetails : serviceProviderDetailsList) {
			ServiceProviderDetailsDTO serviceProviderDetailsDTO = new ServiceProviderDetailsDTO();
			serviceProviderDetailsDTO.setProviderDetailsId(serviceProviderDetails.getProviderDetailsId());
			serviceProviderDetailsDTO.setProviderFirstName(serviceProviderDetails.getProviderFirstName());
			serviceProviderDetailsDTO.setProviderMiddleName(serviceProviderDetails.getProviderMiddleName());
			serviceProviderDetailsDTO.setProviderLastName(serviceProviderDetails.getProviderLastName());
			serviceProviderDetailsDTO.setProviderHomeAddress(serviceProviderDetails.getProviderHomeAddress());
			serviceProviderDetailsDTO
					.setProviderAlternativeContactNumber(serviceProviderDetails.getProviderAlternativeContactNumber());
			serviceProviderDetailsDTO.setProviderEmail(serviceProviderDetails.getProviderEmail());
			serviceProviderDetailsDTO.setProviderPhoto(serviceProviderDetails.getProviderPhoto());
			serviceProviderDetailsDTO.setProviderWorkAddress(serviceProviderDetails.getProviderWorkAddress());
			serviceProviderDetailsDTO.setLastUpdatedOn(serviceProviderDetails.getLastUpdatedOn());
			serviceProviderDetailsDTO.setServiceId(serviceProviderDetails.getServiceId());

			ServiceProviderDetailsDTOs.add(serviceProviderDetailsDTO);
		}
		return ServiceProviderDetailsDTOs;
	}

	@Override
	public ServiceProviderDetailsDTO saveServiceProviderDetails(ServiceProviderDetailsBean serviceProviderBean) {
		ServiceProviderDetails serviceProviderDetails = new ServiceProviderDetails();

		serviceProviderDetails.setProviderDetailsId(serviceProviderBean.getProviderDetailsId());
		serviceProviderDetails.setProviderFirstName(serviceProviderBean.getProviderFirstName());
		serviceProviderDetails.setProviderMiddleName(serviceProviderBean.getProviderMiddleName());
		serviceProviderDetails.setProviderLastName(serviceProviderBean.getProviderLastName());
		serviceProviderDetails.setProviderHomeAddress(serviceProviderBean.getProviderHomeAddress());
		serviceProviderDetails
				.setProviderAlternativeContactNumber(serviceProviderBean.getProviderAlternativeContactNumber());
		serviceProviderDetails.setProviderEmail(serviceProviderBean.getProviderEmail());
		serviceProviderDetails.setProviderPhoto(serviceProviderBean.getProviderPhoto());
		serviceProviderDetails.setProviderWorkAddress(serviceProviderBean.getProviderWorkAddress());
		serviceProviderDetails.setLastUpdatedOn(currentTimestamp);
		serviceProviderDetails.setServiceId(serviceProviderBean.getServiceId());

		ServiceProviderDetails savedServiceProviderDetails = serviceProviderDetailsRepository
				.save(serviceProviderDetails);
		ServiceProviderDetailsDTO serviceProviderDetailsDTO = new ServiceProviderDetailsDTO();
		serviceProviderDetailsDTO.setProviderDetailsId(savedServiceProviderDetails.getProviderDetailsId());

		return serviceProviderDetailsDTO;
	}

	@Override
	public String deleteProviderDetail(UUID id) {
		serviceProviderDetailsRepository.delete(id);
		return "success";
	}

	@Override
	public List<ServiceProviderIdentificationDTO> getServiceProviderIdentificationDetails() {
		List<ServiceProviderIdentification> serviceProviderIdentificationList = (ArrayList<ServiceProviderIdentification>) serviceProviderIdentificationRepository
				.findAllByOrderByServiceIdentificationIdDesc();
		List<ServiceProviderIdentificationDTO> ServiceProviderIdentificationDTOs = new ArrayList<>();
		for (ServiceProviderIdentification serviceProviderIdentification : serviceProviderIdentificationList) {
			ServiceProviderIdentificationDTO serviceProviderIdentificationDTO = new ServiceProviderIdentificationDTO();
			serviceProviderIdentificationDTO
					.setServiceIdentificationId(serviceProviderIdentification.getServiceIdentificationId());
			serviceProviderIdentificationDTO.setIsVerified(serviceProviderIdentification.getIsVerified());
			serviceProviderIdentificationDTO.setProviderIdProof(serviceProviderIdentification.getProviderIdProof());
			serviceProviderIdentificationDTO.setServiceDetailsId(serviceProviderIdentification.getServiceDetailsId());
			serviceProviderIdentificationDTO.setLastUpdatedOn(serviceProviderIdentification.getLastUpdatedOn());
			ServiceProviderIdentificationDTOs.add(serviceProviderIdentificationDTO);
		}
		return ServiceProviderIdentificationDTOs;
	}

	@Override
	public ServiceProviderIdentificationDTO saveServiceProviderIdentificationDetails(
			ServiceProviderIdentificationBean serviceProviderIdentificationBean) {
		ServiceProviderIdentification serviceProviderIdentification = new ServiceProviderIdentification();

		serviceProviderIdentification
				.setServiceIdentificationId(serviceProviderIdentificationBean.getServiceIdentificationId());
		serviceProviderIdentification.setIsVerified(serviceProviderIdentificationBean.getIsVerified());
		serviceProviderIdentification.setProviderIdProof(serviceProviderIdentificationBean.getProviderIdProof());
		serviceProviderIdentification.setServiceDetailsId(serviceProviderIdentificationBean.getServiceDetailsId());
		serviceProviderIdentification.setLastUpdatedOn(currentTimestamp);

		ServiceProviderIdentification savedServiceProviderIdentification = serviceProviderIdentificationRepository
				.save(serviceProviderIdentification);
		ServiceProviderIdentificationDTO serviceProviderIdentificationDTO = new ServiceProviderIdentificationDTO();
		serviceProviderIdentificationDTO
				.setServiceIdentificationId(savedServiceProviderIdentification.getServiceIdentificationId());

		return serviceProviderIdentificationDTO;
	}

	@Override
	public String deleteServiceProviderIdentification(UUID id) {
		serviceProviderIdentificationRepository.delete(id);
		return "success";
	}

	@Override
	public List<ServiceProviderMapDTO> getServiceProviderMapDetails() {
		List<ServiceProviderMap> serviceProviderMapList = (ArrayList<ServiceProviderMap>) serviceProviderMapRepository
				.findAllByOrderByServiceMapIdDesc();
		List<ServiceProviderMapDTO> ServiceProviderMapDTOs = new ArrayList<>();
		for (ServiceProviderMap serviceProviderMap : serviceProviderMapList) {
			ServiceProviderMapDTO serviceProviderMapDTO = new ServiceProviderMapDTO();
			serviceProviderMapDTO.setServiceMapId(serviceProviderMap.getServiceMapId());
			serviceProviderMapDTO.setExperienceInMonths(serviceProviderMap.getExperienceInMonths());
			serviceProviderMapDTO.setServiceBillingRatePerHour(serviceProviderMap.getServiceBillingRatePerHour());
			serviceProviderMapDTO.setLastUpdatedOn(serviceProviderMap.getLastUpdatedOn());
			serviceProviderMapDTO.setServiceId(serviceProviderMap.getServiceId());
			serviceProviderMapDTO.setServiceOfferingDescription(serviceProviderMap.getServiceOfferingDescription());
			ServiceProviderMapDTOs.add(serviceProviderMapDTO);
		}
		return ServiceProviderMapDTOs;
	}

	@Override
	public ServiceProviderMapDTO saveServiceProviderMapDetails(ServiceProviderMapBean serviceProviderMapBean) {
		ServiceProviderMap serviceProviderMap = new ServiceProviderMap();

		serviceProviderMap.setServiceMapId(serviceProviderMapBean.getServiceMapId());
		serviceProviderMap.setExperienceInMonths(serviceProviderMapBean.getExperienceInMonths());
		serviceProviderMap.setServiceBillingRatePerHour(serviceProviderMapBean.getServiceBillingRatePerHour());
		serviceProviderMap.setLastUpdatedOn(currentTimestamp);
		serviceProviderMap.setServiceId(serviceProviderMapBean.getServiceId());
		serviceProviderMap.setServiceOfferingDescription(serviceProviderMapBean.getServiceOfferingDescription());

		ServiceProviderMap savedProviderMap = serviceProviderMapRepository.save(serviceProviderMap);
		ServiceProviderMapDTO serviceProviderMapDTO = new ServiceProviderMapDTO();
		serviceProviderMapDTO.setServiceMapId(savedProviderMap.getServiceMapId());

		return serviceProviderMapDTO;
	}

	@Override
	public String deleteServiceProviderMap(UUID id) {
		serviceProviderMapRepository.delete(id);
		return "success";
	}

	@Override
	public List<ServiceRequestDTO> getServiceRequestDetails() {
		List<ServiceRequest> serviceRequestList = (ArrayList<ServiceRequest>) serviceRequestRepository
				.findAllByOrderByRequestIdDesc();
		List<ServiceRequestDTO> ServiceRequestDTOs = new ArrayList<>();
		for (ServiceRequest serviceRequest : serviceRequestList) {
			ServiceRequestDTO serviceRequestDTO = new ServiceRequestDTO();
			serviceRequestDTO.setRequestId(serviceRequest.getRequestId());
			serviceRequestDTO.setRequestDate(serviceRequest.getRequestDate());
			serviceRequestDTO.setCustomerAddressId(serviceRequest.getCustomerAddressId());
			serviceRequestDTO.setCustomerId(serviceRequest.getCustomerId());
			serviceRequestDTO.setExpectedStartTime(serviceRequest.getExpectedStartTime());
			serviceRequestDTO.setLastUpdatedOn(serviceRequest.getLastUpdatedOn());
			serviceRequestDTO.setRequestDescription(serviceRequest.getRequestDescription());
			serviceRequestDTO.setServiceId(serviceRequest.getServiceId());
			serviceRequestDTO.setTentativeEffortsReqdInHrs(serviceRequest.getTentativeEffortsReqdInHrs());

			ServiceRequestDTOs.add(serviceRequestDTO);
		}
		return ServiceRequestDTOs;
	}

	@Override
	public ServiceRequestDTO saveServiceRequestDetails(ServiceRequestAppointmentBean serviceRequestAppBean) {
		ServiceRequest serviceRequest = new ServiceRequest();

		serviceRequest.setRequestId(UUID.randomUUID());
		serviceRequest.setRequestDate(serviceRequestAppBean.getRequestDate());
		serviceRequest.setCustomerAddressId(serviceRequestAppBean.getCustomerAddressId());
		serviceRequest.setCustomerId(serviceRequestAppBean.getCustomerId());
		serviceRequest.setExpectedStartTime(serviceRequestAppBean.getExpectedStartTime());
		serviceRequest.setLastUpdatedOn(currentTimestamp);
		serviceRequest.setRequestDescription(serviceRequestAppBean.getRequestDescription());
		serviceRequest.setServiceId(serviceRequestAppBean.getServiceId());
		serviceRequest.setTentativeEffortsReqdInHrs(serviceRequestAppBean.getTentativeEffortsReqdInHrs());

		ServiceRequest savedRequest = serviceRequestRepository.save(serviceRequest);
		ServiceAppointment appointment = new ServiceAppointment();		
		appointment.setAppointmentId(UUID.randomUUID());
		appointment.setRequestId(savedRequest.getRequestId());
		appointment.setServiceId(savedRequest.getServiceId());
		ServiceAppointment savedServiceAppointment = serviceAppointmentRepository.save(appointment);
		ServiceRequestDTO serviceRequestDTO = new ServiceRequestDTO();
		serviceRequestDTO.setRequestId(savedRequest.getRequestId());

		return serviceRequestDTO;
	}

	@Override
	public String deleteServiceRequest(UUID id) {
		serviceRequestRepository.delete(id);
		return "success";
	}

	@Override
	public List<ServiceReviewCommentsDTO> getServiceReviewCommentDetails() {
		List<ServiceReviewComments> serviceReviewCommentsList = (ArrayList<ServiceReviewComments>) serviceReviewCommentsRepository
				.findAllByOrderByReviewCommentsIdDesc();
		List<ServiceReviewCommentsDTO> ServiceReviewCommentsDTOs = new ArrayList<>();
		for (ServiceReviewComments serviceReviewComments : serviceReviewCommentsList) {
			ServiceReviewCommentsDTO serviceReviewCommentsDTO = new ServiceReviewCommentsDTO();
			serviceReviewCommentsDTO.setReviewCommentsId(serviceReviewComments.getReviewCommentsId());
			;
			serviceReviewCommentsDTO.setCustomer_id(serviceReviewComments.getCustomer_id());
			serviceReviewCommentsDTO.setLastUpdatedOn(serviceReviewComments.getLastUpdatedOn());
			serviceReviewCommentsDTO.setReviewComments(serviceReviewComments.getReviewComments());
			serviceReviewCommentsDTO.setReviewDate(serviceReviewComments.getReviewDate());
			serviceReviewCommentsDTO.setReviewRating(serviceReviewComments.getReviewRating());
			serviceReviewCommentsDTO.setServiceId(serviceReviewComments.getServiceId());

			ServiceReviewCommentsDTOs.add(serviceReviewCommentsDTO);
		}
		return ServiceReviewCommentsDTOs;
	}

	@Override
	public ServiceReviewCommentsDTO saveServiceReviewCommentDetails(
			ServiceReviewCommentsBean serviceReviewCommentsBean) {
		ServiceReviewComments serviceReviewComments = new ServiceReviewComments();

		serviceReviewComments.setReviewCommentsId(serviceReviewCommentsBean.getReviewCommentsId());
		;
		serviceReviewComments.setCustomer_id(serviceReviewCommentsBean.getCustomer_id());
		serviceReviewComments.setLastUpdatedOn(serviceReviewCommentsBean.getLastUpdatedOn());
		serviceReviewComments.setReviewComments(serviceReviewCommentsBean.getReviewComments());
		serviceReviewComments.setReviewDate(serviceReviewCommentsBean.getReviewDate());
		serviceReviewComments.setReviewRating(serviceReviewCommentsBean.getReviewRating());
		serviceReviewComments.setServiceId(serviceReviewCommentsBean.getServiceId());
		ServiceReviewComments savedReviewComments = serviceReviewCommentsRepository.save(serviceReviewComments);
		ServiceReviewCommentsDTO serviceReviewCommentsDTO = new ServiceReviewCommentsDTO();
		// serviceReviewCommentsDTO.setReviewCommentsId(savedReviewComments.getReviewCommentsId);

		return serviceReviewCommentsDTO;
	}

	@Override
	public String deleteServiceReviewComments(UUID id) {
		serviceReviewCommentsRepository.delete(id);
		return "success";
	}

}
