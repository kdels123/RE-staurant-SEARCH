import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { RestaurantSearchComponent } from './restaurant-search/restaurant-search.component';
import { RestaurantHomeComponent } from './restaurant-home/restaurant-home.component';
import {RestaurantServiceClient} from './services/restaurant.service.client';
import {FormsModule} from '@angular/forms';
import {routing} from './app.routing';
import { UserLoginComponent } from './user-login/user-login.component';
import { UserRegisterComponent } from './user-register/user-register.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import {UserServiceClient} from './services/user.service.client';
import { RestaurantDetailComponent } from './restaurant-detail/restaurant-detail.component';


@NgModule({
  declarations: [
    AppComponent,
    RestaurantSearchComponent,
    RestaurantHomeComponent,
    UserLoginComponent,
    UserRegisterComponent,
    UserProfileComponent,
    RestaurantDetailComponent
  ],
  imports: [
    BrowserModule,
      FormsModule,
      routing
  ],
  providers: [
      RestaurantServiceClient,
      UserServiceClient
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
