package com.digitmarket.defaultstore.providerservice.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Lob;

public class ServiceProviderImageBean implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private byte[] providerPhoto;

	public byte[] getProviderPhoto() {
		return providerPhoto;
	}

	public void setProviderPhoto(byte[] providerPhoto) {
		this.providerPhoto = providerPhoto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
