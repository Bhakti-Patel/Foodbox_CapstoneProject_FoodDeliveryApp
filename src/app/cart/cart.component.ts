import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Cart } from '../cart';
import { CartService } from '../cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  cuisine_details_id:any="";
  userId:any="";
  cartInfo:Array<Cart>=[]; 
  deleteMsg:string="";
  grandTotal:any;
  cartIds:Array<number>=[];



  constructor(private route:ActivatedRoute,private router:Router,private cartService : CartService) { }

  ngOnInit(): void {

    this.route.paramMap.subscribe((params) => {
     this.userId = params.get('userId');
     console.log("this.userId in Cart Component onInit.........."+this.userId)
      
    });

    this.getCartData();
  }

  continueShopping(){
    this.router.navigate(['user-page',this.userId])
  }

  getCartData(){

      //to show cuisines in admin page
      this.cartService.getCartData(this.userId).subscribe(cartList=>{
        this.cartInfo =  cartList;
        console.log(" this.cartInfo", this.cartInfo)
  })
}

deleteCartData(cartId:any){
  alert("Inside deleteCartData in cart.component.ts")
  this.cartService.deleteCartData(cartId).subscribe(data =>{  
      console.log(data);  
      alert("item deleted ")
      this.deleteMsg="Item deleted successfully!!";  
      this.cartService.getCartData(this.userId).subscribe(data =>{  
        this.cartInfo =data  
        

    }); 

  });
    
  
}

decreaseQuantity(cart: any, cartId: any) {
  alert("Inside decrease quantity")
  cart.quantity -= 1;
  cart.totalPrice = cart.quantity * cart.price;
  this.updateCart(cart, cartId);   
}

increaseQuantity(cart: any, cartId: any) {
  alert("Inside incerase quantity")

  cart.quantity += 1;
 
  cart.totalPrice = cart.quantity * cart.price;
  this.updateCart(cart, cartId);   
}

updateCart(cart: any, cartId: any) {
    
  this.cartService.updateCart(cart, cartId).subscribe(cart => {
    console.log(cart);
    this.getCartData();
  });
}

findTotalPrice() {
  this.grandTotal = 0;
  this.cartService.getCartData(this.userId).subscribe(carts => {

    for(let cart of carts){
      this.grandTotal += cart.totalPrice;
      this.cartIds.push(cart.cartId);
      alert(cart.cartId)

     }
  });
  
}
checkOut(){

alert("Payment Successfull")
alert("cart ids:::"+this.cartIds)
alert(this.userId);

this.router.navigate(['payment',this.userId,this.grandTotal], {
  queryParams: { myArray: this.cartIds },
  });
//this.router.navigate(['payment',this.cartIds,this.userId],this.grandTotal);


}

}