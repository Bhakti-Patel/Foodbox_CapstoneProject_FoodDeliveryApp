package com.simplilearn.fooddelivery.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.simplilearn.fooddelivery.dto.CuisineDetailsDto;
import com.simplilearn.fooddelivery.entity.Cuisine;
import com.simplilearn.fooddelivery.entity.Cuisine_Details;

@Repository
public interface CuisineDetailsRepository extends JpaRepository<Cuisine_Details, Integer> {

	/*
	 * @Query("select cd from Cuisine_Details cd where cd.cuisine.cuisineId=?1")
	 * List<Cuisine_Details> findAllItemsByCuisineId(Integer cuisineId);
	 */
	
	List<Cuisine_Details> findByCuisine(Cuisine cuisine);
	
	
	  @Query(nativeQuery = true)
	  List<CuisineDetailsDto> getAllItemsByCusineId(Integer  cusineId);
	  
	  @Query("select cuisineDetails from Cuisine_Details cuisineDetails where cuisineDetails.cuisine_details_id=?1")
		Optional<Cuisine_Details> findbyCuisineItemId(int cuisine_details_id);

	  
	  
	 
}
		