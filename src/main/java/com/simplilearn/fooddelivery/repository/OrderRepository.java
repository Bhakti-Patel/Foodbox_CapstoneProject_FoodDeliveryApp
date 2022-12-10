package com.simplilearn.fooddelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import org.springframework.stereotype.Repository;

import com.simplilearn.fooddelivery.dto.UserOrderSummaryDto;
import com.simplilearn.fooddelivery.entity.Cuisine;
import com.simplilearn.fooddelivery.entity.OrderSummary;

@Repository
public interface OrderRepository extends JpaRepository<OrderSummary, Integer>{

	@Query(nativeQuery = true)
	List<UserOrderSummaryDto> getUserOrderSummary(int userId);

}
