import { Component, OnInit } from '@angular/core';
import {RestaurantServiceClient} from '../services/restaurant.service.client';
import {Router} from '@angular/router';

@Component({
  selector: 'app-restaurant-search',
  templateUrl: './restaurant-search.component.html',
  styleUrls: ['./restaurant-search.component.css']
})
export class RestaurantSearchComponent implements OnInit {

  restaurants = [];
  restaurantName;
  restaurantId;

  constructor(private restaurantService: RestaurantServiceClient,
              private router: Router) { }

  searchForRestaurant(restaurantName) {
      this.restaurantService.findRestaurantsByName(restaurantName)
          .then(res => this.restaurants = res.businesses);
  }

  visited(restaurant) {
    this.restaurantService.addRestaurant(restaurant)
        .then(savedRestaurant => this.restaurantId = savedRestaurant.id);
  }

  detail(restaurant) {
      this.restaurantService.addRestaurant(restaurant)
          .then(savedRestaurant => this.restaurantId = savedRestaurant.id)
          .then(() => (this.router.navigate(['restaurant/' + this.restaurantId])));
  }

  ngOnInit() {
      // this.().then(res => this.restaurants = res.businesses);
  }

}
