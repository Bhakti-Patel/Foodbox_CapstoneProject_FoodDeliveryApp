import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Cart } from '../cart';
import { CartService } from '../cart.service';
import { Cuisine } from '../cuisine';
import { CuisineService } from '../cuisine.service';
import { CuisineDetails } from '../cuisineDetails';
import { NavbarService } from '../navbar.service';

@Component({
  selector: 'app-user-page',
  templateUrl: './user-page.component.html',
  styleUrls: ['./user-page.component.css']
})
export class UserPageComponent implements OnInit {

  userId:any="";
  cuisineInfo:Array<Cuisine>=[]; 
  cuisineItemsInfo:Array<CuisineDetails>=[];
  cartInfo:Array<Cart>=[]; 

  showCuisines:boolean=false;
  showCuisineItems:boolean = false;
  insertMsg:string="";

   constructor(private cuisineService:CuisineService,private router: Router,private route:ActivatedRoute,private cartService:CartService,private nav:NavbarService) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe((params) => {
      this.userId = params.get('userId');
      console.log("userId in UserPageComponent:::::::::::::::::"+this.userId)
    });
    this.nav.hide();

    this.loadCuisines();
  }

  loadCuisines(){

    this.showCuisines = true;
    this.showCuisineItems = false;

    //to show cuisines in admin page
    this.cuisineService.getAllCuisines().subscribe(cuisineList=>{
     this.cuisineInfo =  cuisineList;
     console.log(" this.cuisineInfo", this.cuisineInfo)
 
    });

}

getCuisineItems(cuisineId:any){

  this.showCuisineItems = true;
  this.showCuisines = false;


   //this.router.navigate(['cuisineItems',cuisineId,this.userId]);

   this.cuisineService.getCuisineItems(cuisineId).subscribe(cuisineItemList=>{
    this.cuisineItemsInfo =  cuisineItemList;
    console.log(" this.cuisineInfo", this.cuisineItemsInfo)


   });

}


  addToCart(cuisine_details_id:any){

    console.log("User Id in addTocart methos in UserPageCompnent:::"+this.userId)
    console.log("cuisine_details_id in addTocart methos in UserPageCompnent:::"+cuisine_details_id)
    this.cartService.addToCart(cuisine_details_id,this.userId).subscribe(
      res=>{
          console.log(res) ; 
          this.insertMsg="Added to Cart successfully!!"; 
    },error => console.log(error));  
    this.router.navigate(['user-page',this.userId]);
    this.showCuisineItems = true;
    this.showCuisines = false;
    
     
  }

  
  getCartData(){

    console.log("User Id in getCartData() in UserPageComponent::::::::::"+this.userId)
   
   // alert("Inside Cart Component..........");
   
    this.router.navigate(['cart',this.userId]);
  
    // })
    
  }

 

}
