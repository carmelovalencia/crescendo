package com.crescendo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crescendo.model.Business;
import com.crescendo.repository.BusinessRepository;

@Service
public class BusinessService {
	@Autowired
	private BusinessRepository businessRepository;
	
	@Autowired ReviewService reviewService;
	
	public List<Business> getAllBusiness() {
		List<Business> result = new ArrayList<Business>();
		businessRepository.findAll().forEach(result::add);
	    
		return result;
	}
	
	public Business getBusinessById(int id) {
		Optional<Business> business = businessRepository.findById(id);
		
		return business.isPresent() ? business.get() : null;
	}
	
	public Business saveBusiness(Business business) {
		business = businessRepository.save(business);
		
		return business;
	}
	
	public void deleteBusinessById(Integer id) {
		reviewService.deleteReviewByBusinessId(id);
		
		businessRepository.deleteById(id);
	}
}
