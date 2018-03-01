package com.digitmarket.defaultstore.providerservice.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "service_provider_details")
public class ServiceProviderDetails implements Serializable {

	/**
	 * This entity is responsible to hold category details
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Type(type = "uuid-char")	
	@Column(name = "provider_details_id")
	private UUID providerDetailsId;

	@Column(name = "provider_first_name")
	private String providerFirstName;

	@Column(name = "provider_last_name")
	private String providerLastName;
	
	@Column(name = "provider_middle_name")
	private String providerMiddleName;
	
	@Column(name = "provider_contact_number")
	private String providerContact_Number;
	
	@Column(name = "provider_alternative_contact_number")
	private String providerAlternativeContactNumber;
	
	@Column(name = "provider_home_address")
	private String providerHomeAddress;
	
	@Column(name = "provider_work_address")
	private String providerWorkAddress;
	
	@Column(name = "provider_email")
	private String providerEmail;
	
	@Lob
	@Column(name = "provider_photo")
	private byte[] providerPhoto;
	
	@Type(type = "uuid-char")	
	@Column(name = "service_id")
	private UUID serviceId;
	
	@Column(name = "last_updated_on")
	private Timestamp lastUpdatedOn;

	public UUID getProviderDetailsId() {
		return providerDetailsId;
	}

	public void setProviderDetailsId(UUID providerDetailsId) {
		this.providerDetailsId = providerDetailsId;
	}

	public String getProviderFirstName() {
		return providerFirstName;
	}

	public void setProviderFirstName(String providerFirstName) {
		this.providerFirstName = providerFirstName;
	}

	public String getProviderLastName() {
		return providerLastName;
	}

	public void setProviderLastName(String providerLastName) {
		this.providerLastName = providerLastName;
	}

	public String getProviderMiddleName() {
		return providerMiddleName;
	}

	public void setProviderMiddleName(String providerMiddleName) {
		this.providerMiddleName = providerMiddleName;
	}

	public String getProviderContact_Number() {
		return providerContact_Number;
	}

	public void setProviderContact_Number(String providerContact_Number) {
		this.providerContact_Number = providerContact_Number;
	}

	public String getProviderAlternativeContactNumber() {
		return providerAlternativeContactNumber;
	}

	public void setProviderAlternativeContactNumber(String providerAlternativeContactNumber) {
		this.providerAlternativeContactNumber = providerAlternativeContactNumber;
	}

	public String getProviderHomeAddress() {
		return providerHomeAddress;
	}

	public void setProviderHomeAddress(String providerHomeAddress) {
		this.providerHomeAddress = providerHomeAddress;
	}

	public String getProviderWorkAddress() {
		return providerWorkAddress;
	}

	public void setProviderWorkAddress(String providerWorkAddress) {
		this.providerWorkAddress = providerWorkAddress;
	}

	public String getProviderEmail() {
		return providerEmail;
	}

	public void setProviderEmail(String providerEmail) {
		this.providerEmail = providerEmail;
	}

	public byte[] getProviderPhoto() {
		return providerPhoto;
	}

	public void setProviderPhoto(byte[] bs) {
		this.providerPhoto = bs;
	}

	public UUID getServiceId() {
		return serviceId;
	}

	public void setServiceId(UUID serviceId) {
		this.serviceId = serviceId;
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
		result = prime * result
				+ ((providerAlternativeContactNumber == null) ? 0 : providerAlternativeContactNumber.hashCode());
		result = prime * result + ((providerContact_Number == null) ? 0 : providerContact_Number.hashCode());
		result = prime * result + ((providerDetailsId == null) ? 0 : providerDetailsId.hashCode());
		result = prime * result + ((providerEmail == null) ? 0 : providerEmail.hashCode());
		result = prime * result + ((providerFirstName == null) ? 0 : providerFirstName.hashCode());
		result = prime * result + ((providerHomeAddress == null) ? 0 : providerHomeAddress.hashCode());
		result = prime * result + ((providerLastName == null) ? 0 : providerLastName.hashCode());
		result = prime * result + ((providerMiddleName == null) ? 0 : providerMiddleName.hashCode());
		result = prime * result + Arrays.hashCode(providerPhoto);
		result = prime * result + ((providerWorkAddress == null) ? 0 : providerWorkAddress.hashCode());
		result = prime * result + ((serviceId == null) ? 0 : serviceId.hashCode());
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
		ServiceProviderDetails other = (ServiceProviderDetails) obj;
		if (lastUpdatedOn == null) {
			if (other.lastUpdatedOn != null)
				return false;
		} else if (!lastUpdatedOn.equals(other.lastUpdatedOn))
			return false;
		if (providerAlternativeContactNumber == null) {
			if (other.providerAlternativeContactNumber != null)
				return false;
		} else if (!providerAlternativeContactNumber.equals(other.providerAlternativeContactNumber))
			return false;
		if (providerContact_Number == null) {
			if (other.providerContact_Number != null)
				return false;
		} else if (!providerContact_Number.equals(other.providerContact_Number))
			return false;
		if (providerDetailsId == null) {
			if (other.providerDetailsId != null)
				return false;
		} else if (!providerDetailsId.equals(other.providerDetailsId))
			return false;
		if (providerEmail == null) {
			if (other.providerEmail != null)
				return false;
		} else if (!providerEmail.equals(other.providerEmail))
			return false;
		if (providerFirstName == null) {
			if (other.providerFirstName != null)
				return false;
		} else if (!providerFirstName.equals(other.providerFirstName))
			return false;
		if (providerHomeAddress == null) {
			if (other.providerHomeAddress != null)
				return false;
		} else if (!providerHomeAddress.equals(other.providerHomeAddress))
			return false;
		if (providerLastName == null) {
			if (other.providerLastName != null)
				return false;
		} else if (!providerLastName.equals(other.providerLastName))
			return false;
		if (providerMiddleName == null) {
			if (other.providerMiddleName != null)
				return false;
		} else if (!providerMiddleName.equals(other.providerMiddleName))
			return false;
		if (!Arrays.equals(providerPhoto, other.providerPhoto))
			return false;
		if (providerWorkAddress == null) {
			if (other.providerWorkAddress != null)
				return false;
		} else if (!providerWorkAddress.equals(other.providerWorkAddress))
			return false;
		if (serviceId == null) {
			if (other.serviceId != null)
				return false;
		} else if (!serviceId.equals(other.serviceId))
			return false;
		return true;
	}
}
