package com.digitmarket.defaultstore.providerservice.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "service_review_comments")
public class ServiceReviewComments implements Serializable {

	/**
	 * This entity is responsible to hold category details
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Type(type = "uuid-char")	
	@Column(name = "review_comments_id")
	private UUID reviewCommentsId;
	
	@Type(type = "uuid-char")	
	@Column(name = "service_id")
	private UUID serviceId;
	
	@Column(name = "review_date")
	private Date reviewDate;	
	
	@Type(type = "uuid-char")	
	@Column(name = "customer_id")
	private UUID customer_id;
	
	@Column(name = "review_rating")
	private Float reviewRating;
	
	@Column(name = "review_comments")
	private Float reviewComments;
	
	@Column(name = "last_updated_on")
	private Timestamp lastUpdatedOn;

	public UUID getReviewCommentsId() {
		return reviewCommentsId;
	}

	public void setReviewCommentsId(UUID reviewCommentsId) {
		this.reviewCommentsId = reviewCommentsId;
	}

	public UUID getServiceId() {
		return serviceId;
	}

	public void setServiceId(UUID serviceId) {
		this.serviceId = serviceId;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public UUID getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(UUID customer_id) {
		this.customer_id = customer_id;
	}

	public Float getReviewRating() {
		return reviewRating;
	}

	public void setReviewRating(Float reviewRating) {
		this.reviewRating = reviewRating;
	}

	public Float getReviewComments() {
		return reviewComments;
	}

	public void setReviewComments(Float reviewComments) {
		this.reviewComments = reviewComments;
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
		result = prime * result + ((customer_id == null) ? 0 : customer_id.hashCode());
		result = prime * result + ((lastUpdatedOn == null) ? 0 : lastUpdatedOn.hashCode());
		result = prime * result + ((reviewComments == null) ? 0 : reviewComments.hashCode());
		result = prime * result + ((reviewCommentsId == null) ? 0 : reviewCommentsId.hashCode());
		result = prime * result + ((reviewDate == null) ? 0 : reviewDate.hashCode());
		result = prime * result + ((reviewRating == null) ? 0 : reviewRating.hashCode());
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
		ServiceReviewComments other = (ServiceReviewComments) obj;
		if (customer_id == null) {
			if (other.customer_id != null)
				return false;
		} else if (!customer_id.equals(other.customer_id))
			return false;
		if (lastUpdatedOn == null) {
			if (other.lastUpdatedOn != null)
				return false;
		} else if (!lastUpdatedOn.equals(other.lastUpdatedOn))
			return false;
		if (reviewComments == null) {
			if (other.reviewComments != null)
				return false;
		} else if (!reviewComments.equals(other.reviewComments))
			return false;
		if (reviewCommentsId == null) {
			if (other.reviewCommentsId != null)
				return false;
		} else if (!reviewCommentsId.equals(other.reviewCommentsId))
			return false;
		if (reviewDate == null) {
			if (other.reviewDate != null)
				return false;
		} else if (!reviewDate.equals(other.reviewDate))
			return false;
		if (reviewRating == null) {
			if (other.reviewRating != null)
				return false;
		} else if (!reviewRating.equals(other.reviewRating))
			return false;
		if (serviceId == null) {
			if (other.serviceId != null)
				return false;
		} else if (!serviceId.equals(other.serviceId))
			return false;
		return true;
	}
}
