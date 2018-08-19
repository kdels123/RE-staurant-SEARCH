import { Component, OnInit } from '@angular/core';
import {RestaurantServiceClient} from '../services/restaurant.service.client';
import {OwnerServiceClient} from '../services/owner.service.client';
import {ActivatedRoute, Router} from '@angular/router';
import {EventServiceClient} from '../services/event.service.client';

@Component({
  selector: 'app-event-update',
  templateUrl: './event-update.component.html',
  styleUrls: ['./event-update.component.css']
})
export class EventUpdateComponent implements OnInit {

    constructor(private ownerService: OwnerServiceClient,
                private eventService: EventServiceClient,
                private router: Router,
                private route: ActivatedRoute) {
        this.route.params.subscribe(params => this.loadOwnerEvent(params['ownerId'], params['eventId']));
    }

    ownerId;

    eventId;

    eventTitle;
    eventDescription;
    eventDateTime;
    eventPrice;
    eventAttire;

    loadOwnerEvent(ownerId, eventId) {
        this.ownerId = ownerId;
        this.eventId = eventId;
        this.eventService.findEventById(this.eventId)
            .then(event => this.loadEvent(event));
    }

    loadEvent(event) {
        this.eventTitle = event.title;
        this.eventDescription = event.description;
        this.eventDateTime = event.DateTime;
        this.eventPrice = event.price;
        this.eventAttire = event.attire;
    }

    updateEvent(eventTitle, eventDescription, eventDateTime, eventPrice, eventAttire) {
        this.eventService.updateEvent(eventTitle, eventDescription, eventDateTime,
            eventPrice, eventAttire, this.eventId);
    }

    goHome() {
        this.router.navigate(['home']);
    }


    search() {
        this.router.navigate(['search']);
    }

    returnToProfile() {
        this.router.navigate(['profile/owner/' + this.ownerId]);
    }

    ngOnInit() {
  }

}
