package com.digitmarket.defaultstore.config.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class LanguageDTO implements Serializable {

	/**
	 * This DTO is responsible to hold language code details coming from Service
	 */
	private static final long serialVersionUID = 1L;

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
