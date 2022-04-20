package com.brew.controller;

import java.util.List;

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
	
	@GetMapping("/storeList")
    public String returnStoreJoinList(@PageableDefault(page=0, size=5) Pageable pageable, Model model) {
		List<StoreInfo> storeList = storeInfoService.findAllStore();
		Page<StoreInfo> infoList = storeListService.getInfoList(pageable); 
		
		int nowPage = infoList.getPageable().getPageNumber() + 1;
		int startPage = Math.max(nowPage-2, 1);
		int endPage = Math.min(nowPage+2, infoList.getTotalPages());

		model.addAttribute("nowPage", nowPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("storeList", storeList);
		model.addAttribute("infoList", infoList);

		
		return "view/pages/storeList";
    }
	
//	public String search(String keyword, @PageableDefault(page=0, size=5) Pageable pageable, Model model) {
//		if(keyword == null) {
//			keyword = "서울";
//		}
//		
//		Page<StoreInfo> storePage = storeinfoService.findPageByKeyword(keyword, pageable);
//		Page<StoreInfo> storePage2 = storeinfoService.findStorePage(keyword, pageable);
//		List<StoreInfo> storeList = storeinfoService.findListByKeyword(keyword, pageable);
//		List<StoreInfo> storeList2 = storeinfoService.findStoreList(keyword, pageable);
//		List<StoreInfo> storeAll = storeinfoService.findAllStore();
//		
//		int nowPage = storePage.getPageable().getPageNumber() + 1;
//		int startPage = Math.max(nowPage-2, 1);
//		int endPage = Math.min(nowPage+2, storePage.getTotalPages());
//		
//		model.addAttribute("storeAll", storeAll);
//		model.addAttribute("storePage", storePage);
//		model.addAttribute("storeList", storeList);
//		model.addAttribute("storePage2", storePage2);
//		model.addAttribute("storeList2", storeList2);
//		model.addAttribute("keyword", keyword);
//		model.addAttribute("nowPage", nowPage);
//		model.addAttribute("startPage", startPage);
//		model.addAttribute("endPage", endPage);
//		
//		return "/view/pages/map";
//	}
}
