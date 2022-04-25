package com.brew.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
		
	public HashMap<Float, StoreInfo> getCloseStores(Map<String, String> params) {
		
		List<StoreInfo> stores = storeInfoRepository.findAll();
		HashMap<Float, StoreInfo> result = new LinkedHashMap<Float, StoreInfo>();
		HashMap<Double, StoreInfo> storesDistance = new HashMap<Double, StoreInfo>();
		
		System.out.println(params.values());
		
		double lat = Double.parseDouble(params.get("lat"));
		double lon = Double.parseDouble(params.get("lon"));

		for (StoreInfo store : stores) {
			double sLat = store.getStoreLatitude();
			double sLon = store.getStoreLongitude();			
			
			double distance;
		    double radius = 6371; // 지구 반지름(km)
		    double toRadian = Math.PI / 180;

		    double deltaLatitude = Math.abs(lon - sLon) * toRadian;
		    double deltaLongitude = Math.abs(lat - sLat) * toRadian;

		    double sinDeltaLat = Math.sin(deltaLatitude / 2);
		    double sinDeltaLng = Math.sin(deltaLongitude / 2);
		    double squareRoot = Math.sqrt(
		        sinDeltaLat * sinDeltaLat +
		        Math.cos(lon * toRadian) * Math.cos(sLon * toRadian) * sinDeltaLng * sinDeltaLng);

		    distance = 2 * radius * Math.asin(squareRoot);
	        
		    if(distance < 25) {
		        storesDistance.put(distance, store);                
		    }   	
		}
		
		List<Double> keys = new ArrayList<>(storesDistance.keySet());
        Collections.sort(keys);	
        
		for(Double key : keys) {
			result.put(key.floatValue(), storesDistance.get(key));
			System.out.println(key);
			System.out.println(storesDistance.get(key));
		}
		
		return result;
	}
}