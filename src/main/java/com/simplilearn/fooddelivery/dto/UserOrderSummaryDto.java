package com.simplilearn.fooddelivery.dto;

public class UserOrderSummaryDto {
	
	private int orderId;
	private int userId;
	private int cartId;
	private String userName;
	private String email;
	private String phone;
	private String cuisineItemName;
	private int billAmount;
	private int quantity;
	private double totalPrice;
	
	
	public UserOrderSummaryDto() {
		
	}
	
	
	public UserOrderSummaryDto(
			int orderId, 
			int userId, 
			int cartId, 
			String userName, 
			String email, 
			String phone,
			String cuisineItemName, 
			int billAmount,
			int quantity, 
			double totalPrice) {
		this.orderId = orderId;
		this.userId = userId;
		this.cartId = cartId;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.cuisineItemName = cuisineItemName;
		this.billAmount = billAmount;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}





	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCuisineItemName() {
		return cuisineItemName;
	}
	public void setCuisineItemName(String cuisineItemName) {
		this.cuisineItemName = cuisineItemName;
	}
	public int getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(int billAmount) {
		this.billAmount = billAmount;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	

	
	

}
