import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { OrderSummary } from './order-summary';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  baseUrl:string="http://localhost:8088/order"
  constructor(private http:HttpClient) { }

  orderReportByUser(userId:any):Observable<OrderSummary[]>{

    return this.http.get<OrderSummary[]>(this.baseUrl+"/orderReport/"+userId);

  }
}
