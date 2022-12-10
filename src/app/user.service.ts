import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  baseUrl:string="http://localhost:8088/user"

  constructor(private http: HttpClient) { }

  getAllUsers(){
    return this.http.get<User[]>(this.baseUrl+"/getAllUsers");
  }
  addUser(userDetails:any){

    return this.http.post<User>(this.baseUrl+"/addUser",userDetails)

  }
}
