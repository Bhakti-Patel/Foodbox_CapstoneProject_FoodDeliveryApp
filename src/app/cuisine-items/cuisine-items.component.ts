import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { CuisineService } from '../cuisine.service';
import { CuisineDetails } from '../cuisineDetails';

@Component({
  selector: 'app-cuisine-items',
  templateUrl: './cuisine-items.component.html',
  styleUrls: ['./cuisine-items.component.css']
})
export class CuisineItemsComponent implements OnInit {
  cuisineUpdateForm = new FormGroup({

    cuisineItemName:new FormControl(),
    cuisine_details_id:new FormControl(),
    price:new FormControl(),
    url:new FormControl()

  })

  cuisineItemsInfo:Array<CuisineDetails>=[]; 
  userId:any="";
  cuisineId:any="";
  saveMsg:string="";
deleteMsg:string="";
updateMsg:string="";
showUpdateDiv:boolean=false;
operation:string="";
cuisineItemList:Array<CuisineDetails>=[];

  b1:string="Save Cuisine Item";
  isupdated = false;  
  closeResult: string = '';

  constructor(private modalService: NgbModal,private cuisineService:CuisineService,private router:Router,private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.isupdated=false;  

    this.route.paramMap.subscribe((params) => {
      this.cuisineId = params.get('cuisineId');
      this.userId = params.get('userId');
      console.log("userid ,cuisineId in cuisineItemsComponent is:::"+this.userId+this.cuisineId)
    this.getCuisineItems(this.cuisineId);
    });
    
    
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

  getCuisineItems(cuisineId:any){
  this.cuisineService.getCuisineItems(cuisineId).subscribe(cuisineItemList=>{
    this.cuisineItemsInfo =  cuisineItemList;
  });
 
}
/* saveCuisineItem(){
  
  

  let cuisineItem = this.cuisineUpdateForm.value;
  if(this.b1=="Update Cuisine Item"){
    
    alert("In Update ");
    this.cuisineService.updateCuisineItem(cuisineItem).subscribe({
      next:(data:any)=>this.updateMsg="Data Updated successfully",
      error:(error:any)=>console.log(error),
      complete:()=>this.getCuisineItems(this.cuisineId)
});
  this.b1="Save Cuisine Item";
  }else {
    this.operation="Add";
    this.cuisineService.saveCuisineItem(cuisineItem).subscribe({
          next:(data:any)=>this.saveMsg="Data Saved successfully",
          error:(error:any)=>this.saveMsg="Data didn't store",
          complete:()=>this.getCuisineItems(this.cuisineId)
    })
  }
} */

update(){

 // alert("Update Form Submit")

  let cuisineItems = this.cuisineUpdateForm.value;
  
  

    this.cuisineService.updateCuisineItem(cuisineItems.cuisine_details_id,cuisineItems).subscribe(  
      data => {       
        this.isupdated=true;  
        this.cuisineService.getCuisineItems(this.cuisineId).subscribe(data =>{  
          this.cuisineItemsInfo =data  
          })  
      },  
      error => console.log(error));  

      this.modalService.dismissAll()
    }
      
    
  /* updateCuisineItem(cuisine_details_id:any){
    this.cuisineService.getCuisineItemById(cuisine_details_id).subscribe(data => 
      {  
        this.cuisineItemList=data             
      },  
      error => console.log(error)); 


  } */

  updateCuisineItem(cuisineItems:any){

    this.cuisineUpdateForm.get("cuisine_details_id")?.setValue(cuisineItems.cuisine_details_id);
    //alert(cuisineItems.cuisine_details_id);
  
      this.cuisineUpdateForm.get("cuisineItemName")?.setValue(cuisineItems.cuisineItemName);
      //alert(cuisineItems.cuisineItemName);
      this.cuisineUpdateForm.get("price")?.setValue(cuisineItems.price);
      //alert(cuisineItems.price);
  
      this.cuisineUpdateForm.get("url")?.setValue(cuisineItems.url);
      //alert(cuisineItems.url);
  }


   
   /*  this.b1="Update Cuisine Item";
    this.showUpdateDiv=true; */

/*     this.cuisineItem=new CuisineDetails();   
   this.cuisineItem.cuisine_details_id=this.CuisineItemId.value;  
   this.cuisineItem.cuisineItemName=this.CuisineItemName.value;  
   this.cuisineItem.price=this.Price.value;  
   this.cuisineItem.url=this.Url.value;  
   console.log(this.StudentBranch.value); */  
    

   changeisUpdate(){

    this.isupdated=false; 

  }
deleteCuisineItem(cuisine_details_id:any){

 // alert("Inside DeleteCuisine Item");
  
  this.cuisineService.deleteCuisineItem(cuisine_details_id).subscribe(  
    data => {       
      this.cuisineService.getCuisineItems(this.cuisineId).subscribe(data =>{  
        this.cuisineItemsInfo =data  
        })  
    },  
    error => console.log(error)); 



}
addCuisineItem(){
  //alert("Inside addCuisine Item in CuisineItemComponent")
  this.router.navigate(['add-cuisine-item',this.cuisineId]);
}
}


