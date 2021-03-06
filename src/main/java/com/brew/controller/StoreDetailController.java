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
import com.brew.service.StoreInfoService;
import com.brew.service.UserService;

@Controller
public class StoreDetailController {

	@Autowired
	StoreInfoService storeInfoService;
	
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

		return "view/store/storeDetail";
    }
	
	@RequestMapping("/reviewInsert")
	public String reviewInsert(Model model, String storeCode, 
			String userId, String reviewContent, String reviewUser, int reviewStar) {
		User user = userService.findByUserId(userId);
		StoreInfo storeDetail = storeDetailService.findByStoreCode(storeCode);
		Review review = Review.builder().storeInfo(storeDetail).user(user).reviewStar(reviewStar).
				reviewUser(reviewUser).reviewComment(reviewContent).build();
		
		storeInfoService.updateStoreStaravg(storeDetail, reviewStar);
		storeDetailService.saveReview(review);
		
		model.addAttribute("storeDetail", storeDetail);
		
		return "redirect:/detail?id="+storeCode;	
	}
	
	@RequestMapping("/reviewDelete")
	public String reviewDelete(Model model, String storeCode, long reviewId) {		
		storeDetailService.deleteByReviewId(reviewId);

		return "redirect:/detail?id="+storeCode;	
	}
}