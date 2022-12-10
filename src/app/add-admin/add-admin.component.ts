import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Admin } from '../admin';
import { AdminService } from '../admin.service.service';
import { Cuisine } from '../cuisine';

@Component({
  selector: 'app-add-admin',
  templateUrl: './add-admin.component.html',
  styleUrls: ['./add-admin.component.css']
})
export class AddAdminComponent implements OnInit {
  adminInfo:Array<Admin>=[];
  insertMsg:string="";
  newadminRef = new FormGroup({
    email:new FormControl(),
    password:new FormControl()
  })
  
  constructor(private adminService:AdminService,private router:Router) { }

  ngOnInit(): void {

    this.router.navigate(['add-admin']);
  }

  addAdmin(){
     let newadminDetails = this.newadminRef.value;
     this.adminService.addAdmin(newadminDetails).subscribe( data => {  
      console.log(data);  
      this.insertMsg="Admin inserted successfully!!";  
      this.adminService.getAllAdmins().subscribe(data =>{  
        this.adminInfo =data  
        })  
      
    },  
     
    error => console.log(error));  
    this.router.navigate(['admin-page']);

  }

}

