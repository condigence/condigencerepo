package com.digitmarket.defaultstore.config.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "deployment_configuration")
public class DeploymentConfiguration implements Serializable {

	/**
	 * This entity is responsible to hold deployment configuration details
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "store_front_url")
	private String storeFrontURL;

	@Column(name = "store_front_media_url")
	private String storeFrontMediaURL;

	@Column(name = "status")
	private String status;
	
	@Column(name = "last_updated_on")
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lastUpdatedOn == null) ? 0 : lastUpdatedOn.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((storeFrontMediaURL == null) ? 0 : storeFrontMediaURL.hashCode());
		result = prime * result + ((storeFrontURL == null) ? 0 : storeFrontURL.hashCode());
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
		DeploymentConfiguration other = (DeploymentConfiguration) obj;
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
		if (storeFrontMediaURL == null) {
			if (other.storeFrontMediaURL != null)
				return false;
		} else if (!storeFrontMediaURL.equals(other.storeFrontMediaURL))
			return false;
		if (storeFrontURL == null) {
			if (other.storeFrontURL != null)
				return false;
		} else if (!storeFrontURL.equals(other.storeFrontURL))
			return false;
		return true;
	}
	
}
