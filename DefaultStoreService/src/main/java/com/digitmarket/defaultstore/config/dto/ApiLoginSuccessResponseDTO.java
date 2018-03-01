package com.digitmarket.defaultstore.config.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class ApiLoginSuccessResponseDTO implements Serializable {

	/**
	 * This DTO is responsible to hold API login success response details coming from Service
	 */
	private static final long serialVersionUID = 1L;
	
	private String type;
	
	private String message;
	
	private String token;
	
	private Timestamp lastUpdatedOn;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
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
