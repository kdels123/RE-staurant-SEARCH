import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {PatronServiceClient} from '../services/patron.service.client';
import {RestaurantServiceClient} from '../services/restaurant.service.client';
import {CriticServiceClient} from '../services/critic.service.client';
import {OwnerServiceClient} from '../services/owner.service.client';

@Component({
  selector: 'app-patron-profile',
  templateUrl: './patron-profile.component.html',
  styleUrls: ['./patron-profile.component.css']
})
export class PatronProfileComponent implements OnInit {

    constructor(private patronService: PatronServiceClient,
                private restaurantService: RestaurantServiceClient,
                private criticService: CriticServiceClient,
                private ownerService: OwnerServiceClient,
                private router: Router,
                private route: ActivatedRoute) {
        this.route.params.subscribe(params => this.loadPatron(params['patronId']));
    }

    ownerUsername = null;

    patronId;
    patron;

    restaurants;
    critics;

    loadPatron(patronId) {
        this.patronId = patronId;
        this.patronService.findPatronById(patronId)
            .then(critic => this.loadPatronProfile(critic));
    }

    loadPatronProfile(patron) {
        this.patron = patron;
        this.restaurantService.findRestaurantsByPatron(patron.id).then(
            restaurants => this.restaurants = restaurants);
        this.criticService.findCriticsByPatron(patron.id).then(
            critics => this.critics = critics);
    }

    patronToOwner(ownerUsername) {
        if (ownerUsername === null) {
            alert('Please enter a username');
            return;
        }
        this.ownerService.findOwnerByUsername(ownerUsername)
            .then(owner => this.ownerService.addPatronInviteToOwner(owner.id, this.patronId))
            .then( () => alert('Invite Sent!'))
            .catch(() => alert('Must be logged in as Restaurant Owner'));
    }

    goHome() {
        this.router.navigate(['home']);
    }


    search() {
        this.router.navigate(['search']);
    }

    ngOnInit() {
    }

}
