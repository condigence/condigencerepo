package com.digitmarket.defaultstore.vendor.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

public class ProductDTO implements Serializable {

	/**
	 * This DTO is responsible to hold product details coming from Service
	 */
	private static final long serialVersionUID = 1L;

	private UUID productId;

	private String productTitle;

	private String productVersion;

	private String productDescription;
	
	private String productStatus;

	private Timestamp lastUpdatedOn;

	public UUID getProductId() {
		return productId;
	}

	public void setProductId(UUID productId) {
		this.productId = productId;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public String getProductVersion() {
		return productVersion;
	}

	public void setProductVersion(String productVersion) {
		this.productVersion = productVersion;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
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
