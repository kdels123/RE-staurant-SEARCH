import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {PatronServiceClient} from '../services/patron.service.client';
import {RestaurantServiceClient} from '../services/restaurant.service.client';

@Component({
  selector: 'app-patron-profile',
  templateUrl: './patron-profile.component.html',
  styleUrls: ['./patron-profile.component.css']
})
export class PatronProfileComponent implements OnInit {

    constructor(private patronService: PatronServiceClient,
                private restaurantService: RestaurantServiceClient,
                private router: Router,
                private route: ActivatedRoute) {
        this.route.params.subscribe(params => this.loadPatron(params['patronId']));
    }

    patronId;
    patron;

    restaurants;
    criticsFollowed;

    loadPatron(patronId) {
        this.patronId = patronId;
        this.patronService.findPatronById(patronId)
            .then(critic => this.loadPatronProfile(critic));
    }

    loadPatronProfile(patron) {
        this.patron = patron;
        this.restaurantService.findRestaurantsByPatron(patron.id).then(
            restaurants => this.restaurants = restaurants);
    }

    ngOnInit() {
    }

}
