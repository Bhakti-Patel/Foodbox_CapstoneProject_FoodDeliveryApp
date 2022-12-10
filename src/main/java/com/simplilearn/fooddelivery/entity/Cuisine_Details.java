package com.simplilearn.fooddelivery.entity;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

import com.simplilearn.fooddelivery.dto.CuisineDetailsDto;
import com.simplilearn.fooddelivery.dto.CuisineDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data	
@AllArgsConstructor
@NoArgsConstructor
@NamedNativeQuery(name = "Cuisine_Details.getAllItemsByCusineId",	
query = "SELECT cuisine_details_id , price, quantity , url , cuisine_item_name as cuisineItemName  FROM Cuisine_Details where "
		+ "   cuisine_id=:cusineId  ",
			resultSetMapping ="Mapping.CuisineDetailsDto")
@SqlResultSetMapping(name="Mapping.CuisineDetailsDto",
					classes=@ConstructorResult(targetClass=CuisineDetailsDto.class,
					columns= {
							@ColumnResult(name="cuisine_details_id",type=Integer.class),
							@ColumnResult(name="price"),
							@ColumnResult(name="quantity"),
							@ColumnResult(name="url"),
							@ColumnResult(name="cuisineItemName")
							
					}))

public class Cuisine_Details {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cuisine_details_id;
	private double price;
	private int quantity;
	private String url;
	private String cuisineItemName;

	 @ManyToOne
	    @JoinColumn(name="cuisine_id", nullable=false)
	    private Cuisine cuisine;

	@Override
	public String toString() {
		return "Cuisine_Details [cuisine_details_id=" + cuisine_details_id + ", price=" + price + ", quantity="
				+ quantity + ", url=" + url + ", cuisineItemName=" + cuisineItemName + ", cuisine=" + cuisine.getCuisineId() + "]";
	}
	 
	
}

