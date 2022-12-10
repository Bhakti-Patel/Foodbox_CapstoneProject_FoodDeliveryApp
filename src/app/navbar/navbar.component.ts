import { Component, OnInit } from '@angular/core';
import { NavbarService } from '../navbar.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  
 
  constructor(public nav: NavbarService) { }

  ngOnInit(): void {

    console.log("Inside NavbarComponent visible:::"+this.nav.visible)
    this.nav.visible=true;

    
  }

}
