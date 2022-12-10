package com.simplilearn.fooddelivery.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.fooddelivery.dto.CuisineDetailsDto;
import com.simplilearn.fooddelivery.dto.CuisineDto;
import com.simplilearn.fooddelivery.entity.Cuisine;
import com.simplilearn.fooddelivery.entity.Cuisine_Details;
import com.simplilearn.fooddelivery.repository.CuisineDetailsRepository;
import com.simplilearn.fooddelivery.repository.CuisineRepository;
import com.simplilearn.fooddelivery.service.CuisineService;

@Service
public class CuisineSeviceImpl implements CuisineService {

	
	@Autowired
	CuisineRepository repo;
	
	@Autowired
	CuisineDetailsRepository detailsRepo;
	
	@Override
	public List<CuisineDto> getAllCuisines() {
		// TODO Auto-generated method stub
		//List<Cuisine> list = repo.findAll();
		List<CuisineDto> list = repo.getAll();
		//list.stream().forEach(l -> System.out.println("CUsinse D --> "+ l.toString()));
		return list;
	}

	@Override
	public boolean deleteCuisine(int cuisineId) {
		boolean status=false;
		 System.out.println("Inside Service :: delete");
		// TODO Auto-generated method stub
		 repo.deleteById(cuisineId);
		 status=true;
		 return status;
		 
	}
	
	@Override
	public boolean deleteCuisineItem(int cuisine_details_id) {
		boolean status=false;
		 System.out.println("Inside Service :: deleteCuisineItem");
		// TODO Auto-generated method stub
		 detailsRepo.deleteById(cuisine_details_id);
		 status=true;
		 return status;
		 
	}
	
	

	@Override
	public List<CuisineDetailsDto> getCuisineItems(int cuisineId){
		//Cuisine cuisine = new Cuisine();
		//cuisine.setCuisineId(cuisineId);
	return detailsRepo.getAllItemsByCusineId(cuisineId);
			//findByCuisine(cuisine);
	}
	
	
	
	@Override
	public void updateCuisineItem(Cuisine_Details cuisineItem, int cuisine_details_id) {
		
		System.out.println("Inside Cuisine Service Impl cuisine item id....."+cuisine_details_id);
		Cuisine_Details oldDetails=detailsRepo.findbyCuisineItemId(cuisine_details_id).get();
		System.out.println("Inside Cuisine Service Impl cuisine item oldDetails Price....."+oldDetails);

		oldDetails.setCuisineItemName(cuisineItem.getCuisineItemName());

		oldDetails.setPrice(cuisineItem.getPrice());
		oldDetails.setUrl(cuisineItem.getUrl());

		detailsRepo.save(oldDetails);
		
	}
	
	@Override
	public boolean addCuisineItem(Cuisine_Details cuisineItem,int cuisineId) {
		boolean status=false;
		Cuisine c = repo.getById(cuisineId);
		cuisineItem.setCuisine(c);
		detailsRepo.save(cuisineItem);
		status=true;
		return status;
	}
	
	@Override
	public Optional<Cuisine_Details> getCuisineItemById(int cuisine_details_id){
		
		System.out.println("Inside Cuisine Service Impl getCuisineItemById...");

		
		return detailsRepo.findbyCuisineItemId(cuisine_details_id);
		
	}

	
	

}
