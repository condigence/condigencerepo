package com.digitmarket.defaultstore.config.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class DeploymentConfigDTO implements Serializable {

	/**
	 * This DTO is responsible to hold deployment configuration details coming from Service
	 */
	private static final long serialVersionUID = 1L;

	private String storeFrontURL;
	
	private String storeFrontMediaURL;
	
	private String status;
	
	private Timestamp lastUpdatedOn;

	public String getStoreFrontURL() {
		return storeFrontURL;
	}

	public void setStoreFrontURL(String storeFrontURL) {
		this.storeFrontURL = storeFrontURL;
	}

	public String getStoreFrontMediaURL() {
		return storeFrontMediaURL;
	}

	public void setStoreFrontMediaURL(String storeFrontMediaURL) {
		this.storeFrontMediaURL = storeFrontMediaURL;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
	
}
