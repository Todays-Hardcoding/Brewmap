package com.brew.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brew.domain.StoreInfo;
import com.brew.service.StoreInfoService;
import com.brew.service.StoreListService;



@Controller
public class StoreListDetailController {

	@Autowired
	StoreInfoService storeInfoService;
	
	@GetMapping("/storeListDetail")
    public String returnStoreJoinList(Model model) {
		List<StoreInfo> storeList = storeInfoService.findAllStore();
		 
		model.addAttribute("storeList", storeList);
		

		return "view/pages/storeListDetail";
    }
	

}
