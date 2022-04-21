package com.brew.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.brew.domain.StoreInfo;
import com.brew.service.StoreInfoService;
import com.brew.service.StoreListService;



@Controller
//@RequestMapping("/store")
public class StoreListController {

//	@RequestMapping("/storeList")
//	public String storeListnav() {
//		return "view/pages/storeList";
//	}
	@Autowired
	StoreInfoService storeInfoService;
	
	@Autowired
	StoreListService storeListService;
	
	List<StoreInfo> infoList;
	
	@GetMapping("/storeList") // 내 주변 리스트 검색 후 페이지 이동
    public String returnStoreJoinList(HttpServletResponse response, @RequestParam Map<String, String> params,
    		@PageableDefault(page=0, size=6) Pageable pageable, Model model) {
		
		List<StoreInfo> infoList = null;
		if(this.infoList.size() == 0)
			infoList = storeListService.getCloseStores(params); 
		else
			infoList = this.infoList;
		
		model.addAttribute("infoList", infoList);

		return "view/pages/storeList";
    }
	
	@GetMapping("/latlon") // 내 주변 리스트 검색
	@ResponseBody
	public void returnLatlon(HttpServletResponse response, @RequestParam Map<String, String> params) {	
		infoList = storeListService.getCloseStores(params);
	}
}
