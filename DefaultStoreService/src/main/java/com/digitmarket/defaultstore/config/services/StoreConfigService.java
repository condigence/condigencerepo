package com.digitmarket.defaultstore.config.services;

import java.util.List;
import java.util.UUID;

import com.digitmarket.defaultstore.config.bean.StoreConfigBean;
import com.digitmarket.defaultstore.config.dto.StoreConfigDTO;



public interface StoreConfigService {

	public List<StoreConfigDTO> findAll();

	public StoreConfigDTO saveConfigDetails(StoreConfigBean storeConfigBean);
	
	public String deleteStoreConfigDetail(UUID id);
	
}
