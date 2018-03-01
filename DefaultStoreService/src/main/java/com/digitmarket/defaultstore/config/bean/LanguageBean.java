package com.digitmarket.defaultstore.config.bean;

import java.sql.Timestamp;

public class LanguageBean {

	/**
	 * This Bean is responsible to hold language code details coming through form.
	 */
	
	private String languageCode;
	
	private Timestamp lastUpdatedOn;

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public Timestamp getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	public void setLastUpdatedOn(Timestamp lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}
	
}
