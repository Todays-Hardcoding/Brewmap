package com.brew.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.brew.domain.StoreInfo;
import com.brew.service.StoreDetailService;



@Controller
public class StoreDetailController {

	@Autowired
	StoreDetailService storeDetailService;
	
	@GetMapping("/detail")
    public String returnStoreJoinList(HttpServletResponse response, 
    		@RequestParam Map<String, String> params, Model model) {
		
		System.out.println(params.values());
		
		StoreInfo storeDetail = storeDetailService.findByStoreCode(params);
		 
		model.addAttribute("storeDetail", storeDetail);

		return "view/pages/detail";
    }
}
