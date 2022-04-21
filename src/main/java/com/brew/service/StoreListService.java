package com.brew.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.brew.domain.StoreInfo;
import com.brew.repository.StoreInfoRepository;

@Service
public class StoreListService {
	
	@Autowired
	private StoreInfoRepository storeInfoRepository;
	
	public Page<StoreInfo> getInfoList(Map<String, String> params, Pageable pageable) {
		return storeInfoRepository.findAllStores(pageable);
	}
	
//	public Page<StoreInfo> getCloseStores(Map<String, String> params, Pageable pageable) {
//		
//		List<StoreInfo> stores = storeInfoRepository.findAll();
//		
//		String lat = params.get("lat");
//		String lon = params.get("lon");
//		
//		double lat = Double.parseDouble(params.get("lat"));
//		double lon = Double.parseDouble(params.get("lon"));
//
//		for (StoreInfo store : stores) {
//			double sLat = store.getStoreLatitude();
//			double sLon = store.getStoreLongitude();
//		}
//			
//		return storeInfoRepository.findCloseStores(lat, lon, pageable);
//	}
}
