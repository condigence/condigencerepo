package com.digitmarket.defaultstore.providerservice.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "service_provider_identification")
public class ServiceProviderIdentification implements Serializable {

	/**
	 * This entity is responsible to hold category details
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Type(type = "uuid-char")	
	@Column(name = "service_identification_id")
	private UUID serviceIdentificationId;

	@Type(type = "uuid-char")	
	@Column(name = "provider_id_proof")
	private String providerIdProof;

	@Column(name = "isVerified")
	private String isVerified;
	
	@Type(type = "uuid-char")	
	@Column(name = "service_details_id")
	private UUID serviceDetailsId;
	
	@Column(name = "last_updated_on")
	private Timestamp lastUpdatedOn;

	public UUID getServiceIdentificationId() {
		return serviceIdentificationId;
	}

	public void setServiceIdentificationId(UUID serviceIdentificationId) {
		this.serviceIdentificationId = serviceIdentificationId;
	}

	public String getProviderIdProof() {
		return providerIdProof;
	}

	public void setProviderIdProof(String providerIdProof) {
		this.providerIdProof = providerIdProof;
	}

	public String getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(String isVerified) {
		this.isVerified = isVerified;
	}

	public UUID getServiceDetailsId() {
		return serviceDetailsId;
	}

	public void setServiceDetailsId(UUID serviceDetailsId) {
		this.serviceDetailsId = serviceDetailsId;
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
		result = prime * result + ((isVerified == null) ? 0 : isVerified.hashCode());
		result = prime * result + ((lastUpdatedOn == null) ? 0 : lastUpdatedOn.hashCode());
		result = prime * result + ((providerIdProof == null) ? 0 : providerIdProof.hashCode());
		result = prime * result + ((serviceDetailsId == null) ? 0 : serviceDetailsId.hashCode());
		result = prime * result + ((serviceIdentificationId == null) ? 0 : serviceIdentificationId.hashCode());
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
		ServiceProviderIdentification other = (ServiceProviderIdentification) obj;
		if (isVerified == null) {
			if (other.isVerified != null)
				return false;
		} else if (!isVerified.equals(other.isVerified))
			return false;
		if (lastUpdatedOn == null) {
			if (other.lastUpdatedOn != null)
				return false;
		} else if (!lastUpdatedOn.equals(other.lastUpdatedOn))
			return false;
		if (providerIdProof == null) {
			if (other.providerIdProof != null)
				return false;
		} else if (!providerIdProof.equals(other.providerIdProof))
			return false;
		if (serviceDetailsId == null) {
			if (other.serviceDetailsId != null)
				return false;
		} else if (!serviceDetailsId.equals(other.serviceDetailsId))
			return false;
		if (serviceIdentificationId == null) {
			if (other.serviceIdentificationId != null)
				return false;
		} else if (!serviceIdentificationId.equals(other.serviceIdentificationId))
			return false;
		return true;
	}
}
