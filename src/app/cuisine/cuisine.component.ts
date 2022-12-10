import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Cuisine } from '../cuisine';
import { CuisineService } from '../cuisine.service';
import { NavbarService } from '../navbar.service';

@Component({
  selector: 'app-cuisine',
  templateUrl: './cuisine.component.html',
  styleUrls: ['./cuisine.component.css']
})
export class CuisineComponent implements OnInit {
  cuisineInfo:Array<Cuisine>=[];
  cuisineItemsInfo:Array<Cuisine>=[];

  deleteMsg:string="";
  showCuisineItems:boolean=false;
  showCuisines:boolean=false;
  constructor(private cuisineService:CuisineService,private router: Router ,public nav:NavbarService) { }

  ngOnInit(): void {
    
    this.loadCuisines();
    this.nav.hide();
     
      
    
    }
loadCuisines(){
  this.showCuisines=true;
  this.showCuisineItems=false;
   //to show cuisines in admin page
   this.cuisineService.getAllCuisines().subscribe(cuisineList=>{
    this.cuisineInfo =  cuisineList;
    console.log(" this.cuisineInfo", this.cuisineInfo)

   })
}
    deleteCuisine(cuisineId:any){

     // alert("cuisineId"+cuisineId)

      return this.cuisineService.deleteCuisine(cuisineId).subscribe( data => {  
        console.log(data);  
        this.deleteMsg="Cuisine deleted successfully!!";  
        this.cuisineService.getAllCuisines().subscribe(data =>{  
          this.cuisineInfo =data  
          })  
      },  
      error => console.log(error));  

    }

   
    getCuisineItems(cuisineId:any){

      
      this.router.navigate(['cuisineItems',cuisineId]);
      /* this.cuisineService.getCuisineItems(cuisineId).subscribe(cuisineItemList=>{
      this.cuisineItemsInfo =  cuisineItemList;
      console.log(" this.cuisineInfo", this.cuisineItemsInfo)
    
    
       }); */
    
    }

}
