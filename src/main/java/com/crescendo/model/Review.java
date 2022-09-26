package com.crescendo.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String text;
	
	private Integer rating;
	
	private Timestamp createdDateTime;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "business_id", nullable = false)
	private Business business;
}
