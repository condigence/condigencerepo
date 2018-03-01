package com.digitmarket.defaultstore.config.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class MarketplaceDBConfigDTO implements Serializable {

	/**
	 * This DTO is responsible to hold marketplace database configuration details coming from Service
	 */
	private static final long serialVersionUID = 1L;
	
	private String dbHostName;
	
	private int dbPortNumber;
	
	private String dbName;
	
	private String isSSL;
	
	private String status;
	
	private Timestamp lastUpdatedOn;

	public String getDbHostName() {
		return dbHostName;
	}

	public void setDbHostName(String dbHostName) {
		this.dbHostName = dbHostName;
	}

	public int getDbPortNumber() {
		return dbPortNumber;
	}

	public void setDbPortNumber(int dbPortNumber) {
		this.dbPortNumber = dbPortNumber;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getIsSSL() {
		return isSSL;
	}

	public void setIsSSL(String isSSL) {
		this.isSSL = isSSL;
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
