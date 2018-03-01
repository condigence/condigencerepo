package com.digitmarket.defaultstore.config.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "marketplace_db_configuration")
public class MarketplaceDBConfiguration implements Serializable {

	/**
	 * This entity is responsible to hold marketplace database configuration details
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "db_host_name")
	private String dbHostName;

	@Column(name = "db_port_number")
	private int dbPortNumber;

	@Column(name = "db_name")
	private String dbName;
	
	@Column(name = "is_ssl")
	private String isSSL;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "last_updated_on")
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dbHostName == null) ? 0 : dbHostName.hashCode());
		result = prime * result + ((dbName == null) ? 0 : dbName.hashCode());
		result = prime * result + dbPortNumber;
		result = prime * result + ((isSSL == null) ? 0 : isSSL.hashCode());
		result = prime * result + ((lastUpdatedOn == null) ? 0 : lastUpdatedOn.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MarketplaceDBConfiguration other = (MarketplaceDBConfiguration) obj;
		if (dbHostName == null) {
			if (other.dbHostName != null)
				return false;
		} else if (!dbHostName.equals(other.dbHostName))
			return false;
		if (dbName == null) {
			if (other.dbName != null)
				return false;
		} else if (!dbName.equals(other.dbName))
			return false;
		if (dbPortNumber != other.dbPortNumber)
			return false;
		if (isSSL == null) {
			if (other.isSSL != null)
				return false;
		} else if (!isSSL.equals(other.isSSL))
			return false;
		if (lastUpdatedOn == null) {
			if (other.lastUpdatedOn != null)
				return false;
		} else if (!lastUpdatedOn.equals(other.lastUpdatedOn))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

}
