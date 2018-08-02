import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { RestaurantSearchComponent } from './restaurant-search/restaurant-search.component';
import { RestaurantHomeComponent } from './restaurant-home/restaurant-home.component';

@NgModule({
  declarations: [
    AppComponent,
    RestaurantSearchComponent,
    RestaurantHomeComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
