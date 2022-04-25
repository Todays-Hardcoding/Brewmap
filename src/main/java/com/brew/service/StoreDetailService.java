package com.brew.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.brew.domain.Board;
import com.brew.domain.Review;
import com.brew.domain.StoreInfo;
import com.brew.repository.ReviewRepository;
import com.brew.repository.StoreInfoRepository;

@Service
public class StoreDetailService {
	
	@Autowired
	private StoreInfoRepository storeInfoRepository;
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	public StoreInfo findByStoreCode(Map<String, String> storeCode) {
		return storeInfoRepository.findByStoreCode(storeCode.get("id"));
	}
	
	public StoreInfo findByStoreCode(String storeCode) {
		return storeInfoRepository.findByStoreCode(storeCode);
	}
	
	public Review saveReview(Review review) {
		System.out.println(review.toString());
		return reviewRepository.save(review);
	}
	
	public void deleteByReviewId(long reviewId) {
		reviewRepository.deleteById(reviewId);
	}
}