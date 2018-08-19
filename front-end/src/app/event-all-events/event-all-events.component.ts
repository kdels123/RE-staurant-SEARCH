import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {EventServiceClient} from '../services/event.service.client';

@Component({
  selector: 'app-event-all-events',
  templateUrl: './event-all-events.component.html',
  styleUrls: ['./event-all-events.component.css']
})
export class EventAllEventsComponent implements OnInit {

    constructor(private router: Router,
                private route: ActivatedRoute,
                private eventService: EventServiceClient) {
        this.route.params.subscribe(params => this.loadEvent(params['adminId']));
    }


    adminId;

    events;

    loadEvent(adminId) {
        this.adminId = adminId;
        this.eventService.findAllEvents().then(events => this.events = events);
    }

    deleteEvent(eventId) {
        this.eventService.deleteEvent(eventId)
            .then(() => location.reload());
    }

    goToProfile() {
        this.router.navigate(['profile/admin/' + this.adminId]);
    }

    goHome() {
        this.router.navigate(['home']);
    }


    ngOnInit() {
    }

}
