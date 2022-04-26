package com.brew.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String returnStoreJoinList(@RequestParam Map<String, String> params,
    		@PageableDefault(page=0, size=6) Pageable pageable, Model model) {
		
		System.out.println("controller");
		
		HashMap<String, StoreInfo> infoList = storeListService.getCloseStores(params);
		model.addAttribute("infoList", infoList);

		return "view/store/storeList";
    }
	
	
	@GetMapping("/storeListByRate") // 내 주변 리스트 검색 후 페이지 이동
    public String returnStoreListByRate(HttpServletResponse response, @RequestParam Map<String, String> params,
    		@PageableDefault(page=0, size=6) Pageable pageable, Model model) {
		
		List<StoreInfo> infoList = storeListService.getStoresByRate(params);
		model.addAttribute("infoList", infoList);

		return "view/store/storeListByRate";
    }
	
	@GetMapping("/storeListByReview") // 내 주변 리스트 검색 후 페이지 이동
    public String returnStoreListByReview(HttpServletResponse response, @RequestParam Map<String, String> params,
    		@PageableDefault(page=0, size=6) Pageable pageable, Model model) {
		
		List<StoreInfo> infoList = storeListService.getStoresByReview(params);
		model.addAttribute("infoList", infoList);

		return "view/store/storeListByReview";
    }
	
}