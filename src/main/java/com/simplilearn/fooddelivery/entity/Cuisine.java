package com.simplilearn.fooddelivery.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;

import com.simplilearn.fooddelivery.dto.CuisineDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity	
@Data	
@AllArgsConstructor
@NoArgsConstructor
@NamedNativeQuery(name = "Cuisine.getAll",	
query = "SELECT cuisine_id as cuisineId , name  , url FROM CUISINE",
			resultSetMapping ="Mapping.CuisineDto")
@SqlResultSetMapping(name="Mapping.CuisineDto",
					classes=@ConstructorResult(targetClass=CuisineDto.class,
					columns= {
							@ColumnResult(name="cuisineId",type=Integer.class),	
							@ColumnResult(name="name"),
							@ColumnResult(name="url")
							
					}))

public class Cuisine {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cuisine_id")
	private int cuisineId;
	@Column(unique = true)
	private String name;
	private String url;
	
	@OneToMany(cascade = CascadeType.ALL ,mappedBy="cuisine")
    private List<Cuisine_Details> cuisine_details;  
	
    

}
