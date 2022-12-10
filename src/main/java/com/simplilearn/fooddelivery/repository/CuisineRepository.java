package com.simplilearn.fooddelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.simplilearn.fooddelivery.dto.CuisineDto;
import com.simplilearn.fooddelivery.entity.Cuisine;

@Repository
public interface CuisineRepository extends JpaRepository<Cuisine, Integer>{
	
	@Query(nativeQuery=true)
	List<CuisineDto> getAll();
	
	

}
