import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service.service';
import { FormGroup,FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { NavbarService } from '../navbar.service';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {

    adminRef = new FormGroup({
    emailid:new FormControl(),
    password:new FormControl()
  });
msg:string="";

constructor(public adminService : AdminService,private router:Router,public nav :NavbarService) { }

  ngOnInit(): void {

    console.log("Inside AdminLoginComponent visible:::"+this.nav.visible)
    this.nav.visible=false;
    this.nav.hide();
    
  }
validateAdmin(){
  let adminDetails = this.adminRef.value;
this.adminService.getAllAdmins().subscribe( adminList =>  {

  console.log(adminList);

    adminList.forEach( data => { 

        console.log(data);

     console.log("this.emailid "+adminDetails.emailid+" this.password"+adminDetails.password)
     console.log("data.email"+data.email+"data.password"+data.password);

  if(data.email == adminDetails.emailid && data.password == adminDetails.password){

      alert("Login Successful!")

       console.log("login success")
       this.router.navigate(['admin-page']);
       this.msg="";
       this.nav.hide();

     }
     else{

      this.msg="Invalid Credentials, Enter valid data";
        //console.log("Invalid Credentials, Enter valid data")

    }

  });

});  


}
 }

