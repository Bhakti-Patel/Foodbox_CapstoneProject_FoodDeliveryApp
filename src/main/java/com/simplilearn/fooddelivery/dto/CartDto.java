package com.simplilearn.fooddelivery.dto;

public class CartDto {
	
	int cartId;
	int quantity;
	double totalPrice;
	double price;
	int cuisine_details_id;
	int user_id;
	String url;
	String cuisine_item_name;
	
	
	
	
	




	public CartDto() { 
		
	}
	
	
	
	public CartDto(int cartId, int quantity,double price, double totalPrice, int cuisine_details_id, int user_id,String url,String cuisine_item_name) {
		super();
		this.cartId = cartId;
		this.quantity = quantity;
		this.price=price;
		this.totalPrice = totalPrice;
		this.cuisine_details_id = cuisine_details_id;
		this.user_id = user_id;
		this.url=url;
		this.cuisine_item_name=cuisine_item_name;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	public String getCuisine_item_name() {
		return cuisine_item_name;
	}



	public void setCuisine_item_name(String cuisine_item_name) {
		this.cuisine_item_name = cuisine_item_name;
	}



	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
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



	public int getCuisine_details_id() {
		return cuisine_details_id;
	}
	public void setCuisine_details_id(int cuisine_details_id) {
		this.cuisine_details_id = cuisine_details_id;
	}

	public int getUser_id() {
		return user_id;
	}



	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
}
