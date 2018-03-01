package com.digitmarket.defaultstore.config.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.UUID;

public class StoreConfigDTO implements Serializable {

	/**
	 * This DTO is responsible to hold store configuration details coming from
	 * Service
	 */

	private static final long serialVersionUID = 1L;

	private UUID storeId;

	private String storeName;

	private String storeType;

	private String storeLogo;

	private String[] languages;

	private String[] deplopymentConfig;

	private String[] dbConfig;

	private String authentication;

	private String adminHost;

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

	@Override
	public String toString() {
		return "StoreConfigDTO [storeId=" + storeId + ", storeName=" + storeName + ", storeType=" + storeType
				+ ", storeLogo=" + storeLogo + ", languages=" + Arrays.toString(languages) + ", deplopymentConfig="
				+ Arrays.toString(deplopymentConfig) + ", dbConfig=" + Arrays.toString(dbConfig) + ", authentication="
				+ authentication + ", adminHost=" + adminHost + ", lastUpdatedOn=" + lastUpdatedOn + "]";
	}

}
