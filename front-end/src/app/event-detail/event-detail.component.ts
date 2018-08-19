import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {CriticServiceClient} from '../services/critic.service.client';
import {PatronServiceClient} from '../services/patron.service.client';
import {EventServiceClient} from '../services/event.service.client';
import {OwnerServiceClient} from '../services/owner.service.client';

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
                private router: Router,
                private route: ActivatedRoute) {
        this.route.params.subscribe(params => this.loadEvent(params['eventId']));
    }

    critics;

    patrons

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
        // this.patronService.findPatronsByEvent(event.id).then(
        //     patrons => this.patrons = patrons);
        // this.criticService.findCriticsByEvent(event.id).then(
        //     critics => this.critics = critics);
    }

    goToOwner() {
        this.router.navigate(['owner/' + this.ownerId]);
    }

    ngOnInit() {
    }

}
