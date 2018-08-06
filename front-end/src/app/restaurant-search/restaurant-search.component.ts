import { Component, OnInit } from '@angular/core';
import {RestaurantServiceClient} from '../services/restaurant.service.client';

@Component({
  selector: 'app-restaurant-search',
  templateUrl: './restaurant-search.component.html',
  styleUrls: ['./restaurant-search.component.css']
})
export class RestaurantSearchComponent implements OnInit {

  restaurants = [];
  restaurantName;

  constructor(private restaurantService: RestaurantServiceClient) { }

  searchForRestaurant(restaurantName) {
      this.restaurantService.findRestaurantsByName(restaurantName)
          .then(res => this.restaurants = res.businesses);
  }

  ngOnInit() {
      // this.().then(res => this.restaurants = res.businesses);
  }

}
