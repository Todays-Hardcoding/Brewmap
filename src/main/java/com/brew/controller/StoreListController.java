package com.brew.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String returnStoreJoinList(String lat, String lon, Integer page, Model model) {
		Map<String, String> params = new HashMap<>();
		params.put("lat", lat);
		params.put("lon", lon);
		
		Map<String, StoreInfo> storeMap = storeListService.getCloseStores(params);	
		List<List<StoreInfo>> storePage = new ArrayList<>();
		List<List<String>> storeDistancePage = new ArrayList<>();
		List<StoreInfo> storeList = new ArrayList<>();
		List<String> storeDistance = new ArrayList<>();
		
		int i = 0;
		for(Map.Entry<String, StoreInfo> entry : storeMap.entrySet()) {
			if(i == 10) {
				storePage.add(storeList);
				storeDistancePage.add(storeDistance);
				
				storeList = new ArrayList<>();
				storeDistance = new ArrayList<>();
				
				storeList.add(entry.getValue());
				storeDistance.add(entry.getKey());
				i %= 5;
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
		
		model.addAttribute("storePage", storePage.get(page));
		model.addAttribute("storeDistancePage", storeDistancePage.get(page));
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", storePage.size());
		model.addAttribute("totalElements", storeMap.size());
		model.addAttribute("latlon", params);

		return "view/store/storeList";
    }
	
	
	@GetMapping("/storeListByRate") // 내 주변 리스트 검색 후 페이지 이동
    public String returnStoreListByRate(String lat, String lon, Integer page, Model model) {
		Map<String, String> params = new HashMap<>();
		params.put("lat", lat);
		params.put("lon", lon);
		
		List<StoreInfo> storeList = storeListService.getStoresByRate(params);	
		List<List<StoreInfo>> storePage = new ArrayList<>();
		List<StoreInfo> temp = new ArrayList<>();
		
		int i = 0;
		for(StoreInfo store : storeList) {
			if(i == 9) {
				storePage.add(temp);
				
				temp = new ArrayList<>();
				
				temp.add(store);
				i %= 5;
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

		return "view/store/storeListByRate";
    }
	
	@GetMapping("/storeListByReview") // 내 주변 리스트 검색 후 페이지 이동
    public String returnStoreListByReview(String lat, String lon, Integer page, Model model) {
		Map<String, String> params = new HashMap<>();
		params.put("lat", lat);
		params.put("lon", lon);
		
		List<StoreInfo> storeList = storeListService.getStoresByReview(params);	
		List<List<StoreInfo>> storePage = new ArrayList<>();
		List<StoreInfo> temp = new ArrayList<>();
		
		int i = 0;
		for(StoreInfo store : storeList) {
			if(i == 9) {
				storePage.add(temp);
				
				temp = new ArrayList<>();
				
				temp.add(store);
				i %= 5;
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

		return "view/store/storeListByReview";
    }
	
}