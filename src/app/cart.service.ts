import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cart } from './cart';
import { CuisineDetails } from './cuisineDetails';

@Injectable({
  providedIn: 'root'
})
export class CartService {


  baseUrl:string="http://localhost:8088/cart"
  constructor(private http:HttpClient) { }
  
  addToCart(cuisine_details_id:any,userId:any):Observable<CuisineDetails>{

    
    return this.http.post<CuisineDetails>(this.baseUrl+"/addToCart/"+userId ,{cuisine_details_id,userId});

  }

  getCartData(userId:any):Observable<Cart[]>{

    //alert("Inside Cart Service");

    return this.http.get<Cart[]>(this.baseUrl+"/getCartData/"+userId);

  }

  deleteCartData(cartId:any):Observable<any>{
    //alert("Inside deleteCartData in Cart Service");
   //alert(this.baseUrl+"/deleteCartData/"+cartId)
    return this.http.delete(this.baseUrl+"/deleteCartData/"+cartId,{ responseType: 'text' });
  }

  updateCart(cart:any, cartId:any){
    return this.http.put<any>(this.baseUrl+"/updateCart/"+cartId,cart)
  }
}
