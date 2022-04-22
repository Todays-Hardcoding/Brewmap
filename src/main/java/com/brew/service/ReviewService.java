package com.brew.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brew.domain.Review;
import com.brew.repository.ReviewRepository;

@Service
public class ReviewService {
	@Autowired
	private ReviewRepository reviewRepository;
	
	public int calReviewCount() {
		return reviewRepository.calReviewCount();
	};
	
	public Review saveReview(Review review) {
		return reviewRepository.save(review);
	}
	
	public Review getByReviewId(long id) {
		return reviewRepository.getByReviewId(id);
	}
}
