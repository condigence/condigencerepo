package com.digitmarket.defaultstore.providerservice.dto;

import java.sql.Timestamp;
import java.util.UUID;

public class ServiceRequestDTO {
	
	private UUID requestId;
	
	private UUID customerId;
	
	private UUID customerAddressId;	
	
	private UUID serviceId;
	
	private String requestDescription;	
	
	private Timestamp requestDate;	
	
	private Timestamp expectedStartTime;	
	
	private Integer tentativeEffortsReqdInHrs;	
	
	private Timestamp lastUpdatedOn;

	public UUID getRequestId() {
		return requestId;
	}

	public void setRequestId(UUID requestId) {
		this.requestId = requestId;
	}

	public UUID getCustomerId() {
		return customerId;
	}

	public void setCustomerId(UUID customerId) {
		this.customerId = customerId;
	}

	public UUID getCustomerAddressId() {
		return customerAddressId;
	}

	public void setCustomerAddressId(UUID customerAddressId) {
		this.customerAddressId = customerAddressId;
	}

	public UUID getServiceId() {
		return serviceId;
	}

	public void setServiceId(UUID serviceId) {
		this.serviceId = serviceId;
	}

	public String getRequestDescription() {
		return requestDescription;
	}

	public void setRequestDescription(String requestDescription) {
		this.requestDescription = requestDescription;
	}

	public Timestamp getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Timestamp requestDate) {
		this.requestDate = requestDate;
	}

	public Timestamp getExpectedStartTime() {
		return expectedStartTime;
	}

	public void setExpectedStartTime(Timestamp expectedStartTime) {
		this.expectedStartTime = expectedStartTime;
	}

	public Integer getTentativeEffortsReqdInHrs() {
		return tentativeEffortsReqdInHrs;
	}

	public void setTentativeEffortsReqdInHrs(Integer tentativeEffortsReqdInHrs) {
		this.tentativeEffortsReqdInHrs = tentativeEffortsReqdInHrs;
	}

	public Timestamp getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	public void setLastUpdatedOn(Timestamp lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}
	
}
