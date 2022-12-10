package com.simplilearn.fooddelivery.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.fooddelivery.dto.CartDto;
import com.simplilearn.fooddelivery.entity.Cart;
import com.simplilearn.fooddelivery.entity.Cuisine_Details;
import com.simplilearn.fooddelivery.entity.User;
import com.simplilearn.fooddelivery.repository.CartRepository;
import com.simplilearn.fooddelivery.repository.CuisineDetailsRepository;
import com.simplilearn.fooddelivery.repository.UserRepository;
import com.simplilearn.fooddelivery.service.CartService;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartRepository repo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	CuisineDetailsRepository cuisineDetailsRepo;
	
	@Override
	public Cart addToCart(int cuisine_details_id, int userId) {
		
		
		System.out.println("User ID in CartServiceImpl addtoCart Method..........."+userId);
		User user = userRepo.findById(userId).get();
		Cuisine_Details cd = cuisineDetailsRepo.findById(cuisine_details_id).get();
		Cart cart = new Cart();
		cart.setCuisineDetails(cd);
		cart.setUser(user);
		cart.setQuantity(1);
		cart.setTotalPrice(cart.getQuantity()*cd.getPrice());
		Cart c =repo.save(cart);
		return c;
		
	}

	@Override
	public List<CartDto> getCartData(int userId) {
		
		
		
		return repo.getCartData(userId);
		
		
	}

	@Override
	public boolean deleteCartData(int cartId) {
		
		 System.out.println("Inside CartService :: deleteCartData()");

		
		boolean status=false;
		repo.deleteById(cartId);
		status=true;
		return status;
	}
	
	@Override
	public void updateCart(Cart cart, int cartId) {
		
		Cart oldDetails=repo.findById(cartId).get();
		oldDetails.setQuantity(cart.getQuantity());
		System.out.println("Updated Quantity::::"+cart.getQuantity());
		oldDetails.setTotalPrice(cart.getTotalPrice());
		System.out.println("Updated TotalPrice::::"+cart.getTotalPrice());
		repo.save(oldDetails);
		
	}
	
	

}
