package com.digitmarket.defaultstore.providerservice.dto;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

public class ServiceProviderDetailsDTO {

	private UUID providerDetailsId;

	private String providerFirstName;
	
	private String providerLastName;
	
	private String providerMiddleName;
	
	private String providerContact_Number;
	
	private String providerAlternativeContactNumber;
	
	private String providerHomeAddress;
	
	private String providerWorkAddress;
	
	private String providerEmail;
	
	private byte[] providerPhoto;
	
	private UUID serviceId;
	
	private Timestamp lastUpdatedOn;

	public UUID getProviderDetailsId() {
		return providerDetailsId;
	}

	public void setProviderDetailsId(UUID providerDetailsId) {
		this.providerDetailsId = providerDetailsId;
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

	public void setProviderPhoto(byte[] bs) {
		this.providerPhoto = bs;
	}

	public UUID getServiceId() {
		return serviceId;
	}

	public void setServiceId(UUID serviceId) {
		this.serviceId = serviceId;
	}

	public Timestamp getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	public void setLastUpdatedOn(Timestamp lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}

}
