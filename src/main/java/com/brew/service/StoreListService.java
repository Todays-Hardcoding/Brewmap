package com.brew.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
		
	public HashMap<String, StoreInfo> getCloseStores(Map<String, String> params) {
		
		List<StoreInfo> stores = storeInfoRepository.findAll();
		HashMap<String, StoreInfo> result = new LinkedHashMap<String, StoreInfo>();
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
	        
		    if(distance < 30) {
		        storesDistance.put(distance, store);                
		    }   	
		}
		
		List<Double> keys = new ArrayList<>(storesDistance.keySet());
        Collections.sort(keys);	
        
		for(Double key : keys) {
			result.put(String.format("%.2f", key.floatValue()), storesDistance.get(key));
			System.out.println(key);
			System.out.println(storesDistance.get(key));
		}
		
		return result;
	}
	
	
//	거리 가져와서 평점순으로 정렬
	public List<StoreInfo> getStoresByRate(Map<String, String> params) {
		
		List<StoreInfo> stores = storeInfoRepository.findAll();
		ArrayList<StoreInfo> result = new ArrayList<StoreInfo>();
		
		
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
		    	result.add(store);                
		    }   	
		}
		
		List<StoreInfo> rateList = new ArrayList<StoreInfo>(result);
		rateList.sort((StoreInfo o1, StoreInfo o2) -> o2.getStoreStaravg().compareTo(o1.getStoreStaravg()));
	    
		
		return rateList;
	}
	
	
//  거리 가져와서 리뷰순으로 분류
	public List<StoreInfo> getStoresByReview(Map<String, String> params) {
		
		List<StoreInfo> stores = storeInfoRepository.findAll();
		ArrayList<StoreInfo> result = new ArrayList<StoreInfo>();
		
		
		System.out.println(params.values());
		
		double lat = Double.parseDouble(params.get("lat"));
		double lon = Double.parseDouble(params.get("lon"));

		for (StoreInfo store : stores) {
			double sLat = store.getStoreLatitude();
			double sLon = store.getStoreLongitude();	
			float sRate = store.getStoreStaravg();
			
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
		    	result.add(store);                
		    }   	
		}
		
		List<StoreInfo> reviewList = new ArrayList<StoreInfo>(result);
		Collections.sort(reviewList, (StoreInfo s1, StoreInfo s2) -> s2.getReview().size() - s1.getReview().size() );
		
		System.out.println(reviewList);
		
	    
		return reviewList;
	}

}