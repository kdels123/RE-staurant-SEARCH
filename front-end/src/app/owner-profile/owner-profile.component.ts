import { Component, OnInit } from '@angular/core';
import {ReviewServiceClient} from '../services/review.service.client';
import {ActivatedRoute, Router} from '@angular/router';
import {CriticServiceClient} from '../services/critic.service.client';
import {PatronServiceClient} from '../services/patron.service.client';
import {OwnerServiceClient} from '../services/owner.service.client';
import {EventServiceClient} from '../services/event.service.client';

@Component({
  selector: 'app-owner-profile',
  templateUrl: './owner-profile.component.html',
  styleUrls: ['./owner-profile.component.css']
})
export class OwnerProfileComponent implements OnInit {

    constructor(private ownerService: OwnerServiceClient,
                private eventService: EventServiceClient,
                private patronService: PatronServiceClient,
                private router: Router,
                private route: ActivatedRoute) {
        this.route.params.subscribe(params => this.loadOwner(params['ownerId']));
    }

    ownerId;
    owner;

    events;

    patronUsername;
    patrons;
    patronEndorsements;

    criticUsername;
    critics;

    ownerUsername;

    loadOwner(ownerId) {
        this.ownerId = ownerId;
        this.ownerService.findOwnerById(ownerId)
            .then(owner => this.loadOwnerProfile(owner));
    }

    loadOwnerProfile(owner) {
        this.owner = owner;
        this.eventService.findEventsByOwner(owner.id).then(
            events => this.events = events);
        this.patronService.findPatronsByOwner(owner.id).then(
            patronEndorsements => this.patronEndorsements = patronEndorsements);
    }

    ownerToPatron(patronUsername) {
        this.patronService.findPatronByUsername(patronUsername)
            .then(patron => this.patronService.addOwnerToPatronEndorsed(this.ownerId, patron.id))
            .then(() => location.reload());
    }

    ngOnInit() {
    }

}
