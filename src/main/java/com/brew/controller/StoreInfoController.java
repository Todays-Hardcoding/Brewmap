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

@Controller
public class StoreInfoController {

	@Autowired
	private StoreInfoService storeinfoService;

	@RequestMapping(value = {"/", "/index"})
	public String index(@PageableDefault(page=0, size=5) Pageable pageable, Model model) {
		Page<StoreInfo> storePage = storeinfoService.findPageByKeyword("서울", pageable);
		Page<StoreInfo> storePage2 = storeinfoService.findStorePage("서울", pageable);
		List<StoreInfo> storeList = storeinfoService.findListByKeyword("서울", pageable);
		List<StoreInfo> storeList2 = storeinfoService.findStoreList("서울", pageable);
		List<StoreInfo> storeAll = storeinfoService.findAllStore();
		
		int nowPage = storePage.getPageable().getPageNumber() + 1;
		int startPage = Math.max(nowPage-2, 1);
		int endPage = Math.min(nowPage+2, storePage.getTotalPages());
		
		model.addAttribute("storeAll", storeAll);
		model.addAttribute("storePage", storePage);
		model.addAttribute("storeList", storeList);
		model.addAttribute("storePage2", storePage2);
		model.addAttribute("storeList2", storeList2);
		model.addAttribute("keyword", "서울");
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		return "view/index";
	}
	
	@GetMapping("/map")
	public String search(String keyword, @PageableDefault(page=0, size=5) Pageable pageable, Model model) {
		if(keyword == null) {
			keyword = "서울";
		}
		
		Page<StoreInfo> storePage = storeinfoService.findPageByKeyword(keyword, pageable);
		Page<StoreInfo> storePage2 = storeinfoService.findStorePage(keyword, pageable);
		List<StoreInfo> storeList = storeinfoService.findListByKeyword(keyword, pageable);
		List<StoreInfo> storeList2 = storeinfoService.findStoreList(keyword, pageable);
		List<StoreInfo> storeAll = storeinfoService.findAllStore();
		
		int nowPage = storePage.getPageable().getPageNumber() + 1;
		int startPage = Math.max(nowPage-2, 1);
		int endPage = Math.min(nowPage+2, storePage.getTotalPages());
		
		model.addAttribute("storeAll", storeAll);
		model.addAttribute("storePage", storePage);
		model.addAttribute("storeList", storeList);
		model.addAttribute("storePage2", storePage2);
		model.addAttribute("storeList2", storeList2);
		model.addAttribute("keyword", keyword);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		
		return "view/pages/map";
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> origin/jinho_branch
	}
	
	@GetMapping("/sendPosition")
	public @ResponseBody void ajax(@RequestParam Map<String, String> map) {
		System.out.println(map.get("lat"));
		System.out.println(map.get("lon"));
>>>>>>> b04688406cbb5887a7b197ed36338b6c9c9dfffe
=======
>>>>>>> origin/woo
	}

}
