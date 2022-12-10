import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { NavbarService } from '../navbar.service';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {

  userRef= new FormGroup({
    email:new FormControl(),
    password:new FormControl(),
    name:new FormControl(),
    phone:new FormControl()
  })

  msg:string="";
  operation:string="User Login";
  register:boolean=true;


  constructor(private userService :UserService,private router:Router,public nav :NavbarService) { }

  ngOnInit(): void {
    this.nav.hide();
  }
  registerUser(){

this.operation="Register User";
this.register = false;
  }
  validateUser(){
    let userDetails = this.userRef.value;

    console.log(userDetails);

    if(!this.register){
      alert("Register");

      this.userService.addUser(userDetails).subscribe(data=>{
          this.msg="User Registered Successfully.Login to continue...!!"
          this.operation="User Login"
          this.register=true;

      })

    }
    else{
      alert("Login")
    this.userService.getAllUsers().subscribe( userList =>  {

      console.log(userList);
  
      userList.forEach( data => { 
       if(data.email == userDetails.email && data.password == userDetails.password){
    
          alert("Login Successful!")
    
           console.log("login success")
           console.log("UserId in UserLoginComponent::"+data.userId)
           this.router.navigate(['user-page',data.userId]);
           this.msg="";
    
         }
         else{
    
          this.msg="Invalid Credentials, Enter valid data or Register ";
            
    
        }
    
      });
    
    });  
  }
    
    }
  }


