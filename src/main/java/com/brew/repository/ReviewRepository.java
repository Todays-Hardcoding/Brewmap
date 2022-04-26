package com.brew.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.brew.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{

	
	@Query(value="select count(*) from review where review_date >= '2022-04-22' and review_date <= '2022-04-25'", nativeQuery = true)
	int calReviewCount();
	
	// 최근 1주일치 리뷰
	@Query(value="select * from review where review_date between date_add(now(), interval -1 week) and now()", nativeQuery = true)
	Page<Review> findRecentReview(Pageable pageable);
	
	Review getByReviewId(long id);


}
