package com.simplilearn.fooddelivery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.simplilearn.fooddelivery.dto.CartDto;
import com.simplilearn.fooddelivery.entity.Cart;


public interface CartService {
	
	public Cart addToCart(int cuisine_details_id,int userId);
	
	public List<CartDto> getCartData(int userId);
	
	public boolean deleteCartData(int cartId);
	
	public void updateCart(Cart cart,int cartId);

}
