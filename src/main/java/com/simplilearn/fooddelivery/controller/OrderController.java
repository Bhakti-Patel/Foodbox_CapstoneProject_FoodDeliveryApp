package com.simplilearn.fooddelivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.fooddelivery.dto.UserOrderSummaryDto;
import com.simplilearn.fooddelivery.entity.OrderSummary;
import com.simplilearn.fooddelivery.service.OrderService;

@RestController
@RequestMapping("/order")
@CrossOrigin("http://localhost:4200/")
public class OrderController {
	
	@Autowired
	OrderService service;
	
	
	@PostMapping("/saveOrder")
	public OrderSummary saveOrder(@RequestBody OrderSummary orderDetails) {
		
		System.out.println("cartId"+orderDetails.getCartId());
		System.out.println("userId"+orderDetails.getUserId());
		System.out.println("TotalBill"+orderDetails.getTotalBill());
	
		return service.saveOrder(orderDetails);
		
	}
	
	@GetMapping("/orderReport/{userId}")
	public List<UserOrderSummaryDto> orderReportByUser(@PathVariable int userId) {
		
		List<UserOrderSummaryDto> orderList = service.orderReportByUser(userId);
		return orderList;
	}

}
