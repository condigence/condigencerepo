package com.digitmarket.defaultstore.providerservice.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "service_request")
public class ServiceRequest implements Serializable {

	/**
	 * This entity is responsible to hold category details
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Type(type = "uuid-char")	
	@Column(name = "request_id")
	private UUID requestId;

	@Type(type = "uuid-char")	
	@Column(name = "customer_id")
	private UUID customerId;

	@Type(type = "uuid-char")	
	@Column(name = "customer_address_id")
	private UUID customerAddressId;
	
	@Type(type = "uuid-char")	
	@Column(name = "service_id")
	private UUID serviceId;
	
	@Column(name = "request_description")
	private String requestDescription;
	
	@Column(name = "request_date")
	private Timestamp requestDate;
	
	@Column(name = "expected_start_time")
	private Timestamp expectedStartTime;
	
	@Column(name = "tentative_efforts_reqd_in_hrs")
	private Integer tentativeEffortsReqdInHrs;
	
	@Column(name = "last_updated_on")
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerAddressId == null) ? 0 : customerAddressId.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((expectedStartTime == null) ? 0 : expectedStartTime.hashCode());
		result = prime * result + ((lastUpdatedOn == null) ? 0 : lastUpdatedOn.hashCode());
		result = prime * result + ((requestDate == null) ? 0 : requestDate.hashCode());
		result = prime * result + ((requestDescription == null) ? 0 : requestDescription.hashCode());
		result = prime * result + ((requestId == null) ? 0 : requestId.hashCode());
		result = prime * result + ((serviceId == null) ? 0 : serviceId.hashCode());
		result = prime * result + ((tentativeEffortsReqdInHrs == null) ? 0 : tentativeEffortsReqdInHrs.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServiceRequest other = (ServiceRequest) obj;
		if (customerAddressId == null) {
			if (other.customerAddressId != null)
				return false;
		} else if (!customerAddressId.equals(other.customerAddressId))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (expectedStartTime == null) {
			if (other.expectedStartTime != null)
				return false;
		} else if (!expectedStartTime.equals(other.expectedStartTime))
			return false;
		if (lastUpdatedOn == null) {
			if (other.lastUpdatedOn != null)
				return false;
		} else if (!lastUpdatedOn.equals(other.lastUpdatedOn))
			return false;
		if (requestDate == null) {
			if (other.requestDate != null)
				return false;
		} else if (!requestDate.equals(other.requestDate))
			return false;
		if (requestDescription == null) {
			if (other.requestDescription != null)
				return false;
		} else if (!requestDescription.equals(other.requestDescription))
			return false;
		if (requestId == null) {
			if (other.requestId != null)
				return false;
		} else if (!requestId.equals(other.requestId))
			return false;
		if (serviceId == null) {
			if (other.serviceId != null)
				return false;
		} else if (!serviceId.equals(other.serviceId))
			return false;
		if (tentativeEffortsReqdInHrs == null) {
			if (other.tentativeEffortsReqdInHrs != null)
				return false;
		} else if (!tentativeEffortsReqdInHrs.equals(other.tentativeEffortsReqdInHrs))
			return false;
		return true;
	}
}
