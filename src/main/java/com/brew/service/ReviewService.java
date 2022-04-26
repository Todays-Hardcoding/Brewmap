package com.brew.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	public Review getByReviewId(long reviewId) {
		return reviewRepository.getByReviewId(reviewId);
	}
	
	public Review saveReview(Review review) {
		return reviewRepository.save(review);
	}
	
	public void deleteByReviewId(long reviewId) {
		reviewRepository.deleteById(reviewId);
	}
	
	public Page<Review> findRecentReview(Pageable pageable) {
		return reviewRepository.findRecentReview(pageable);
	}
}
