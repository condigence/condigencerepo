package com.digitmarket.defaultstore.vendor.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

public class ProductImageBean implements Serializable {

	/**
	 * This Bean is responsible to hold product Image details coming through form.
	 */
	private static final long serialVersionUID = 1L;

	private UUID productIimageId;

	private UUID productId;

	private String imageName;

	private String imagePath;
	
	private Timestamp lastUpdatedOn;

	public UUID getProductIimageId() {
		return productIimageId;
	}

	public void setProductIimageId(UUID productIimageId) {
		this.productIimageId = productIimageId;
	}

	public UUID getProductId() {
		return productId;
	}

	public void setProductId(UUID productId) {
		this.productId = productId;
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
