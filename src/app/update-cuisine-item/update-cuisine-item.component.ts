import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-cuisine-item',
  templateUrl: './update-cuisine-item.component.html',
  styleUrls: ['./update-cuisine-item.component.css']
})
export class UpdateCuisineItemComponent implements OnInit {

  cuisineItemRef = new FormGroup({

    cuisineItemName:new FormControl(),
    price:new FormControl(),
    url:new FormControl()

  })
  constructor(private route:ActivatedRoute,private router:Router) { }

  ngOnInit(): void {

    
 
}
}
