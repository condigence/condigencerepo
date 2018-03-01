package com.digitmarket.defaultstore.common.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("config")
public class ConfigProperties {

	private String storeID;

	public String getStoreID() {
		return storeID;
	}

	public void setStoreID(String storeID) {
		this.storeID = storeID;
	}

	@Override
	public String toString() {
		return "ConfigProperties [storeID=" + storeID + "]";
	}
}
