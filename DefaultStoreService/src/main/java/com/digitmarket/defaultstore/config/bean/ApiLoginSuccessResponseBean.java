package com.digitmarket.defaultstore.config.bean;

import java.sql.Timestamp;

public class ApiLoginSuccessResponseBean {

	/**
	 * This Bean is responsible to hold API login success response details coming
	 * through form.
	 */

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

}
