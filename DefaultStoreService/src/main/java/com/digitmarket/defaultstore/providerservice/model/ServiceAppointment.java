package com.digitmarket.defaultstore.providerservice.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "service_appointment")
public class ServiceAppointment implements Serializable {

	/**
	 * This entity is responsible to hold category details
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Type(type = "uuid-char")	
	@Column(name = "appointment_id")
	private UUID appointmentId;

	@Type(type = "uuid-char")	
	@Column(name = "request_id")
	private UUID requestId;

	@Type(type = "uuid-char")	
	@Column(name = "service_id")
	private UUID serviceId;
	
	@Column(name = "appointment_delivery_on")
	private Date appointmentDeliveryOn;	
	
	@Column(name = "appointment_start_time")
	private Timestamp appointmentStartTime;
	
	@Column(name = "appointment_end_time")
	private Timestamp appointmentEndTime;
	
	@Column(name = "last_updated_on")
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appointmentDeliveryOn == null) ? 0 : appointmentDeliveryOn.hashCode());
		result = prime * result + ((appointmentEndTime == null) ? 0 : appointmentEndTime.hashCode());
		result = prime * result + ((appointmentId == null) ? 0 : appointmentId.hashCode());
		result = prime * result + ((appointmentStartTime == null) ? 0 : appointmentStartTime.hashCode());
		result = prime * result + ((lastUpdatedOn == null) ? 0 : lastUpdatedOn.hashCode());
		result = prime * result + ((requestId == null) ? 0 : requestId.hashCode());
		result = prime * result + ((serviceId == null) ? 0 : serviceId.hashCode());
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
		ServiceAppointment other = (ServiceAppointment) obj;
		if (appointmentDeliveryOn == null) {
			if (other.appointmentDeliveryOn != null)
				return false;
		} else if (!appointmentDeliveryOn.equals(other.appointmentDeliveryOn))
			return false;
		if (appointmentEndTime == null) {
			if (other.appointmentEndTime != null)
				return false;
		} else if (!appointmentEndTime.equals(other.appointmentEndTime))
			return false;
		if (appointmentId == null) {
			if (other.appointmentId != null)
				return false;
		} else if (!appointmentId.equals(other.appointmentId))
			return false;
		if (appointmentStartTime == null) {
			if (other.appointmentStartTime != null)
				return false;
		} else if (!appointmentStartTime.equals(other.appointmentStartTime))
			return false;
		if (lastUpdatedOn == null) {
			if (other.lastUpdatedOn != null)
				return false;
		} else if (!lastUpdatedOn.equals(other.lastUpdatedOn))
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
		return true;
	}
}
