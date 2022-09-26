package com.crescendo.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crescendo.model.Business;
import com.crescendo.model.Review;
import com.crescendo.service.BusinessService;
import com.crescendo.service.ReviewService;

@RestController
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private BusinessService businessService;
	
	@RequestMapping(value = "/api/business/{id}/reviews/", method = RequestMethod.DELETE)
	public void deleteReviewsByBusinessId(@RequestParam("id") Integer id) {
		reviewService.deleteReviewByBusinessId(id);
	}
	
	@RequestMapping(value = "/api/business/{id}/review/", method = RequestMethod.POST)
	public Review addReview(@RequestBody Review review, @RequestParam("id") Integer id) {
		Business business = businessService.getBusinessById(id);
		
		if (business != null) {
			review.setBusiness(business);
			
			return reviewService.saveReview(review);
		}

		return null;
	}
}
