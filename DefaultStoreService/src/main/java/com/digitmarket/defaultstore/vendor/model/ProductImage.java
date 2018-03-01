package com.digitmarket.defaultstore.vendor.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_image")
public class ProductImage implements Serializable {

	/**
	 * This entity is responsible to hold Product Image details
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_image_id")
	private UUID productImageId;
	
	@Column(name = "image_name")
	private String imageName;

	@Column(name = "image_path")
	private String imagePath;
	
	@Column(name = "fk_product_id")
	private UUID fkProductId;
	
	@Column(name = "last_updated_on")
	private Timestamp lastUpdatedOn;

	public UUID getProductImageId() {
		return productImageId;
	}

	public void setProductImageId(UUID productImageId) {
		this.productImageId = productImageId;
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

	public UUID getFkProductId() {
		return fkProductId;
	}

	public void setFkProductId(UUID fkProductId) {
		this.fkProductId = fkProductId;
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
		result = prime * result + ((fkProductId == null) ? 0 : fkProductId.hashCode());
		result = prime * result + ((imageName == null) ? 0 : imageName.hashCode());
		result = prime * result + ((imagePath == null) ? 0 : imagePath.hashCode());
		result = prime * result + ((lastUpdatedOn == null) ? 0 : lastUpdatedOn.hashCode());
		result = prime * result + ((productImageId == null) ? 0 : productImageId.hashCode());
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
		ProductImage other = (ProductImage) obj;
		if (fkProductId == null) {
			if (other.fkProductId != null)
				return false;
		} else if (!fkProductId.equals(other.fkProductId))
			return false;
		if (imageName == null) {
			if (other.imageName != null)
				return false;
		} else if (!imageName.equals(other.imageName))
			return false;
		if (imagePath == null) {
			if (other.imagePath != null)
				return false;
		} else if (!imagePath.equals(other.imagePath))
			return false;
		if (lastUpdatedOn == null) {
			if (other.lastUpdatedOn != null)
				return false;
		} else if (!lastUpdatedOn.equals(other.lastUpdatedOn))
			return false;
		if (productImageId == null) {
			if (other.productImageId != null)
				return false;
		} else if (!productImageId.equals(other.productImageId))
			return false;
		return true;
	}	
}
