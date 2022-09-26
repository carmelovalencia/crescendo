package com.crescendo.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crescendo.model.Business;
import com.crescendo.service.BusinessService;

@RestController
public class BusinessController {

	@Autowired
	private BusinessService businessService;
	
	@RequestMapping(value = "/api/bussiness", method = RequestMethod.GET)
	public List<Business> getAllBusiness() {
		return businessService.getAllBusiness();
	}
	
	@RequestMapping(value = "/api/bussiness/{id}", method = RequestMethod.GET)
	public Business getBusinessById(@RequestParam("id") Integer id) {
		return businessService.getBusinessById(id);
	}
	
	@RequestMapping(value = "/api/bussiness/", method = RequestMethod.POST)
	public Business saveNewBusiness(@RequestBody Business business) {
		business.setId(null);
		
		return businessService.saveBusiness(business);
	}
	
	@RequestMapping(value = "/api/bussiness/", method = RequestMethod.PUT)
	public Business updateBusiness(@RequestBody Business business) {
		if (business.getId() == null) {
			return null;
		}
		
		return businessService.saveBusiness(business);
	}
}
