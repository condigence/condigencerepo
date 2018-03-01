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
@Table(name = "product_feature_detail")
public class ProductFeatureDetail implements Serializable {

	/**
	 * This entity is responsible to hold Product Feature details
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_feature_detail_id")
	private UUID productFeatureDetailId;
	
	@Column(name = "feature_heading")
	private String featureHeading;

	@Column(name = "feature_status")
	private String featureStatus;
	
	@Column(name = "feature_content")
	private String featureContent;
	
	@Column(name = "fk_product_id")
	private UUID productId;
	
	@Column(name = "fk_content_format_id")
	private UUID contentFormatId;
	
	@Column(name = "last_updated_on")
	private Timestamp lastUpdatedOn;

	public UUID getProductFeatureDetailId() {
		return productFeatureDetailId;
	}

	public void setProductFeatureDetailId(UUID productFeatureDetailId) {
		this.productFeatureDetailId = productFeatureDetailId;
	}

	public String getFeatureHeading() {
		return featureHeading;
	}

	public void setFeatureHeading(String featureHeading) {
		this.featureHeading = featureHeading;
	}

	public String getFeatureStatus() {
		return featureStatus;
	}

	public void setFeatureStatus(String featureStatus) {
		this.featureStatus = featureStatus;
	}

	public String getFeatureContent() {
		return featureContent;
	}

	public void setFeatureContent(String featureContent) {
		this.featureContent = featureContent;
	}

	public UUID getProductId() {
		return productId;
	}

	public void setProductId(UUID productId) {
		this.productId = productId;
	}

	public UUID getContentFormatId() {
		return contentFormatId;
	}

	public void setContentFormatId(UUID contentFormatId) {
		this.contentFormatId = contentFormatId;
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
		result = prime * result + ((contentFormatId == null) ? 0 : contentFormatId.hashCode());
		result = prime * result + ((featureContent == null) ? 0 : featureContent.hashCode());
		result = prime * result + ((featureHeading == null) ? 0 : featureHeading.hashCode());
		result = prime * result + ((featureStatus == null) ? 0 : featureStatus.hashCode());
		result = prime * result + ((lastUpdatedOn == null) ? 0 : lastUpdatedOn.hashCode());
		result = prime * result + ((productFeatureDetailId == null) ? 0 : productFeatureDetailId.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
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
		ProductFeatureDetail other = (ProductFeatureDetail) obj;
		if (contentFormatId == null) {
			if (other.contentFormatId != null)
				return false;
		} else if (!contentFormatId.equals(other.contentFormatId))
			return false;
		if (featureContent == null) {
			if (other.featureContent != null)
				return false;
		} else if (!featureContent.equals(other.featureContent))
			return false;
		if (featureHeading == null) {
			if (other.featureHeading != null)
				return false;
		} else if (!featureHeading.equals(other.featureHeading))
			return false;
		if (featureStatus == null) {
			if (other.featureStatus != null)
				return false;
		} else if (!featureStatus.equals(other.featureStatus))
			return false;
		if (lastUpdatedOn == null) {
			if (other.lastUpdatedOn != null)
				return false;
		} else if (!lastUpdatedOn.equals(other.lastUpdatedOn))
			return false;
		if (productFeatureDetailId == null) {
			if (other.productFeatureDetailId != null)
				return false;
		} else if (!productFeatureDetailId.equals(other.productFeatureDetailId))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		return true;
	}
	
}
