import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NavbarService } from '../navbar.service';
import { OrderSummary } from '../order-summary';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-order-details',
  templateUrl: './order-details.component.html',
  styleUrls: ['./order-details.component.css']
})
export class OrderDetailsComponent implements OnInit {
userId:string="";
orderReportList:Array<OrderSummary>=[];
totalBill:number=0;
userName:any;
email:any;

  constructor(private route:ActivatedRoute,private orderService : OrderService,private nav:NavbarService) { }

  ngOnInit(): void {
    this.route.params.subscribe( (param:any) => {
      this.userId = param['userId']
  });
  this.nav.hide();
  }

  orderReportByUser(){
    //alert("In Order-Details")

    this.orderService.orderReportByUser(this.userId).subscribe(data=>{
      this.orderReportList = data;
      this.totalBill = this.orderReportList[0]["billAmount"];
      this.userName = this.orderReportList[0]["userName"];
      this.email = this.orderReportList[0]["email"];

    })

    
    
    
  }

}
