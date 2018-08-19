import { Component, OnInit } from '@angular/core';
import {RestaurantServiceClient} from '../services/restaurant.service.client';
import {OwnerServiceClient} from '../services/owner.service.client';
import {ActivatedRoute, Router} from '@angular/router';


@Component({
  selector: 'app-restaurant-update',
  templateUrl: './restaurant-update.component.html',
  styleUrls: ['./restaurant-update.component.css']
})
export class RestaurantUpdateComponent implements OnInit {

    constructor(private ownerService: OwnerServiceClient,
                private restaurantService: RestaurantServiceClient,
                private router: Router,
                private route: ActivatedRoute) {
        this.route.params.subscribe(params => this.loadOwnerRestaurant(params['ownerId'], params['restaurantId']));
    }

    ownerId;
    restaurantId;

    restaurantName;
    restaurantAddress;
    restaurantCity;
    restaurantState;
    restaurantPhone;
    restaurantPrice;

    loadOwnerRestaurant(ownerId, restaurantId) {
        this.ownerId = ownerId;
        this.restaurantId = restaurantId;
        this.restaurantService.findRestaurantById(this.restaurantId)
            .then(restaurant => this.loadRestaurant(restaurant));
    }

    loadRestaurant(restaurant) {
      this.restaurantName = restaurant.name;
        this.restaurantAddress = restaurant.address;
        this.restaurantCity = restaurant.city;
        this.restaurantState = restaurant.state;
        this.restaurantPhone = restaurant.phone;
    }

    updateRestaurant(restaurantName, restaurantAddress, restaurantCity, restaurantState, restaurantPhone) {
      this.restaurantService.updateRestaurant(restaurantName, restaurantAddress, restaurantCity,
          restaurantState, restaurantPhone, this.restaurantPrice, this.restaurantId)
          .then(() => alert('Update Complete!'));
    }

    returnToProfile() {
        this.router.navigate(['profile/owner/' + this.ownerId]);
    }

    setPrice(price) {
      this.restaurantPrice = price;
    }

    ngOnInit() {
  }

}
