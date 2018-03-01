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
@Table(name = "service_provider_map")
public class ServiceProviderMap implements Serializable {

	/**
	 * This entity is responsible to hold category details
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Type(type = "uuid-char")
	@Column(name = "service_map_id")
	private UUID serviceMapId;
	
	@Type(type = "uuid-char")	
	@Column(name = "service_id")
	private UUID serviceId;	

	@Column(name = "service_billing_rate_per_hour")
	private Float serviceBillingRatePerHour;
	
	@Column(name = "experience_in_months")
	private Double experienceInMonths;
	
	@Column(name = "service_offering_description")
	private String serviceOfferingDescription;
	
	@Column(name = "last_updated_on")
	private Timestamp lastUpdatedOn;

	public UUID getServiceMapId() {
		return serviceMapId;
	}

	public void setServiceMapId(UUID serviceMapId) {
		this.serviceMapId = serviceMapId;
	}

	public UUID getServiceId() {
		return serviceId;
	}

	public void setServiceId(UUID serviceId) {
		this.serviceId = serviceId;
	}

	public Float getServiceBillingRatePerHour() {
		return serviceBillingRatePerHour;
	}

	public void setServiceBillingRatePerHour(Float serviceBillingRatePerHour) {
		this.serviceBillingRatePerHour = serviceBillingRatePerHour;
	}

	public Double getExperienceInMonths() {
		return experienceInMonths;
	}

	public void setExperienceInMonths(Double experienceInMonths) {
		this.experienceInMonths = experienceInMonths;
	}

	public String getServiceOfferingDescription() {
		return serviceOfferingDescription;
	}

	public void setServiceOfferingDescription(String serviceOfferingDescription) {
		this.serviceOfferingDescription = serviceOfferingDescription;
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
		result = prime * result + ((experienceInMonths == null) ? 0 : experienceInMonths.hashCode());
		result = prime * result + ((lastUpdatedOn == null) ? 0 : lastUpdatedOn.hashCode());
		result = prime * result + ((serviceBillingRatePerHour == null) ? 0 : serviceBillingRatePerHour.hashCode());
		result = prime * result + ((serviceId == null) ? 0 : serviceId.hashCode());
		result = prime * result + ((serviceMapId == null) ? 0 : serviceMapId.hashCode());
		result = prime * result + ((serviceOfferingDescription == null) ? 0 : serviceOfferingDescription.hashCode());
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
		ServiceProviderMap other = (ServiceProviderMap) obj;
		if (experienceInMonths == null) {
			if (other.experienceInMonths != null)
				return false;
		} else if (!experienceInMonths.equals(other.experienceInMonths))
			return false;
		if (lastUpdatedOn == null) {
			if (other.lastUpdatedOn != null)
				return false;
		} else if (!lastUpdatedOn.equals(other.lastUpdatedOn))
			return false;
		if (serviceBillingRatePerHour == null) {
			if (other.serviceBillingRatePerHour != null)
				return false;
		} else if (!serviceBillingRatePerHour.equals(other.serviceBillingRatePerHour))
			return false;
		if (serviceId == null) {
			if (other.serviceId != null)
				return false;
		} else if (!serviceId.equals(other.serviceId))
			return false;
		if (serviceMapId == null) {
			if (other.serviceMapId != null)
				return false;
		} else if (!serviceMapId.equals(other.serviceMapId))
			return false;
		if (serviceOfferingDescription == null) {
			if (other.serviceOfferingDescription != null)
				return false;
		} else if (!serviceOfferingDescription.equals(other.serviceOfferingDescription))
			return false;
		return true;
	}
}
