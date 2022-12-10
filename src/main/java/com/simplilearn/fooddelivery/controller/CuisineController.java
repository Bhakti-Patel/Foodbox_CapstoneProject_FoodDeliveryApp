package com.simplilearn.fooddelivery.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.fooddelivery.dto.CuisineDetailsDto;
import com.simplilearn.fooddelivery.dto.CuisineDto;
import com.simplilearn.fooddelivery.entity.Admin;
import com.simplilearn.fooddelivery.entity.Cart;
import com.simplilearn.fooddelivery.entity.Cuisine;
import com.simplilearn.fooddelivery.entity.Cuisine_Details;
import com.simplilearn.fooddelivery.service.CuisineService;

@RestController
@RequestMapping("/cuisines")
@CrossOrigin("http://localhost:4200/")
public class CuisineController {
	
	@Autowired
	CuisineService service;	
	
	@GetMapping("/getAllCuisines")
	public List<CuisineDto> getAllCuisines(){
		return service.getAllCuisines();
			
	}	
	
	@DeleteMapping("/deleteCuisine/{cuisineId}")
	public  boolean deleteCuisine(@PathVariable int cuisineId){
		 System.out.println("Inside controller :: delete");
		return service.deleteCuisine(cuisineId);
		
	}	
	@DeleteMapping("/deleteCuisineItem/{cuisine_details_id}")
	public  boolean deleteCuisineItem(@PathVariable int cuisine_details_id){
		 System.out.println("Inside controller :: deleteCuisineItem");
		return service.deleteCuisineItem(cuisine_details_id);
		
	}	
	
	@GetMapping("/getCuisineItems/{cuisineId}")
	public List<CuisineDetailsDto> getCuisineItems(@PathVariable int cuisineId){
		return service.getCuisineItems(cuisineId);
			
	}	
	
	@PutMapping("/updateCuisineItem/{cuisine_details_id}")
	public void updateCuisineItem(@RequestBody Cuisine_Details cuisineItem, @PathVariable int cuisine_details_id) {
		
		System.out.println("Update Cuisine Item:::Cuisine Item ID:::"+cuisine_details_id);
		service.updateCuisineItem(cuisineItem, cuisine_details_id);
		
	}
	@PostMapping("/addCuisineItem/{cuisineId}")
	public boolean addCuisineItem(@RequestBody Cuisine_Details cd,@PathVariable int cuisineId) {
		
		return service.addCuisineItem(cd,cuisineId);
		
	}
	
	@GetMapping("/getCuisineItemById/{cuisine_details_id}")
	public Optional<Cuisine_Details> getCuisineItemById(@PathVariable int cuisine_details_id){
		System.out.println("Inside Cuisine Controller getCuisineItemById...");
		return service.getCuisineItemById(cuisine_details_id);
			
	}	

}
