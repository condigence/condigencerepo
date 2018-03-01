package com.digitmarket.defaultstore.providerservice.dto;

import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.digitmarket.defaultstore.vendor.model.Category;

public class ServiceDetailsDTO {

	private UUID serviceId;

	private UUID categoryId;

	private UUID vendorId;

	private String serviceName;
	
	private String serviceStatus;
	
	private Timestamp lastUpdatedOn;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="categoryId",referencedColumnName="categoryId")
	private Set<Category> categories;
	

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public UUID getServiceId() {
		return serviceId;
	}

	public void setServiceId(UUID serviceId) {
		this.serviceId = serviceId;
	}

	public UUID getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(UUID categoryId) {
		this.categoryId = categoryId;
	}

	public UUID getVendorId() {
		return vendorId;
	}

	public void setVendorId(UUID vendorId) {
		this.vendorId = vendorId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Timestamp getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	public void setLastUpdatedOn(Timestamp lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}

	public String getServiceStatus() {
		return serviceStatus;
	}

	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}
}
