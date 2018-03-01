package com.digitmarket.defaultstore.config.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitmarket.defaultstore.config.bean.StoreConfigBean;
import com.digitmarket.defaultstore.config.dto.StoreConfigDTO;
import com.digitmarket.defaultstore.config.model.StoreConfiguration;
import com.digitmarket.defaultstore.config.repository.StoreConfigRepository;


@Service("storeConfigService")
public class StoreConfigServiceImpl implements StoreConfigService {

	@Autowired
	StoreConfigRepository storeConfigRepository;
	
	Timestamp currentTimestamp = new Timestamp(Calendar.getInstance().getTime().getTime());
	
	@Override
	public List<StoreConfigDTO> findAll() {
		List<StoreConfiguration> storeConfigList = (ArrayList<StoreConfiguration>) storeConfigRepository.findAllByOrderByStoreIdDesc();
		List<StoreConfigDTO> storeConfigDTOs = new ArrayList<>();
		for (StoreConfiguration storeConfiguration : storeConfigList) {
			StoreConfigDTO storeConfigDTO = new StoreConfigDTO();
			storeConfigDTO.setStoreId(storeConfiguration.getStoreId());
			storeConfigDTO.setStoreName(storeConfiguration.getStoreName());
			storeConfigDTO.setStoreType(storeConfiguration.getStoreType());
			storeConfigDTO.setStoreLogo(storeConfiguration.getStoreLogo());
			storeConfigDTO.setLanguages(storeConfiguration.getLanguages());
			storeConfigDTO.setDeplopymentConfig(storeConfiguration.getDeplopymentConfig());
			storeConfigDTO.setDbConfig(storeConfiguration.getDbConfig());
			storeConfigDTO.setAuthentication(storeConfiguration.getAuthentication());
			storeConfigDTO.setAdminHost(storeConfiguration.getAdminHost());
			storeConfigDTO.setLastUpdatedOn(storeConfiguration.getLastUpdatedOn());
			storeConfigDTOs.add(storeConfigDTO);
		}
		return storeConfigDTOs;
	}

	@Override
	public StoreConfigDTO saveConfigDetails(StoreConfigBean storeConfigBean) {
		StoreConfiguration storeConfiguration = new StoreConfiguration();
		storeConfiguration.setStoreId(UUID.randomUUID());
		storeConfiguration.setStoreName(storeConfigBean.getStoreName());
		storeConfiguration.setStoreType(storeConfigBean.getStoreType());
		storeConfiguration.setStoreLogo(storeConfigBean.getStoreLogo());
		storeConfiguration.setLanguages(storeConfigBean.getLanguages());
		storeConfiguration.setDeplopymentConfig(storeConfigBean.getDeplopymentConfig());
		storeConfiguration.setDbConfig(storeConfigBean.getDbConfig());
		storeConfiguration.setAuthentication(storeConfigBean.getAuthentication());
		storeConfiguration.setAdminHost(storeConfigBean.getAdminHost());
		storeConfiguration.setLastUpdatedOn(storeConfigBean.getLastUpdatedOn());
		StoreConfiguration saveStoreConfig = storeConfigRepository.save(storeConfiguration);
		StoreConfigDTO storeConfigDTO = new StoreConfigDTO();
		storeConfigDTO.setStoreId(saveStoreConfig.getStoreId());
		System.out.println(storeConfigDTO);
		return storeConfigDTO;
	}

	@Override
	public String deleteStoreConfigDetail(UUID id) {
		storeConfigRepository.delete(id);		
		return "success";
	}

}
