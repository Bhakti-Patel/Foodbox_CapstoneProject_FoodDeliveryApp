import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { NavbarService } from '../navbar.service';
import { PaymentService } from '../payment.service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  billAmount:number = 0;
  userId:any=0;
  cartIds:Array<number>=[];
  successMsg:string="";
  orderData:Array<any>=[];




  paymentRef = new FormGroup({
    cardNo:new FormControl(),
    date:new FormControl(),
    cvv:new FormControl(),
    name:new FormControl()
  });
  constructor(private route:ActivatedRoute,public nav: NavbarService,private router:Router,private paymentService:PaymentService) { }

  ngOnInit(): void {

    this.cartIds = this.route.snapshot.queryParams['myArray'];
    //alert("myArray:::::"+this.cartIds)

    this.route.params.subscribe( (param:any) => {
      this.billAmount = param['grandTotal']
      //alert("Bill Amount::::::::"+this.billAmount)
      this.userId = param['userId']
      //alert("User id"+this.userId)
    
    });
    this.nav.hide();


  }

  validatePayment(){

   // alert("Payment Scuccessfull");
    //alert("cartIds length"+this.cartIds.length)
    for (let i = 0; i < this.cartIds.length ; i++) {
     // alert ("Block statement execution cart Id" + this.cartIds[i]);
      this.paymentService.saveOrder(this.userId,this.cartIds[i],this.billAmount).subscribe(data =>{  

        this.orderData = data;
        console.log("Order data after save:::"+this.orderData);  
        //alert("Order Saved ")
        //this.successMsg="Order Saved successfully!!"; 
      }); 
      
    }
   

     
    this.router.navigate(['order-details',this.userId]);

  }

}
