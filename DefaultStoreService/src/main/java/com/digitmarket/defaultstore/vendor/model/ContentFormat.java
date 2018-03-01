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
@Table(name = "content_format")
public class ContentFormat implements Serializable {

	/**
	 * This entity is responsible to hold Content Format details
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "content_format_id")
	private UUID contentFormatId;
	
	@Column(name = "content_type")
	private String contentType;

	@Column(name = "content_template")
	private String contentTemplate;
	
	@Column(name = "last_updated_on")
	private Timestamp lastUpdatedOn;

	public UUID getContentFormatId() {
		return contentFormatId;
	}

	public void setContentFormatId(UUID contentFormatId) {
		this.contentFormatId = contentFormatId;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getContentTemplate() {
		return contentTemplate;
	}

	public void setContentTemplate(String contentTemplate) {
		this.contentTemplate = contentTemplate;
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
		result = prime * result + ((contentTemplate == null) ? 0 : contentTemplate.hashCode());
		result = prime * result + ((contentType == null) ? 0 : contentType.hashCode());
		result = prime * result + ((lastUpdatedOn == null) ? 0 : lastUpdatedOn.hashCode());
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
		ContentFormat other = (ContentFormat) obj;
		if (contentFormatId == null) {
			if (other.contentFormatId != null)
				return false;
		} else if (!contentFormatId.equals(other.contentFormatId))
			return false;
		if (contentTemplate == null) {
			if (other.contentTemplate != null)
				return false;
		} else if (!contentTemplate.equals(other.contentTemplate))
			return false;
		if (contentType == null) {
			if (other.contentType != null)
				return false;
		} else if (!contentType.equals(other.contentType))
			return false;
		if (lastUpdatedOn == null) {
			if (other.lastUpdatedOn != null)
				return false;
		} else if (!lastUpdatedOn.equals(other.lastUpdatedOn))
			return false;
		return true;
	}	
	
}
