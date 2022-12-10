/**
 * 
 */
package com.simplilearn.fooddelivery.entity;

import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;
import javax.persistence.SqlResultSetMapping;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.simplilearn.fooddelivery.dto.CartDto;
import com.simplilearn.fooddelivery.dto.CuisineDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Bhakti
 *
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedNativeQuery(name = "Cart.getCartData",	
query = "SELECT c.cart_id as cartId,c.quantity,cd.price,c.total_price as totalPrice,c.cuisine_details_id,c.user_id,cd.url,cd.cuisine_item_name FROM CART as c,CUISINE_DETAILS as cd where "
			+"c.user_id =:userId "
			+"and cd.cuisine_details_id=c.cuisine_details_id ",
			resultSetMapping ="Mapping.CartDto")
@SqlResultSetMapping(name="Mapping.CartDto",
					classes=@ConstructorResult(targetClass=CartDto.class,
					columns= {
							@ColumnResult(name="cartId",type=Integer.class),	
							@ColumnResult(name="quantity"),
							@ColumnResult(name="price"),
							@ColumnResult(name="totalPrice"),
							@ColumnResult(name="cuisine_details_id"), 
							@ColumnResult(name="user_id"),
							@ColumnResult(name="url"),
							@ColumnResult(name="cuisine_item_name")
							
					}))
public class Cart {
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cart_id")
	private int cartId;

	
	private  int quantity;
	@Column(name="total_price")
	private double totalPrice;
	
	
	@OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "user_id")
	private User user;
	
	@JsonIgnore 
	@ManyToOne()
	@JoinColumn(name = "cuisine_details_id")
	private Cuisine_Details cuisineDetails;



}
