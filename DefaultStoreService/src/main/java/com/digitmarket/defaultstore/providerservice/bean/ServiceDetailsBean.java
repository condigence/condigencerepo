package com.digitmarket.defaultstore.providerservice.bean;

import java.sql.Timestamp;
import java.util.UUID;

public class ServiceDetailsBean {

	/**
	 * This Bean is responsible to hold service details coming through form.
	 */

	private UUID serviceId;

	private UUID categoryId;

	private UUID vendorId;

	private String serviceName;
	
	private String serviceOfferingDescription;	
	
	private Float serviceBillingRatePerHour;
	
	private Double experienceInMonths;
	
	private String providerFirstName;
	
	private String providerLastName;
	
	private String providerMiddleName;
	
	private String providerContact_Number;
	
	private String providerAlternativeContactNumber;
	
	private String providerHomeAddress;
	
	private String providerWorkAddress;
	
	private String providerEmail;
	
	private String serviceStatus;
	
	private byte[] providerPhoto;
	
	private String providerIdProof;
	
	private Timestamp lastUpdatedOn;

	public UUID getServiceId() {
		return serviceId;
	}

	public void setServiceId(UUID serviceId) {
		this.serviceId = serviceId;
	}

	public UUID getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(UUID categoryId) {
		this.categoryId = categoryId;
	}

	public UUID getVendorId() {
		return vendorId;
	}

	public void setVendorId(UUID vendorId) {
		this.vendorId = vendorId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Timestamp getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	public void setLastUpdatedOn(Timestamp lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}

	public String getServiceOfferingDescription() {
		return serviceOfferingDescription;
	}

	public void setServiceOfferingDescription(String serviceOfferingDescription) {
		this.serviceOfferingDescription = serviceOfferingDescription;
	}

	public String getProviderFirstName() {
		return providerFirstName;
	}

	public void setProviderFirstName(String providerFirstName) {
		this.providerFirstName = providerFirstName;
	}

	public String getProviderLastName() {
		return providerLastName;
	}

	public void setProviderLastName(String providerLastName) {
		this.providerLastName = providerLastName;
	}

	public String getProviderMiddleName() {
		return providerMiddleName;
	}

	public void setProviderMiddleName(String providerMiddleName) {
		this.providerMiddleName = providerMiddleName;
	}

	public String getProviderContact_Number() {
		return providerContact_Number;
	}

	public void setProviderContact_Number(String providerContact_Number) {
		this.providerContact_Number = providerContact_Number;
	}

	public String getProviderAlternativeContactNumber() {
		return providerAlternativeContactNumber;
	}

	public void setProviderAlternativeContactNumber(String providerAlternativeContactNumber) {
		this.providerAlternativeContactNumber = providerAlternativeContactNumber;
	}

	public String getProviderHomeAddress() {
		return providerHomeAddress;
	}

	public void setProviderHomeAddress(String providerHomeAddress) {
		this.providerHomeAddress = providerHomeAddress;
	}

	public String getProviderWorkAddress() {
		return providerWorkAddress;
	}

	public void setProviderWorkAddress(String providerWorkAddress) {
		this.providerWorkAddress = providerWorkAddress;
	}

	public String getProviderEmail() {
		return providerEmail;
	}

	public void setProviderEmail(String providerEmail) {
		this.providerEmail = providerEmail;
	}

	public byte[] getProviderPhoto() {
		return providerPhoto;
	}

	public void setProviderPhoto(byte[] bytes) {
		this.providerPhoto = bytes;
	}

	public Double getExperienceInMonths() {
		return experienceInMonths;
	}

	public void setExperienceInMonths(Double experienceInMonths) {
		this.experienceInMonths = experienceInMonths;
	}

	public Float getServiceBillingRatePerHour() {
		return serviceBillingRatePerHour;
	}

	public void setServiceBillingRatePerHour(Float serviceBillingRatePerHour) {
		this.serviceBillingRatePerHour = serviceBillingRatePerHour;
	}

	public String getServiceStatus() {
		return serviceStatus;
	}

	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

	public String getProviderIdProof() {
		return providerIdProof;
	}

	public void setProviderIdProof(String providerIdProof) {
		this.providerIdProof = providerIdProof;
	}
	
	
}
