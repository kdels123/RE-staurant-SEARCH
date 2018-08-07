import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { RestaurantSearchComponent } from './restaurant-search/restaurant-search.component';
import { RestaurantHomeComponent } from './restaurant-home/restaurant-home.component';
import {RestaurantServiceClient} from './services/restaurant.service.client';
import {FormsModule} from '@angular/forms';
import {routing} from './app.routing';
import { RestaurantLoginComponent } from './restaurant-login/restaurant-login.component';
import { RestaurantRegisterComponent } from './restaurant-register/restaurant-register.component';


@NgModule({
  declarations: [
    AppComponent,
    RestaurantSearchComponent,
    RestaurantHomeComponent,
    RestaurantLoginComponent,
    RestaurantRegisterComponent
  ],
  imports: [
    BrowserModule,
      FormsModule,
      routing
  ],
  providers: [
      RestaurantServiceClient
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
