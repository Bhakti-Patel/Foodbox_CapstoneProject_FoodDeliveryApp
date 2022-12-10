package com.simplilearn.fooddelivery.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


import lombok.Data;

/**
 * @author Bhakti
 *
 */
@Entity
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String name;
	@Column(unique = true)
	private String email;
	private String password;
	private String phone;
	
	
	@OneToMany(cascade = CascadeType.ALL)
   private List<Cuisine_Details> cuisineDetails; 
	
	
	

}
