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
@Table(name = "product_dependency")
public class ProductDependency implements Serializable {

	/**
	 * This entity is responsible to hold Product Dependency details
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_dependency_id")
	private UUID productDependencyId;

	@Column(name = "dependency_name")
	private String dependencyName;

	@Column(name = "dependency_refrence")
	private String dependencyRefrence;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_product_id", nullable = false)
	private Product product;

	@Column(name = "last_updated_on")
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dependencyName == null) ? 0 : dependencyName.hashCode());
		result = prime * result + ((dependencyRefrence == null) ? 0 : dependencyRefrence.hashCode());
		result = prime * result + ((lastUpdatedOn == null) ? 0 : lastUpdatedOn.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((productDependencyId == null) ? 0 : productDependencyId.hashCode());
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
		ProductDependency other = (ProductDependency) obj;
		if (dependencyName == null) {
			if (other.dependencyName != null)
				return false;
		} else if (!dependencyName.equals(other.dependencyName))
			return false;
		if (dependencyRefrence == null) {
			if (other.dependencyRefrence != null)
				return false;
		} else if (!dependencyRefrence.equals(other.dependencyRefrence))
			return false;
		if (lastUpdatedOn == null) {
			if (other.lastUpdatedOn != null)
				return false;
		} else if (!lastUpdatedOn.equals(other.lastUpdatedOn))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (productDependencyId == null) {
			if (other.productDependencyId != null)
				return false;
		} else if (!productDependencyId.equals(other.productDependencyId))
			return false;
		return true;
	}

}
