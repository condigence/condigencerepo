package com.digitmarket.defaultstore.vendor.bean;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.digitmarket.defaultstore.vendor.model.Product;

public class ProductDependencyBean {

	/**
	 * This Bean is responsible to hold product dependency details coming through form.
	 */

	private UUID productDependencyId;

	private String dependencyName;

	private String dependencyRefrence;		
	
	private Product product;	

	private Timestamp lastUpdatedOn;	

	public UUID getProductDependencyId() {
		return productDependencyId;
	}

	public void setProductDependencyId(UUID productDependencyId) {
		this.productDependencyId = productDependencyId;
	}

	public String getDependencyName() {
		return dependencyName;
	}

	public void setDependencyName(String dependencyName) {
		this.dependencyName = dependencyName;
	}

	public String getDependencyRefrence() {
		return dependencyRefrence;
	}

	public void setDependencyRefrence(String dependencyRefrence) {
		this.dependencyRefrence = dependencyRefrence;
	}

	
	public Timestamp getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	public void setLastUpdatedOn(Timestamp lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}	
	
}
