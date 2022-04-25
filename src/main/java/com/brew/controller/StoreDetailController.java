package com.brew.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.brew.domain.Review;
import com.brew.domain.StoreInfo;
import com.brew.domain.User;
import com.brew.service.StoreDetailService;
import com.brew.service.UserService;



@Controller
public class StoreDetailController {

	@Autowired
	StoreDetailService storeDetailService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/detail")
    public String returnStoreJoinList(HttpServletResponse response, 
    		@RequestParam Map<String, String> params, Model model) {
		
		System.out.println(params.values());
		
		StoreInfo storeDetail = storeDetailService.findByStoreCode(params);
		 
		model.addAttribute("storeDetail", storeDetail);

		return "view/pages/detail";
    }
	
	@RequestMapping("/reviewInsert")
	public String replyInsert(Model model, String storeCode, 
			String userId, String reviewContent, int reviewStar) {
		System.out.println(storeCode);
		System.out.println(reviewContent);
		
		User user = userService.findByUserId(userId);
		StoreInfo storeDetail = storeDetailService.findByStoreCode(storeCode);
		
		Review review = Review.builder().storeInfo(storeDetail).user(user).reviewStar(reviewStar).
				reviewComment(reviewContent).build();
		storeDetailService.saveReview(review);
		
		model.addAttribute("storeDetail", storeDetail);
		
		return "redirect:?storeCode="+storeCode;	
	}

}