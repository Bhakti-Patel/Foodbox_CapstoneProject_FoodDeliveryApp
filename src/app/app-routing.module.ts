import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutUsComponent } from './about-us/about-us.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { AdminPageComponent } from './admin-page/admin-page.component';
import { CuisineComponent } from './cuisine/cuisine.component';
import { AddAdminComponent } from './add-admin/add-admin.component';
import { UserPageComponent } from './user-page/user-page.component';
import { CuisineItemsComponent } from './cuisine-items/cuisine-items.component';
import { CartComponent } from './cart/cart.component';
import { PaymentComponent } from './payment/payment.component';
import { OrderDetailsComponent } from './order-details/order-details.component';
import { UpdateCuisineItemComponent } from './update-cuisine-item/update-cuisine-item.component';
import { AddCuisineItemComponent } from './add-cuisine-item/add-cuisine-item.component';
import { AppComponent } from './app.component';





const routes: Routes = [
  {path:"aboutus",component:AboutUsComponent},
  {path:"contactus",component:ContactUsComponent},
  {path:"adminlogin",component:AdminLoginComponent},
  {path:"userlogin",component:UserLoginComponent},
  {path:"admin-page",component:AdminPageComponent},
  {path:"user-page/:userId",component:UserPageComponent},
  {path:"cuisineItems/:cuisineId/:userId",component:CuisineItemsComponent},
  {path:"cuisineItems/:cuisineId",component:CuisineItemsComponent},
  

  {path:"cart/:userId",component:CartComponent},
  {path:"cart/:userId",component:CartComponent},

  {path:"admin-page/cuisineList",component:CuisineComponent},
  {path:"admin-page/adminList/cuisineList",component:CuisineComponent},
  {path:"admin-page/adminList",component:AdminPageComponent},
  {path:"admin-page/addAdmin",component:AddAdminComponent},
  {path:"admin-page/logout",component:AppComponent},
  {path:"payment/:userId/:grandTotal",component:PaymentComponent},
  {path:"order-details/:userId",component:OrderDetailsComponent},
  {path:"update-cuisine-item/:cuisineItems",component:UpdateCuisineItemComponent},
  {path:"add-cuisine-item/:cuisineId",component:AddCuisineItemComponent}



 
 

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
