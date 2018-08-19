import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {OwnerServiceClient} from '../services/owner.service.client';
import {CriticServiceClient} from '../services/critic.service.client';
import {EventServiceClient} from '../services/event.service.client';
import {PatronServiceClient} from '../services/patron.service.client';
import {RestaurantServiceClient} from '../services/restaurant.service.client';

@Component({
    selector: 'app-user-profile',
    templateUrl: './owner-profile-private.component.html',
    styleUrls: ['./owner-profile-private.component.css']
})
export class OwnerProfilePrivateComponent implements OnInit {

    constructor(private ownerService: OwnerServiceClient,
                private eventService: EventServiceClient,
                private patronService: PatronServiceClient,
                private criticService: CriticServiceClient,
                private restaurantService: RestaurantServiceClient,
                private router: Router,
                private route: ActivatedRoute) {
        this.route.params.subscribe(params => this.loadOwner(params['ownerId']));
    }

    user;
    ownerId;
    username;
    firstName;
    lastName;
    email;
    phone;
    dob;

    restaurants;
    restaurantName;
    restaurantAddress;
    restaurantCity;
    restaurantState;
    restaurantPhone;
    price;

    events;

    patrons;
    patronEndorsements;
    patronInvites;

    critics;
    criticEndorsements;
    criticInvites;

    loadOwner(ownerId) {
        this.ownerId = ownerId;
        this.ownerService.findOwnerById(this.ownerId)
            .then(user => this.loadProfile(user));
    }

    loadProfile(owner) {
        this.username = owner.username;
        this.firstName = owner.firstName;
        this.lastName = owner.lastName;
        this.email = owner.email;
        this.phone = owner.phone;
        this.restaurantService.findRestaurantsByOwner(owner.id).then(
            restaurants => this.restaurants = restaurants);
        this.eventService.findEventsByOwner(owner.id).then(
            events => this.events = events);
        this.patronService.findPatronsByOwner(owner.id).then(
            patronEndorsements => this.patronEndorsements = patronEndorsements);
        this.criticService.findCriticsByOwner(owner.id).then(
            criticEndorsements => this.criticEndorsements = criticEndorsements);
        this.patronService.findPatronInvitesByOwner(owner.id).then(
            patronInvites => this.patronInvites = patronInvites);
        this.criticService.findCriticInvitesByOwner(owner.id).then(
            criticInvites => this.criticInvites = criticInvites);

        this.dob = this.styleDate(owner.dob);
    }

    update(firstName, lastName, email, phone, dob) {
        this.ownerService.updateOwner(firstName, lastName, email, phone, dob, this.ownerId);
    }

    addRestaurantWithOwner(name, address, city, state, phone) {
        this.restaurantService.addRestaurantWithOwner(name, address, city, state, phone, this.price, this.ownerId)
            .then(() => location.reload());
    }

    logout() {
        this.router.navigate(['home']);
    }

    styleDate(date) {
        return date.substring(0, 10);
    }

    setPrice(price) {
        this.price = price;
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
