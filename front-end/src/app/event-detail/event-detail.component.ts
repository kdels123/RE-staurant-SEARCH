import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {CriticServiceClient} from '../services/critic.service.client';
import {PatronServiceClient} from '../services/patron.service.client';
import {EventServiceClient} from '../services/event.service.client';
import {OwnerServiceClient} from '../services/owner.service.client';
import {ReviewServiceClient} from '../services/review.service.client';

@Component({
  selector: 'app-event-detail',
  templateUrl: './event-detail.component.html',
  styleUrls: ['./event-detail.component.css']
})
export class EventDetailComponent implements OnInit {

    constructor(private criticService: CriticServiceClient,
                private patronService: PatronServiceClient,
                private eventService: EventServiceClient,
                private ownerService: OwnerServiceClient,
                private reviewService: ReviewServiceClient,
                private router: Router,
                private route: ActivatedRoute) {
        this.route.params.subscribe(params => this.loadEvent(params['eventId']));
    }

    critics;
    criticUsernameI = null;
    criticUsername = null;

    patrons;
    patronUsername = null;

    reviews;
    reviewTitle;
    reviewDescription;
    reviewRating;


    event;
    eventId;

    ownerId;

    loadEvent(eventId) {
        this.eventId = eventId;
        this.eventService.findEventById(eventId)
            .then(event => this.loadEventProfile(event));
    }

    loadEventProfile(event) {
        this.event = event;
        this.ownerService.findOwnerByEvent(event.id).then(
            owner => this.ownerId = owner.id);
        this.patronService.findPatronsByEvent(event.id).then(
            patrons => this.patrons = patrons);
        this.criticService.findCriticsByEvent(event.id).then(
            critics => this.critics = critics);
        this.reviewService.findReviewsByEvent(event.id).then(
            reviews => this.reviews = reviews);
    }

    addReviewForEvent(reviewTitle, reviewDescription, criticUsername) {
        if (this.criticUsername === null) {
            alert('Please enter a username');
            return;
        }
        this.criticService.findCriticByUsername(criticUsername)
            .then(critic => this.reviewService
                .addReviewForEvent(reviewTitle, reviewDescription, this.reviewRating, critic.id, this.eventId))
            .then(() => location.reload())
            .catch(() => alert('Must be logged in as Critic'));
    }

    addEventToPatron(patronUsername) {
        if (patronUsername === null) {
            alert('Please enter username');
            return;
        }
        this.patronService.findPatronByUsername(patronUsername)
            .then(patron => this.patronService.addEventToPatron(this.eventId, patron.id))
            .then(() => location.reload())
            .catch(() => alert('Must be logged in as Patron'));
    }

    addEventToCritic(criticUsernameI) {
        if (criticUsernameI === null) {
            alert('Please enter username');
            return;
        }
        this.criticService.findCriticByUsername(criticUsernameI)
            .then(critic => this.criticService.addEventToCritic(this.eventId, critic.id))
            .then(() => location.reload())
            .catch(() => alert('Must be logged in as Critic'));
        ;
    }

    goToOwner() {
        this.router.navigate(['owner/' + this.ownerId]);
    }

    goHome() {
        this.router.navigate(['home']);
    }


    search() {
        this.router.navigate(['search']);
    }


    setRating(rating) {
        this.reviewRating = rating;
    }

    ngOnInit() {
    }

}
