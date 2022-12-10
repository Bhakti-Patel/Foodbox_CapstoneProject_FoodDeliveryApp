package com.simplilearn.fooddelivery.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.fooddelivery.dto.UserOrderSummaryDto;
import com.simplilearn.fooddelivery.entity.OrderSummary;
import com.simplilearn.fooddelivery.repository.OrderRepository;
import com.simplilearn.fooddelivery.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderRepository repo;
	
	public OrderSummary saveOrder(OrderSummary orderDto) {
		
		System.out.println("cartId"+orderDto.getCartId());
		System.out.println("userId"+orderDto.getUserId());
		System.out.println("TotalBill"+orderDto.getTotalBill());
	
		
		return repo.save(orderDto);
		
	}
	
	public List<UserOrderSummaryDto> orderReportByUser(int userId){
		
		List<UserOrderSummaryDto> orderSummary =  repo.getUserOrderSummary(userId);

		
		return orderSummary;
		
	}

}
