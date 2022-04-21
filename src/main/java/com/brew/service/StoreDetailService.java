package com.brew.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.brew.domain.StoreInfo;
import com.brew.repository.StoreInfoRepository;

@Service
public class StoreDetailService {
	
	@Autowired
	private StoreInfoRepository storeInfoRepository;
	
	public StoreInfo findByStoreCode(String storeCode) {
		return storeInfoRepository.findByStoreCode(storeCode);
	}
	
//	List<StoreInfo> findByStoreCode(@Param("storeCode") String storeName);
}
