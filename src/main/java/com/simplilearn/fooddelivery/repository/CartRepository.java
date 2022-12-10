package com.simplilearn.fooddelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.simplilearn.fooddelivery.dto.CartDto;
import com.simplilearn.fooddelivery.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{

	  @Query(nativeQuery = true)
	List<CartDto> getCartData(int userId);

}
