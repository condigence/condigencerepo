package com.digitmarket.defaultstore.providerservice.bean;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

public class ServiceProviderIdentificationBean {
	
	private UUID serviceIdentificationId;
	
	private String providerIdProof;
	
	private String isVerified;
	
	private UUID serviceDetailsId;
	
	private Timestamp lastUpdatedOn;

	public UUID getServiceIdentificationId() {
		return serviceIdentificationId;
	}

	public void setServiceIdentificationId(UUID serviceIdentificationId) {
		this.serviceIdentificationId = serviceIdentificationId;
	}

	public String getProviderIdProof() {
		return providerIdProof;
	}

	public void setProviderIdProof(String providerIdProof) {
		this.providerIdProof = providerIdProof;
	}

	public String getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(String isVerified) {
		this.isVerified = isVerified;
	}

	public UUID getServiceDetailsId() {
		return serviceDetailsId;
	}

	public void setServiceDetailsId(UUID serviceDetailsId) {
		this.serviceDetailsId = serviceDetailsId;
	}

	public Timestamp getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	public void setLastUpdatedOn(Timestamp lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}

}
