import { Component, OnInit } from '@angular/core';
import {ReviewServiceClient} from '../services/review.service.client';
import {ActivatedRoute, Router} from '@angular/router';
import {CriticServiceClient} from '../services/critic.service.client';
import {PatronServiceClient} from '../services/patron.service.client';
import {OwnerServiceClient} from '../services/owner.service.client';
import {EventServiceClient} from '../services/event.service.client';
import {cr} from '@angular/core/src/render3';

@Component({
  selector: 'app-owner-profile',
  templateUrl: './owner-profile.component.html',
  styleUrls: ['./owner-profile.component.css']
})
export class OwnerProfileComponent implements OnInit {

    constructor(private ownerService: OwnerServiceClient,
                private eventService: EventServiceClient,
                private patronService: PatronServiceClient,
                private criticService: CriticServiceClient,
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

    critics;
    criticEndorsements;

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
        this.criticService.findCriticsByOwner(owner.id).then(
            criticEndorsements => this.criticEndorsements = criticEndorsements);
    }

    ownerToPatron(patronUsername) {
        this.patronService.findPatronByUsername(patronUsername)
            .then(patron => this.patronService.addOwnerToPatronEndorsed(this.ownerId, patron.id))
            .then(() => location.reload());
    }

    ownerToCritic(criticUsername) {
        this.criticService.findCriticByUsername(criticUsername)
            .then(critic => this.criticService.addOwnerToCriticEndorsed(this.ownerId, critic.id))
            .then(() => location.reload());;
    }

    ngOnInit() {
    }

}