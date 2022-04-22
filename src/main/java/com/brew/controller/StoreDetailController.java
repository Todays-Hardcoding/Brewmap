package com.brew.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD:src/main/java/com/brew/controller/StoreListDetailController.java
=======
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
>>>>>>> origin/jinho_branch:src/main/java/com/brew/controller/StoreDetailController.java
=======
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
>>>>>>> origin/Jinhwan

import com.brew.domain.StoreInfo;
import com.brew.service.StoreDetailService;
import com.brew.service.StoreInfoService;
<<<<<<< HEAD
=======
import com.brew.service.StoreListService;
>>>>>>> origin/Jinhwan



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
<<<<<<< HEAD
}
=======
}
>>>>>>> origin/Jinhwan
