import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {RestaurantServiceClient} from '../services/restaurant.service.client';

@Component({
  selector: 'app-restaurant-detail',
  templateUrl: './restaurant-detail.component.html',
  styleUrls: ['./restaurant-detail.component.css']
})
export class RestaurantDetailComponent implements OnInit {

  constructor(private service: RestaurantServiceClient,
              private router: Router,
              private route: ActivatedRoute) {
      this.route.params.subscribe(params => this.loadRestaurant(params['restaurantId']));
  }

  restaurantId;
  restaurantName;
  restaurantAddress;
  restaurantCity;
  restaurantState;
  restaurantPhone;
  restaurantDateEst;
  restaurantHoursOfOpp;
  restaurantNumberOfVisits;
  restaurantPrice;
  restaurantImage;

  loadRestaurant(restaurantId) {
      this.restaurantId = restaurantId;
      this.service.findRestaurantById(restaurantId)
          .then(restaurant => this.loadRestaurantDetail(restaurant));
  }

  loadRestaurantDetail(restaurant) {
      this.restaurantName = restaurant.name;
      this.restaurantAddress = restaurant.address;
      this.restaurantCity = restaurant.city;
      this.restaurantState = restaurant.state;
      this.restaurantPhone = restaurant.phone;
      this.restaurantDateEst = restaurant.DateEst;
      this.restaurantHoursOfOpp = restaurant.hoursOfOpp;
      this.restaurantNumberOfVisits = restaurant.numberOfVisits;
      this.restaurantPrice = restaurant.numberOfVisits;
      this.restaurantImage = restaurant.imageUrl;
  }

  ngOnInit() {
  }

}
