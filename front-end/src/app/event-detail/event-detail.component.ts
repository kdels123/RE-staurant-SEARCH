import { Component, OnInit } from '@angular/core';
import {ReviewServiceClient} from '../services/review.service.client';
import {ActivatedRoute, Router} from '@angular/router';
import {CriticServiceClient} from '../services/critic.service.client';
import {PatronServiceClient} from '../services/patron.service.client';
import {EventServiceClient} from '../services/event.service.client';

@Component({
  selector: 'app-event-detail',
  templateUrl: './event-detail.component.html',
  styleUrls: ['./event-detail.component.css']
})
export class EventDetailComponent implements OnInit {

    constructor(private criticService: CriticServiceClient,
                private patronService: PatronServiceClient,
                private eventService: EventServiceClient,
                private router: Router,
                private route: ActivatedRoute) {
        this.route.params.subscribe(params => this.loadEvent(params['eventId']));
    }

    critics;

    patrons

    event;
    eventId;

    loadEvent(eventId) {
        this.eventId = eventId;
        this.eventService.findEventById(eventId)
            .then(event => this.loadEventProfile(event));
    }

    loadEventProfile(event) {
        this.event = event;
        // this.patronService.findPatronsByEvent(event.id).then(
        //     patrons => this.patrons = patrons);
        // this.criticService.findCriticsByEvent(event.id).then(
        //     critics => this.critics = critics);
    }

    ngOnInit() {
    }

}
