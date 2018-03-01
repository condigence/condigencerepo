package com.digitmarket.defaultstore.vendor.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;


public class ProductImageDTO implements Serializable {

	/**
	 * This DTO is responsible to hold entire product Image details coming from Service
	 */
	private static final long serialVersionUID = 1L;
	
	private UUID productIimageId;

	private UUID fkProductId;

	private String imageName;

	private String imagePath;
	
	private Timestamp lastUpdatedOn;

	public UUID getProductIimageId() {
		return productIimageId;
	}

	public void setProductIimageId(UUID productIimageId) {
		this.productIimageId = productIimageId;
	}

	public UUID getFkProductId() {
		return fkProductId;
	}

	public void setFkProductId(UUID fkProductId) {
		this.fkProductId = fkProductId;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
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
