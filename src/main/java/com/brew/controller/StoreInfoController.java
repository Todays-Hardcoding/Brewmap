package com.brew.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brew.domain.StoreInfo;
import com.brew.service.StoreInfoService;
import com.brew.service.StoreListService;

@Controller
public class StoreInfoController {

	@Autowired
	private StoreInfoService storeinfoService;
	
	
	@Autowired
	private StoreListService storeListService;

	@RequestMapping(value = { "/", "/index" })
	public String index(@PageableDefault(page = 0, size = 5) Pageable pageable, Model model, HttpSession session) {
		
		Page<StoreInfo> storePage = storeinfoService.findHotStores(pageable);

		model.addAttribute("storePage", storePage);
		
		return "view/index";
	}

	@GetMapping("/map")
	public String searchMap(String keyword, @PageableDefault(page = 0, size = 5) Pageable pageable, Model model) {
		if (keyword == null) {
			keyword = "강남";
		}

		Page<StoreInfo> storePage = storeinfoService.findPageByKeyword(keyword, pageable);
		List<StoreInfo> storeList = storeinfoService.findListByKeyword(keyword, pageable);

		model.addAttribute("storePage", storePage);
		model.addAttribute("storeList", storeList);
		model.addAttribute("keyword", keyword);

		int totalPages = storePage.getTotalPages();
		// 시각적인 현재 페이지
		int nowPage = storePage.getPageable().getPageNumber()+1;
		// 시각적인 맨 첫 페이지, 맨 끝 페이지
		int startPage = 1;
		int endPage = storePage.getTotalPages();
		if(endPage == 0)
			endPage = 1;
		// 10페이지 단위로 나눌 예정.
		int currentStart = (nowPage/10)*10 + 1;
		int	currentLast = currentStart + 9 < totalPages ? currentStart + 9 : totalPages;
		if(currentLast == 0) {
			currentLast = 1;
		}
		
		model.addAttribute("list", storePage);

		model.addAttribute("list", storePage);
		model.addAttribute("boardTotalPages", totalPages);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("currentStart", currentStart);
		model.addAttribute("currentLast", currentLast);

		return "view/map/mapSearch";
	}
	
	@GetMapping("/click")
	public String clickMap(String lat, String lon, Integer page, Model model) {
		Map<String, String> params = new HashMap<>();
		params.put("lat", lat);
		params.put("lon", lon);
		
		Map<String, StoreInfo> storeMap = storeListService.getCloseStores(params);	
		List<List<StoreInfo>> storePage = new ArrayList<>();
		List<StoreInfo> storeList = new ArrayList<>();
		
		int i = 0;
		for(Map.Entry<String, StoreInfo> entry : storeMap.entrySet()) {
			if(i == 5) {
				storePage.add(storeList);
				storeList = new ArrayList<>();
				storeList.add(entry.getValue());
				i %= 5;
			} else {
				storeList.add(entry.getValue());
			}
			i++;
		}
		storePage.add(storeList);
		if(page == null)
			page = 0;
		
		model.addAttribute("storePage", storePage.get(page));
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", storePage.size());
		model.addAttribute("totalElements", storeMap.size());
		model.addAttribute("latlon", params);
		
		return "view/map/mapClick";
	}
	
}