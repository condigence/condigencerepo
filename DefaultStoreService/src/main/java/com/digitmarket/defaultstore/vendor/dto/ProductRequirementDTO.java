package com.digitmarket.defaultstore.vendor.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;


public class ProductRequirementDTO implements Serializable {

	/**
	 * This DTO is responsible to hold entire product Requirement details coming from Service.
	 */
	private static final long serialVersionUID = 1L;

	private UUID productRequirementId;

	private String requirementName;

	private String requirementRefrence;

	private UUID productId;

	private Timestamp lastUpdatedOn;

	public UUID getProductRequirementId() {
		return productRequirementId;
	}

	public void setProductRequirementId(UUID productRequirementId) {
		this.productRequirementId = productRequirementId;
	}

	public String getRequirementName() {
		return requirementName;
	}

	public void setRequirementName(String requirementName) {
		this.requirementName = requirementName;
	}

	public String getRequirementRefrence() {
		return requirementRefrence;
	}

	public void setRequirementRefrence(String requirementRefrence) {
		this.requirementRefrence = requirementRefrence;
	}

	public UUID getProductId() {
		return productId;
	}

	public void setProductId(UUID productId) {
		this.productId = productId;
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
