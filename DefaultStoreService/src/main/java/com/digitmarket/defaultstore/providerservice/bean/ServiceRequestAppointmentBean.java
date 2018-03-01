package com.digitmarket.defaultstore.providerservice.bean;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

public class ServiceRequestAppointmentBean {

	private UUID customerId;

	private UUID customerAddressId;

	private String requestDescription;

	private Timestamp requestDate;

	private Timestamp expectedStartTime;

	private Integer tentativeEffortsReqdInHrs;

	private UUID appointmentId;

	private UUID requestId;

	private UUID serviceId;

	private Date appointmentDeliveryOn;

	private Timestamp appointmentStartTime;

	private Timestamp appointmentEndTime;

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

	public UUID getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(UUID appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Date getAppointmentDeliveryOn() {
		return appointmentDeliveryOn;
	}

	public void setAppointmentDeliveryOn(Date appointmentDeliveryOn) {
		this.appointmentDeliveryOn = appointmentDeliveryOn;
	}

	public Timestamp getAppointmentStartTime() {
		return appointmentStartTime;
	}

	public void setAppointmentStartTime(Timestamp appointmentStartTime) {
		this.appointmentStartTime = appointmentStartTime;
	}

	public Timestamp getAppointmentEndTime() {
		return appointmentEndTime;
	}

	public void setAppointmentEndTime(Timestamp appointmentEndTime) {
		this.appointmentEndTime = appointmentEndTime;
	}

}
