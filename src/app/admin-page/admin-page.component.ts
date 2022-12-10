import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Admin } from '../admin';
import { AdminService } from '../admin.service.service';
import { Cuisine } from '../cuisine';
import { CuisineService } from '../cuisine.service';
import { NavbarService } from '../navbar.service';

@Component({
  selector: 'app-admin-page',
  templateUrl: './admin-page.component.html',
  styleUrls: ['./admin-page.component.css']
})
export class AdminPageComponent implements OnInit {

 
  adminInfo:Array<Admin>=[];
  closeResult: string = '';


  editAdminForm = new FormGroup({
    id:new FormControl(),
    email : new FormControl(),
    password : new FormControl()
  }) 
  constructor(private modalService:NgbModal, private adminService:AdminService,private router:Router,public nav: NavbarService ) { }

  ngOnInit(): void {
    console.log("Inside AdminPageComponent visible:::"+this.nav.visible)
    this.nav.hide();
    
    

    this.adminService.getAllAdmins().subscribe(data =>{  
      this.adminInfo =data  
      })  
    
  }
  open(content:any) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  } 
  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return  `with: ${reason}`;
    }
  }
  editAdmin(adminDetails:any){


    //alert("AdminDetails.id:::"+adminDetails.id)
    this.editAdminForm.get("id")?.setValue(adminDetails.id);   

    this.editAdminForm.get("email")?.setValue(adminDetails.email);   
    this.editAdminForm.get("password")?.setValue(adminDetails.password);    
  }
  saveAdmin(){

    let adminDetails = this.editAdminForm.value;


    this.adminService.editAdmin(adminDetails).subscribe(data =>{  

      this.adminService.getAllAdmins().subscribe(data =>{  
        this.adminInfo =data  
        })  
       
      })  
      this.modalService.dismissAll()
  }
  deleteAdmin(adminId:any){
    this.adminService.deleteAdmin(adminId).subscribe(data =>{  
      this.adminService.getAllAdmins().subscribe(data =>{  
        this.adminInfo =data  
       
  
    })  
   
      })  
  }

  logout(){
    this.nav.hide();
    this.router.navigate(['/admin-page']);
  }
  
 

  

}