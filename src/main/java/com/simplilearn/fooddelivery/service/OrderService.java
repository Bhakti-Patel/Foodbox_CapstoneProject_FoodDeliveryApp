package com.simplilearn.fooddelivery.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.simplilearn.fooddelivery.dto.UserOrderSummaryDto;
import com.simplilearn.fooddelivery.entity.OrderSummary;


public interface OrderService {
	
	public OrderSummary saveOrder(OrderSummary orderDto);
	
	public List<UserOrderSummaryDto> orderReportByUser(int userId);

}
