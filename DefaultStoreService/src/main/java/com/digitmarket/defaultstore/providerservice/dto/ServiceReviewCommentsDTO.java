package com.digitmarket.defaultstore.providerservice.dto;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

public class ServiceReviewCommentsDTO {
	
	private UUID reviewCommentsId;	
	
	private UUID serviceId;	
	
	private Date reviewDate;	
	
	private UUID customer_id;
	
	private Float reviewRating;
	
	private Float reviewComments;
	
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
}
