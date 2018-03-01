package com.digitmarket.defaultstore.config.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "store_configuration")
public class StoreConfiguration implements Serializable {

	/**
	 * This entity is responsible to hold configuration details
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Type(type = "uuid-char")	
	@Column(name = "store_Id")
	private UUID storeId;

	@Column(name = "store_name")
	private String storeName;

	@Column(name = "store_type")
	private String storeType;
	
	@Column(name = "store_logo")
	private String storeLogo;
	
	@Column(name = "languages")
	private String[] languages;
	
	@Column(name = "deplopyment_config")
	private String[] deplopymentConfig;
	
	@Column(name = "db_config")
	private String[] dbConfig;
	
	@Column(name = "authentication")
	private String authentication;
	
	@Column(name = "admin_host")
	private String adminHost;
	
	@Column(name = "last_updated_on")
	private Timestamp lastUpdatedOn;

	public UUID getStoreId() {
		return storeId;
	}

	public void setStoreId(UUID storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreType() {
		return storeType;
	}

	public void setStoreType(String storeType) {
		this.storeType = storeType;
	}

	public String getStoreLogo() {
		return storeLogo;
	}

	public void setStoreLogo(String storeLogo) {
		this.storeLogo = storeLogo;
	}

	public String[] getLanguages() {
		return languages;
	}

	public void setLanguages(String[] languages) {
		this.languages = languages;
	}

	public String[] getDeplopymentConfig() {
		return deplopymentConfig;
	}

	public void setDeplopymentConfig(String[] deplopymentConfig) {
		this.deplopymentConfig = deplopymentConfig;
	}

	public String[] getDbConfig() {
		return dbConfig;
	}

	public void setDbConfig(String[] dbConfig) {
		this.dbConfig = dbConfig;
	}

	public String getAuthentication() {
		return authentication;
	}

	public void setAuthentication(String authentication) {
		this.authentication = authentication;
	}

	public String getAdminHost() {
		return adminHost;
	}

	public void setAdminHost(String adminHost) {
		this.adminHost = adminHost;
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
		result = prime * result + ((adminHost == null) ? 0 : adminHost.hashCode());
		result = prime * result + ((authentication == null) ? 0 : authentication.hashCode());
		result = prime * result + Arrays.hashCode(dbConfig);
		result = prime * result + Arrays.hashCode(deplopymentConfig);
		result = prime * result + Arrays.hashCode(languages);
		result = prime * result + ((lastUpdatedOn == null) ? 0 : lastUpdatedOn.hashCode());
		result = prime * result + ((storeId == null) ? 0 : storeId.hashCode());
		result = prime * result + ((storeLogo == null) ? 0 : storeLogo.hashCode());
		result = prime * result + ((storeName == null) ? 0 : storeName.hashCode());
		result = prime * result + ((storeType == null) ? 0 : storeType.hashCode());
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
		StoreConfiguration other = (StoreConfiguration) obj;
		if (adminHost == null) {
			if (other.adminHost != null)
				return false;
		} else if (!adminHost.equals(other.adminHost))
			return false;
		if (authentication == null) {
			if (other.authentication != null)
				return false;
		} else if (!authentication.equals(other.authentication))
			return false;
		if (!Arrays.equals(dbConfig, other.dbConfig))
			return false;
		if (!Arrays.equals(deplopymentConfig, other.deplopymentConfig))
			return false;
		if (!Arrays.equals(languages, other.languages))
			return false;
		if (lastUpdatedOn == null) {
			if (other.lastUpdatedOn != null)
				return false;
		} else if (!lastUpdatedOn.equals(other.lastUpdatedOn))
			return false;
		if (storeId == null) {
			if (other.storeId != null)
				return false;
		} else if (!storeId.equals(other.storeId))
			return false;
		if (storeLogo == null) {
			if (other.storeLogo != null)
				return false;
		} else if (!storeLogo.equals(other.storeLogo))
			return false;
		if (storeName == null) {
			if (other.storeName != null)
				return false;
		} else if (!storeName.equals(other.storeName))
			return false;
		if (storeType == null) {
			if (other.storeType != null)
				return false;
		} else if (!storeType.equals(other.storeType))
			return false;
		return true;
	}
	
	
}
