package com.simplilearn.fooddelivery.entity;

import java.util.List;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

import com.simplilearn.fooddelivery.dto.UserOrderSummaryDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedNativeQuery(name = "OrderSummary.getUserOrderSummary",
query= 
	"  select "
			+" 	o.order_id as orderId,u.user_id as userId,c.cart_id as cartId , "
			+ " u.name as userName , u.email,  u.phone, "
			+ " cd.cuisine_item_name as cuisineItemName, "
			+ " o.total_bill as billAmount ,c.quantity, "
			+ " c.total_price as totalPrice "
			+ " from "
			+ " order_summary o,user u,cuisine_details cd,cart c "
			+ " where "
			+ " u.user_id = :userId and c.user_id = o.user_id and "
			+ " cd.cuisine_details_id = c.cuisine_details_id and "
			+ " c.cart_id = o.cart_id",
	
	    
resultSetMapping = "Mapping.UserOrderSummaryDto"		
)
@SqlResultSetMapping(name = "Mapping.UserOrderSummaryDto",
 classes = @ConstructorResult (
		    targetClass = UserOrderSummaryDto.class,
		    columns = {
		    		
		    		@ColumnResult(name= "orderId",type=Integer.class),
		    		@ColumnResult(name = "userId",type=Integer.class),
		    		@ColumnResult(name= "cartId",type=Integer.class),
		    		@ColumnResult(name = "userName"),
		    		@ColumnResult(name = "email"),
		    		@ColumnResult(name= "phone"),
		    		@ColumnResult(name = "cuisineItemName"),
		    		@ColumnResult(name = "billAmount",type=Integer.class),
		    		@ColumnResult(name= "quantity",type=Integer.class),
		    		@ColumnResult(name = "totalPrice",type=Double.class)
		    
		    	
		    })
)
public class OrderSummary {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderId;
	private int cartId;
	private int userId; 
	private int totalBill;

}
