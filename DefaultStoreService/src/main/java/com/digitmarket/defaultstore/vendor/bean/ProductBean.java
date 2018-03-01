package com.digitmarket.defaultstore.vendor.bean;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

public class ProductBean {

	/**
	 * This Bean is responsible to hold product details coming through form.
	 */

	private UUID productId;

	private String productTitle;

	private String productVersion;

	private String productDescription;

	private String productStatus;

	private Timestamp lastUpdatedOn;

	private UUID categoryId;

	private List<ProductDependencyBean> productDependencies;

	private List<ProductRequirementBean> productRequirements;

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

	public UUID getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(UUID categoryId) {
		this.categoryId = categoryId;
	}

	public List<ProductDependencyBean> getProductDependencies() {
		return productDependencies;
	}

	public void setProductDependencies(List<ProductDependencyBean> productDependencies) {
		this.productDependencies = productDependencies;
	}

	public List<ProductRequirementBean> getProductRequirements() {
		return productRequirements;
	}

	public void setProductRequirements(List<ProductRequirementBean> productRequirements) {
		this.productRequirements = productRequirements;
	}

}
