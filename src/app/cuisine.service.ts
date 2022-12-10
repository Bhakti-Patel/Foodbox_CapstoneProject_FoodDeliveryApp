import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cuisine } from './cuisine';
import { CuisineDetails } from './cuisineDetails';

@Injectable({
  providedIn: 'root'
})
export class CuisineService {

  baseUrl:string="http://localhost:8088/cuisines"
  constructor(private http:HttpClient) { }

  getAllCuisines():Observable<Cuisine[]>{
    
    return this.http.get<Cuisine[]>(this.baseUrl+"/getAllCuisines");
  }

  deleteCuisine(cuisineId:any):Observable<any>{
    alert("Inside deleteCuisine in Cuisine Service");
    alert(this.baseUrl+"/deleteCuisine/"+cuisineId)
    return this.http.delete(this.baseUrl+"/deleteCuisine/"+cuisineId,{ responseType: 'text' });
  }

  deleteCuisineItem(cuisine_details_id:any):Observable<any>{
    alert("Inside deleteCuisineItem in Cuisine Service");
    alert(this.baseUrl+"/deleteCuisineItem/"+cuisine_details_id)
    return this.http.delete(this.baseUrl+"/deleteCuisineItem/"+cuisine_details_id,{ responseType: 'text' });
  }

  getCuisineItems(cuisineId:any):Observable<any>{

    return this.http.get<CuisineDetails[]>(this.baseUrl+"/getCuisineItems/"+cuisineId);

  }
  updateCuisineItem(cuisine_details_id:any, cuisineItem:any):Observable<CuisineDetails>{
    
    return this.http.put<CuisineDetails>(this.baseUrl+"/updateCuisineItem/"+cuisine_details_id,cuisineItem); 

  }
  saveCuisineItem(cuisineItem:any):Observable<CuisineDetails>{

    return this.http.post<CuisineDetails>(this.baseUrl,cuisineItem);
  }
  getCuisineItemById(cuisine_details_id:any):Observable<any>{
    return this.http.get(this.baseUrl+"/getCuisineItemById/"+cuisine_details_id);
  }

  addCuisineItem(cuisineId:any,cuisineItemsInfo:any):Observable<CuisineDetails>{
    return this.http.post<CuisineDetails>(this.baseUrl+"/addCuisineItem/"+cuisineId,cuisineItemsInfo)
  }
}
