package com.digitmarket.defaultstore.vendor.bean;

import java.sql.Timestamp;
import java.util.UUID;

import com.digitmarket.defaultstore.vendor.model.Product;

public class ProductRequirementBean {

	/**
	 * This Bean is responsible to hold product requirements details coming through
	 * form.
	 */

	private UUID productRequirementId;

	private String requirementName;

	private String requirementRefrence;

	private Product product;

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

	public Timestamp getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	public void setLastUpdatedOn(Timestamp lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
