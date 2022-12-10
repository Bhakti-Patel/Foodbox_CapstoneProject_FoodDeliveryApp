import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Admin } from './admin';
import { Cuisine } from './cuisine';
import { Observable } from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class AdminService {

  baseUrl:string="http://localhost:8088/admin"

  constructor(private http:HttpClient) { }


  
  getAllAdmins(){
    return this.http.get<Admin[]>(this.baseUrl+"/getAllAdmins");
  }

  addAdmin(adminDetails:any):Observable<Admin>{
    return this.http.post<Admin>(this.baseUrl+"/addAdmin",adminDetails);
  }
  editAdmin(adminDetails:any):Observable<Admin>{
    return this.http.put<Admin>(this.baseUrl+"/editAdmin",adminDetails)
  }
  deleteAdmin(adminId:any):Observable<Admin>{
    return this.http.delete<Admin>(this.baseUrl+"/deleteAdmin/"+adminId)

  }
 
}

