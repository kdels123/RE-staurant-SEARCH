import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {UserServiceClient} from '../services/user.service.client';
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
      this.route.params.subscribe(params => this.loadRestaurant(params['restaurantId']))
  }

  loadRestaurant(restaurantId) {
    alert(restaurantId);
  }


  ngOnInit() {
  }

}
