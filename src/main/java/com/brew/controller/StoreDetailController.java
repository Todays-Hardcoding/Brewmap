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
import com.brew.service.StoreDetailService;
import com.brew.service.StoreInfoService;
import com.brew.service.StoreListService;



@Controller
public class StoreDetailController {

	@Autowired
	StoreDetailService storeDetailService;
	
	@GetMapping("/detail")
    public String returnStoreJoinList(Model model) {
		StoreInfo storeDetail = storeDetailService.findByStoreCode("1011784851");
		 
		model.addAttribute("storeDetail", storeDetail);

		System.out.println(storeDetail.toString());
		return "view/pages/detail";
    }
}
