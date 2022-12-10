package com.simplilearn.fooddelivery.dto;

public class CuisineDetailsDto {

	private int cuisine_details_id;
	private double price;
	private int quantity;
	private String url;
	private String cuisineItemName;

	public CuisineDetailsDto() {

	}

	public CuisineDetailsDto(int cuisine_details_id, double price, int quantity, String url, String cuisineItemName) {
		this.cuisine_details_id = cuisine_details_id;
		this.price = price;
		this.quantity = quantity;
		this.url = url;
		this.cuisineItemName = cuisineItemName;
	}

	public int getCuisine_details_id() {
		return cuisine_details_id;
	}

	public void setCuisine_details_id(int cuisine_details_id) {
		this.cuisine_details_id = cuisine_details_id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCuisineItemName() {
		return cuisineItemName;
	}

	public void setCuisineItemName(String cuisineItemName) {
		this.cuisineItemName = cuisineItemName;
	}

	@Override
	public String toString() {
		return "CuisineDetailsDto [cuisine_details_id=" + cuisine_details_id + ", price=" + price + ", quantity="
				+ quantity + ", url=" + url + ", cuisineItemName=" + cuisineItemName + "]";
	}
	

}
