package com.crescendo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crescendo.model.Review;
import com.crescendo.repository.ReviewRepository;

@Service
public class ReviewService {
	@Autowired
	private ReviewRepository reviewRepository;
	
	public void deleteReviewByBusinessId(int businessId) {
		reviewRepository.deleteByBusinessId(businessId);
	}
	
	public List<Review> getAllByBusinessId(int businessId) {
		return reviewRepository.findByBusinessId(businessId);
	}
	
	public Review saveReview(Review review) {
		review = reviewRepository.save(review);
		
		return review;
	}
}
