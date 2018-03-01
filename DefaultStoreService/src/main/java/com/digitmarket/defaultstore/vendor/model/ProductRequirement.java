package com.digitmarket.defaultstore.vendor.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "product_requirement")
public class ProductRequirement implements Serializable {

	/**
	 * This entity is responsible to hold Product Requirement details
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_requirement_id")
	private UUID productRequirementId;

	@Column(name = "requirement_name")
	private String requirementName;

	@Column(name = "requirement_refrence")
	private String requirementRefrence;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_product_id", nullable = false)
	private Product product;

	@Column(name = "last_updated_on")
	private Timestamp lastUpdatedOn;

	public UUID getProductRequirementId() {
		return productRequirementId;
	}

	public void setProductRequirementId(UUID productRequirementId) {
		this.productRequirementId = productRequirementId;
	}

	public String getRequirementName() {
		return requirementName;
	}

	public void setRequirementName(String requirementName) {
		this.requirementName = requirementName;
	}

	public String getRequirementRefrence() {
		return requirementRefrence;
	}

	public void setRequirementRefrence(String requirementRefrence) {
		this.requirementRefrence = requirementRefrence;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
