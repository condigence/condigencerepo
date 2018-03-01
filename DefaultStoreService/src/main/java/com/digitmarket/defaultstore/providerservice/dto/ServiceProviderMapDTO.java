package com.digitmarket.defaultstore.providerservice.dto;

import java.sql.Timestamp;
import java.util.UUID;

public class ServiceProviderMapDTO {
	
	private UUID serviceMapId;

	private UUID serviceId;

	private Float serviceBillingRatePerHour;
	
	private Double experienceInMonths;
	
	private String serviceOfferingDescription;
	
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
}
