import { Component, OnInit } from '@angular/core';
import {PatronServiceClient} from '../services/patron.service.client';
import {ActivatedRoute, Router} from '@angular/router';
import {EventServiceClient} from '../services/event.service.client';
import {CriticServiceClient} from '../services/critic.service.client';
import {RestaurantServiceClient} from '../services/restaurant.service.client';
import {OwnerServiceClient} from '../services/owner.service.client';

@Component({
  selector: 'app-patron-profile-component',
  templateUrl: './patron-profile-private.component.html',
  styleUrls: ['./patron-profile-private.component.css']
})
export class PatronProfilePrivateComponent implements OnInit {

    constructor(private patronService: PatronServiceClient,
                private restaurantService: RestaurantServiceClient,
                private eventService: EventServiceClient,
                private criticService: CriticServiceClient,
                private ownerService: OwnerServiceClient,
                private router: Router,
                private route: ActivatedRoute) {
        this.route.params.subscribe(params => this.loadUser(params['patronId']));
    }

    user;
    userId;
    username;
    firstName;
    lastName;
    email;
    phone;
    dob;

    restaurants;
    critics;
    favoriteCritic;
    events;
    invites;
    endorsements;

    loadUser(patronId) {
        this.userId = patronId;
        this.patronService.findPatronById(this.userId)
            .then(user => this.loadProfile(user));
    }

    loadProfile(user) {
        this.username = user.username;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.email = user.email;
        this.phone = user.phone;
        this.patronService.findFavoriteCritic(user.id).then(
            favoriteCritic => this.favoriteCritic = favoriteCritic);
        this.restaurantService.findRestaurantsByPatron(user.id).then(
            restaurants => this.restaurants = restaurants);
        this.criticService.findCriticsByPatron(user.id).then(
            critics => this.critics = critics);
        this.eventService.findEventsByPatron(user.id).then(
            events => this.events = events);
        this.ownerService.findOwnerInvitesByPatron(user.id).then(
            invites => this.invites = invites);
        this.ownerService.findOwnerEndorsementsByPatron(user.id).then(
            endorsements => this.endorsements = endorsements);
        this.dob = this.styleDate(user.dob);

    }

    update(firstName, lastName, email, phone, dob) {
        this.patronService.updatePatron(firstName, lastName, email, phone, dob, this.userId)
    }

    addFavoriteCritic(criticId) {
        this.patronService.addFavoriteCritic(criticId, this.userId)
            .then(() => location.reload());
    }

    logout() {
        this.router.navigate(['home']);
    }

    styleDate(date) {
        return date.substring(0, 10);
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
