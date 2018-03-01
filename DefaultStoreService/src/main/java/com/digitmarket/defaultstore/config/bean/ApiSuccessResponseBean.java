package com.digitmarket.defaultstore.config.bean;

import java.sql.Timestamp;

public class ApiSuccessResponseBean {

	/**
	 * This Bean is responsible to hold API success response details coming through form.
	 */
	
	private int id;
	
	private String type;
	
	private String message;
	
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

	public Timestamp getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	public void setLastUpdatedOn(Timestamp lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}
	
}
