import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
//import { CommonModule } from '@angular/common';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { NgbActiveModal, NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ReactiveFormsModule } from '@angular/forms';
import { AdminService } from './admin.service.service';
import { HttpClientModule } from '@angular/common/http';
import { AdminPageComponent } from './admin-page/admin-page.component';
import { UserPageComponent } from './user-page/user-page.component';
import { CuisineComponent } from './cuisine/cuisine.component';
import { CuisineService } from './cuisine.service';
import { AddAdminComponent } from './add-admin/add-admin.component';
import { NavbarComponent } from './navbar/navbar.component';
import { PaymentComponent } from './payment/payment.component';
import { NavbarService } from './navbar.service';
import { HomeComponent } from './home/home.component';
import { CuisineItemsComponent } from './cuisine-items/cuisine-items.component';
import { CartComponent } from './cart/cart.component';
import { OrderDetailsComponent } from './order-details/order-details.component';
import { CartService } from './cart.service';
import { UserService } from './user.service';
import { CuisineDetailsService } from './cuisine-details.service';
import { UpdateCuisineItemComponent } from './update-cuisine-item/update-cuisine-item.component';
import { AddCuisineItemComponent } from './add-cuisine-item/add-cuisine-item.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminLoginComponent,
    UserLoginComponent,
    AboutUsComponent,
    ContactUsComponent,
    HeaderComponent,
    FooterComponent,
    AdminPageComponent,
    UserPageComponent,
    CuisineComponent,
    AddAdminComponent,
    NavbarComponent,
    PaymentComponent,
    HomeComponent,
    CuisineItemsComponent,
    CartComponent,
    OrderDetailsComponent,
    UpdateCuisineItemComponent,
    AddCuisineItemComponent
  ],
  imports: [
    BrowserModule,
   // CommonModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    ReactiveFormsModule,
  ],
  providers: [AdminService,CuisineService,NavbarService,CartService,UserService,CuisineDetailsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
