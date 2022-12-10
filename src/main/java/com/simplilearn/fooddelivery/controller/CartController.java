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

import com.simplilearn.fooddelivery.dto.CartDto;
import com.simplilearn.fooddelivery.entity.Cart;
import com.simplilearn.fooddelivery.service.CartService;

@RestController
@RequestMapping("/cart")
@CrossOrigin("http://localhost:4200/")
public class CartController {
	
	@Autowired
	private CartService service;
	
	@PostMapping("/addToCart/{userId}")
	public Cart addToCart(@RequestBody CartDto cartDto,@PathVariable int userId) {
		
		//System.out.println("In Cart Controller cuisineItemsInfo:::::::"+cart.getUser().getUserId());
		System.out.println("UserId in cartDto.getUser_id() Cart Controller:::::::::::::"+cartDto.getUser_id());
		System.out.println("UserId in Cart Controller:::::::::::::"+userId);
		System.out.println("In Cart Controller cuisineDetailsId:::::::"+cartDto.getCuisine_details_id());

		
		return service.addToCart(cartDto.getCuisine_details_id(),userId);
		
	}
	
	@GetMapping("/getCartData/{userId}")
	public List<CartDto> getCartData(@PathVariable int userId) {
		
		System.out.println("Inside Cart Controller getCartData().........");
		
		return service.getCartData(userId);
			
	}
	
	@DeleteMapping("/deleteCartData/{cartId}")
	public boolean deleteCartData(@PathVariable int cartId) {
		
		return service.deleteCartData(cartId);
	}
	
	@PutMapping("/updateCart/{cartId}")
	public void updateCart(@RequestBody Cart cart, @PathVariable int cartId) {
		
		System.out.println("Update Cart:::Cart ID:::"+cartId);
		service.updateCart(cart, cartId);
		
	}
	

	

}
