/**
 * 
 */
package com.simplilearn.fooddelivery.dto;

/**
 * @author Bhakti
 *
 */
public class CuisineDto {

	private int cuisineId;
	private String name;
	private String url;

	public CuisineDto() {

	}

	public CuisineDto(int cuisineId, String name, String url) {
		this.cuisineId = cuisineId;
		this.name = name;
		this.url = url;
	}

	public int getCuisineId() {
		return cuisineId;
	}

	public void setCuisineId(int cuisineId) {
		this.cuisineId = cuisineId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
