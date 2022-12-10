package com.simplilearn.fooddelivery.service;

import java.util.List;
import java.util.Optional;

import com.simplilearn.fooddelivery.dto.CuisineDetailsDto;
import com.simplilearn.fooddelivery.dto.CuisineDto;
import com.simplilearn.fooddelivery.entity.Cart;
import com.simplilearn.fooddelivery.entity.Cuisine_Details;


public interface CuisineService {
	
	public List<CuisineDto> getAllCuisines();
	public boolean deleteCuisine(int cuisineId);
	public boolean deleteCuisineItem(int cuisine_details_id);

	public List<CuisineDetailsDto> getCuisineItems(int cuisineId);
	public void updateCuisineItem(Cuisine_Details cuisineItem,int cuisine_details_id);
	public boolean addCuisineItem(Cuisine_Details cd,int cuisineId);
	
	public Optional<Cuisine_Details> getCuisineItemById(int cuisine_details_id);

	
}
