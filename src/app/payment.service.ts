import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {
  baseUrl:string="http://localhost:8088/order"
  constructor(private http:HttpClient) { }



  saveOrder(userId:any,cartId:any,totalBill:any):Observable<any>{
    alert("In Payment Service::cartId:"+cartId)
    alert("In Payment Service::billAmount:"+totalBill)


    return this.http.post<any>(this.baseUrl+"/saveOrder",{userId,cartId,totalBill});
  }
}
