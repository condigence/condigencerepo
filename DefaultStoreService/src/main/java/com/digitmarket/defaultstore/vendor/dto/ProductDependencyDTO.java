package com.digitmarket.defaultstore.vendor.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;


public class ProductDependencyDTO implements Serializable {

	/**
	 * This DTO is responsible to hold entire product Dependency details coming from Service
	 */
	private static final long serialVersionUID = 1L;

	private UUID productDependencyId;

	private String dependencyName;

	private String dependencyRefrence;

	private UUID productId;

	private Timestamp lastUpdatedOn;
	
	public UUID getProductDependencyId() {
		return productDependencyId;
	}

	public void setProductDependencyId(UUID productDependencyId) {
		this.productDependencyId = productDependencyId;
	}

	public String getDependencyName() {
		return dependencyName;
	}

	public void setDependencyName(String dependencyName) {
		this.dependencyName = dependencyName;
	}

	public String getDependencyRefrence() {
		return dependencyRefrence;
	}

	public void setDependencyRefrence(String dependencyRefrence) {
		this.dependencyRefrence = dependencyRefrence;
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
