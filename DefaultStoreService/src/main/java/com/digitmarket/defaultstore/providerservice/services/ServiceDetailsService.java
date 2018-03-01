package com.digitmarket.defaultstore.providerservice.services;

import java.util.List;
import java.util.UUID;

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

/**
 * @author user
 *
 */
public interface ServiceDetailsService {

	public List<ServiceDetailsDTO> getServiceDetails();
	
	public List<ServiceDetailsDTO> getServiceDetailsbyID(UUID id);

	public ServiceDetailsDTO saveServiceDetails(ServiceDetailsBean serviceDetailsBean);
	
	public String deleteServiceDetail(UUID id);
	
	public List<ServiceAppointmentDTO> getAllServiceAppointment();
	
	public List<ServiceAppointmentDTO> getServiceAppointmentByUserId(UUID id);

	public ServiceAppointmentDTO saveAppointmentDetails(ServiceAppointmentBean serviceAppointmentBean);
	
	public String deleteAppointmentDetail(UUID id);
	
	public List<ServiceProviderDetailsDTO> getServiceProviderDetails();

	public ServiceProviderDetailsDTO saveServiceProviderDetails(ServiceProviderDetailsBean serviceProviderDetailsBean);

	public String deleteProviderDetail(UUID id);
	
	public List<ServiceProviderIdentificationDTO> getServiceProviderIdentificationDetails();

	public ServiceProviderIdentificationDTO saveServiceProviderIdentificationDetails(ServiceProviderIdentificationBean serviceProviderIdentificationBean);

	public String deleteServiceProviderIdentification(UUID id);
	
	public List<ServiceProviderMapDTO> getServiceProviderMapDetails();

	public ServiceProviderMapDTO saveServiceProviderMapDetails(ServiceProviderMapBean serviceProviderMapBean);

	public String deleteServiceProviderMap(UUID id);
	
	public List<ServiceRequestDTO> getServiceRequestDetails();

	public ServiceRequestDTO saveServiceRequestDetails(ServiceRequestAppointmentBean serviceRequestBean);

	public String deleteServiceRequest(UUID id);
	
	public List<ServiceReviewCommentsDTO> getServiceReviewCommentDetails();

	public ServiceReviewCommentsDTO saveServiceReviewCommentDetails(ServiceReviewCommentsBean serviceReviewCommentsBean);

	public String deleteServiceReviewComments(UUID id);
	
}
