package com.brew.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.brew.domain.StoreInfo;
import com.brew.repository.StoreInfoRepository;

@Service
public class StoreDetailService {
	
	@Autowired
	private StoreInfoRepository storeInfoRepository;
	
	public StoreInfo findByStoreCode(Map<String, String> storeCode) {
		return storeInfoRepository.findByStoreCode(storeCode.get("id"));
	}
	
//	List<StoreInfo> findByStoreCode(@Param("storeCode") String storeName);
}