package com.brew.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.brew.domain.StoreInfo;
import com.brew.service.StoreInfoService;
import com.brew.service.StoreListService;

@Controller
public class StoreListController {

	@Autowired
	StoreInfoService storeInfoService;
	
	@Autowired
	StoreListService storeListService;
	
	@GetMapping("/storeList") // 내 주변 리스트 검색 후 페이지 이동
    public String returnStoreJoinList(String lat, String lon, Integer page, String radius, Model model) {
		Map<String, String> params = new HashMap<>();
		params.put("lat", lat);
		params.put("lon", lon);
		
		System.out.println(radius);
		System.out.println("====================================================================");
		
		if(radius == null)
			radius = "1";
		
		System.out.println("==================================================");
		
		Map<String, StoreInfo> storeMap = storeListService.getCloseStores(params, radius);	
		List<List<StoreInfo>> storePage = new ArrayList<>();
		List<List<String>> storeDistancePage = new ArrayList<>();
		List<StoreInfo> storeList = new ArrayList<>();
		List<String> storeDistance = new ArrayList<>();
		
		System.out.println("==================================================");
		int i = 0;
		for(Map.Entry<String, StoreInfo> entry : storeMap.entrySet()) {
			if(i == 9) {
				storePage.add(storeList);
				storeDistancePage.add(storeDistance);
				
				storeList = new ArrayList<>();
				storeDistance = new ArrayList<>();
				
				storeList.add(entry.getValue());
				storeDistance.add(entry.getKey());
				i %= 9;
			} else {
				storeList.add(entry.getValue());
				storeDistance.add(entry.getKey());
			}
			i++;
		}
		storePage.add(storeList);
		storeDistancePage.add(storeDistance);
		
		if(page == null)
			page = 0;
		
		System.out.println("==================================================");
		System.out.println(storePage.size());
		System.out.println(storeDistancePage.size());
		
		model.addAttribute("storePage", storePage.get(page));
		model.addAttribute("storeDistancePage", storeDistancePage.get(page));
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", storePage.size());
		model.addAttribute("totalElements", storeMap.size());
		model.addAttribute("latlon", params);
		model.addAttribute("radius", radius);

		return "view/store/storeList";
    }
	
	@GetMapping("/storeListByRate") // 내 주변 리스트 검색 후 페이지 이동
    public String returnStoreListByRate(String lat, String lon, Integer page, String radius, Model model) {
		Map<String, String> params = new HashMap<>();
		params.put("lat", lat);
		params.put("lon", lon);
		
		if(radius == null)
			radius = "1";
		
		List<StoreInfo> storeList = storeListService.getStoresByRate(params, radius);	
		List<List<StoreInfo>> storePage = new ArrayList<>();
		List<StoreInfo> temp = new ArrayList<>();
		
		int i = 0;
		for(StoreInfo store : storeList) {
			if(i == 9) {
				storePage.add(temp);
				
				temp = new ArrayList<>();
				
				temp.add(store);
				i %= 9;
			} else {
				temp.add(store);
			}
			i++;
		}
		storePage.add(temp);
		
		if(page == null)
			page = 0;
		
		model.addAttribute("storePage", storePage.get(page));
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", storePage.size());
		model.addAttribute("latlon", params);
		model.addAttribute("radius", radius);

		return "view/store/storeListByRate";
    }
	
	@GetMapping("/storeListByReview") // 내 주변 리스트 검색 후 페이지 이동
    public String returnStoreListByReview(String lat, String lon, Integer page, String radius, Model model) {
		Map<String, String> params = new HashMap<>();
		params.put("lat", lat);
		params.put("lon", lon);
		
		if(radius == null)
			radius = "1";
		
		List<StoreInfo> storeList = storeListService.getStoresByReview(params, radius);	
		List<List<StoreInfo>> storePage = new ArrayList<>();
		List<StoreInfo> temp = new ArrayList<>();
		
		int i = 0;
		for(StoreInfo store : storeList) {
			if(i == 9) {
				storePage.add(temp);
				
				temp = new ArrayList<>();
				
				temp.add(store);
				i %= 9;
			} else {
				temp.add(store);
			}
			i++;
		}
		storePage.add(temp);
		
		if(page == null)
			page = 0;
		
		model.addAttribute("storePage", storePage.get(page));
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", storePage.size());
		model.addAttribute("latlon", params);
		model.addAttribute("radius", radius);

		return "view/store/storeListByReview";
    }
}