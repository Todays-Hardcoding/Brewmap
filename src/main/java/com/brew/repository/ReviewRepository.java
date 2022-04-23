package com.brew.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.brew.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{
	@Query(value="select count(*) from review where review_date >= '2022-04-22' and review_date <= '2022-04-25'", nativeQuery = true)
	int calReviewCount();
	
	Review getByReviewId(long id);
}
