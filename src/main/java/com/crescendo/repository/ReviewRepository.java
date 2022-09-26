package com.crescendo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.crescendo.model.Review;

public interface ReviewRepository extends CrudRepository<Review, Integer>{
	public void deleteByBusinessId(Integer id);
	
	public List<Review> findByBusinessId(Integer id);
}
