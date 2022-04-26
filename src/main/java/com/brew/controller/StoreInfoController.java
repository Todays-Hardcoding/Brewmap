package com.brew.controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.brew.domain.StoreInfo;
import com.brew.service.StoreInfoService;
import com.brew.service.StoreListService;
import com.brew.service.UserService;

@Controller
public class StoreInfoController {

	@Autowired
	private StoreInfoService storeinfoService;
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private StoreListService storeListService;

	@RequestMapping(value = { "/", "/index" })
	public String index(@PageableDefault(page = 0, size = 5) Pageable pageable, Model model, HttpSession session) {
		
		session.setAttribute("user", userservice.findByUserId("abc"));
		
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

		int nowPage = storePage.getPageable().getPageNumber() + 1;
		int startPage = Math.max(nowPage - 2, 1);
		int endPage = Math.min(nowPage + 2, storePage.getTotalPages());

		model.addAttribute("storePage", storePage);
		model.addAttribute("storeList", storeList);
		model.addAttribute("keyword", keyword);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);

		return "view/map/mapSearch";
	}
	
	@GetMapping("/click")
	public String clickMap(@RequestParam Map<String, String> params, Pageable pageable, Model model) {
		System.out.println(params);
		System.out.println("=====================================================================");
		Map<String, StoreInfo> storeList = storeListService.getCloseStores(params);	

		model.addAttribute("storeList", storeList);

		return "view/map/mapClick";
	}
	
	@PostMapping("/move")
	@ResponseBody
	public Map<String, StoreInfo> moveMap(@RequestBody Map<String, String> params) {
		System.out.println(params);
		System.out.println("=====================================================================");
		
		Map<String, StoreInfo> storeList = storeListService.getCloseStores(params);	
		
		System.out.println(storeList);
		System.out.println("=====================================================================");

		return storeList;
	}
}
