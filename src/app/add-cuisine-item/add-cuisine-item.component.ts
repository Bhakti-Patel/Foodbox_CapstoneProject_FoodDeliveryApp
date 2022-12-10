import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CuisineService } from '../cuisine.service';
import { NavbarService } from '../navbar.service';

@Component({
  selector: 'app-add-cuisine-item',
  templateUrl: './add-cuisine-item.component.html',
  styleUrls: ['./add-cuisine-item.component.css']
})
export class AddCuisineItemComponent implements OnInit {

  cuisineId:any="";
  insertMsg:string="";
  cuisineItemAddForm = new FormGroup({
    cuisineItemName : new FormControl(),
    price:new FormControl(),
    url:new FormControl()

  })
  constructor(public nav:NavbarService, private route:ActivatedRoute,private router:Router,private cuisineService:CuisineService) { }

  ngOnInit(): void {

    this.nav.hide();
    this.route.paramMap.subscribe((params) => {
      this.cuisineId = params.get('cuisineId');
    });
  }
  addCuisineItem(){

    let cuisineItemInfo = this.cuisineItemAddForm.value;
    this.cuisineService.addCuisineItem(this.cuisineId,cuisineItemInfo).subscribe(data=>{
      this.insertMsg ="Cuisine Item Added Successfully";
      
       

        this.router.navigate(['cuisineItems',this.cuisineId])

});
  }
}
