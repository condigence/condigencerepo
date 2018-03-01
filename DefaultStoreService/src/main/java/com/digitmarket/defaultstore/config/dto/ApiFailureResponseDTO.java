package com.digitmarket.defaultstore.config.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class ApiFailureResponseDTO implements Serializable {

	/**
	 * This DTO is responsible to hold API failure response details coming from Service
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	
	private String type;
	
	private String message;
	
	private String details;
	
	private Timestamp lastUpdatedOn;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
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
