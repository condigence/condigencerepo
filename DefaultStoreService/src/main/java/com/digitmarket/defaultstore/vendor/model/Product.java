package com.digitmarket.defaultstore.vendor.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "product")
public class Product implements Serializable {

	/**
	 * This entity is responsible to hold product details
	 */

	private static final long serialVersionUID = 5206590652556013535L;

	public Product() {
		super();
	}

	public Product(UUID productId, String productTitle, String productVersion, String productDescription,
			String productStatus, Timestamp lastUpdatedOn) {
		super();
		this.productId = productId;
		this.productTitle = productTitle;
		this.productVersion = productVersion;
		this.productDescription = productDescription;
		this.productStatus = productStatus;
		this.lastUpdatedOn = lastUpdatedOn;
	}

	@Id
	@Type(type = "uuid-char")
	@Column(name = "product_id")
	private UUID productId;

	@Column(name = "product_title")
	private String productTitle;

	@Column(name = "product_version")
	private String productVersion;

	@Column(name = "product_description")
	private String productDescription;

	@Column(name = "product_status")
	private String productStatus;

	@Column(name = "last_updated_on")
	private Timestamp lastUpdatedOn;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
	Set<ProductRequirement> requirements = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
	Set<ProductDependency> dependencies = new HashSet<>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "product_category", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Category> categories;

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

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public Set<ProductDependency> getDependencies() {
		return dependencies;
	}

	public void setDependencies(Set<ProductDependency> dependencies) {
		this.dependencies = dependencies;
	}

	public Set<ProductRequirement> getRequirements() {
		return requirements;
	}

	public void setRequirements(Set<ProductRequirement> requirements) {
		this.requirements = requirements;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lastUpdatedOn == null) ? 0 : lastUpdatedOn.hashCode());
		result = prime * result + ((productDescription == null) ? 0 : productDescription.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((productStatus == null) ? 0 : productStatus.hashCode());
		result = prime * result + ((productTitle == null) ? 0 : productTitle.hashCode());
		result = prime * result + ((productVersion == null) ? 0 : productVersion.hashCode());
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
		Product other = (Product) obj;
		if (lastUpdatedOn == null) {
			if (other.lastUpdatedOn != null)
				return false;
		} else if (!lastUpdatedOn.equals(other.lastUpdatedOn))
			return false;
		if (productDescription == null) {
			if (other.productDescription != null)
				return false;
		} else if (!productDescription.equals(other.productDescription))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productStatus == null) {
			if (other.productStatus != null)
				return false;
		} else if (!productStatus.equals(other.productStatus))
			return false;
		if (productTitle == null) {
			if (other.productTitle != null)
				return false;
		} else if (!productTitle.equals(other.productTitle))
			return false;
		if (productVersion == null) {
			if (other.productVersion != null)
				return false;
		} else if (!productVersion.equals(other.productVersion))
			return false;
		return true;
	}
}
