import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {RestaurantServiceClient} from '../services/restaurant.service.client';

@Component({
  selector: 'app-restaurant-all-restaurants',
  templateUrl: './restaurant-all-restaurants.component.html',
  styleUrls: ['./restaurant-all-restaurants.component.css']
})
export class RestaurantAllRestaurantsComponent implements OnInit {

    constructor(private router: Router,
                private route: ActivatedRoute,
                private restaurantService: RestaurantServiceClient) {
        this.route.params.subscribe(params => this.loadRestaurant(params['adminId']));
    }


    adminId;

    restaurants;

    loadRestaurant(adminId) {
        this.adminId = adminId;
        this.restaurantService.findAllRestaurants().then(restaurants => this.restaurants = restaurants);
    }

    deleteRestaurant(restaurantId) {
        this.restaurantService.deleteRestaurant(restaurantId)
            .then(() => location.reload());
    }

    goToProfile() {
        this.router.navigate(['profile/admin/' + this.adminId]);
    }

    goHome() {
        this.router.navigate(['home']);
    }


    ngOnInit() {
    }

}
