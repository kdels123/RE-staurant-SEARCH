import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { RestaurantSearchComponent } from './restaurant-search/restaurant-search.component';
import { RestaurantHomeComponent } from './restaurant-home/restaurant-home.component';
import {RestaurantServiceClient} from './services/restaurant.service.client';
import {FormsModule} from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    RestaurantSearchComponent,
    RestaurantHomeComponent
  ],
  imports: [
    BrowserModule,
      FormsModule
  ],
  providers: [
      RestaurantServiceClient
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
