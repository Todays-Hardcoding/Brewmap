package com.brew.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brew.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, String>{

}
