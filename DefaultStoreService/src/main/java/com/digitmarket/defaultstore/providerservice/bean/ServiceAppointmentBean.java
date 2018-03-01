package com.digitmarket.defaultstore.providerservice.bean;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

public class ServiceAppointmentBean {

	/**
	 * This Bean is responsible to hold service appointment details coming through form.
	 */

	private UUID appointmentId;

	private UUID requestId;

	private UUID serviceId;

	private Date appointmentDeliveryOn;	
	
	private Timestamp appointmentStartTime;
	
	private Timestamp appointmentEndTime;
	
	private Timestamp lastUpdatedOn;

	public UUID getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(UUID appointmentId) {
		this.appointmentId = appointmentId;
	}

	public UUID getRequestId() {
		return requestId;
	}

	public void setRequestId(UUID requestId) {
		this.requestId = requestId;
	}

	public UUID getServiceId() {
		return serviceId;
	}

	public void setServiceId(UUID serviceId) {
		this.serviceId = serviceId;
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

	public Timestamp getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	public void setLastUpdatedOn(Timestamp lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}
}
