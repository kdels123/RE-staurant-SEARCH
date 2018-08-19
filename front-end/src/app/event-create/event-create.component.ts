import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {PatronServiceClient} from '../services/patron.service.client';
import {OwnerServiceClient} from '../services/owner.service.client';
import {EventServiceClient} from '../services/event.service.client';

@Component({
  selector: 'app-event-create',
  templateUrl: './event-create.component.html',
  styleUrls: ['./event-create.component.css']
})
export class EventCreateComponent implements OnInit {

  constructor(private ownerService: OwnerServiceClient,
              private eventService: EventServiceClient,
              private router: Router,
              private route: ActivatedRoute) {
      this.route.params.subscribe(params => this.loadRestaurant(params['restaurantId']));
  }

  restaurantId;

  ownerUsername = null;
  eventTitle;
  eventDescription;
  eventDateTime;
  eventPrice;
  eventAttire;

  loadRestaurant(restaurantId) {
    this.restaurantId = restaurantId;
  }

    createEvent(eventTitle, eventDescription, eventDateTime, eventPrice, eventAttire, ownerUsername) {
    if (ownerUsername === null) {
      alert('Please enter username');
      return;
    }
    this.ownerService.findOwnerByUsername(ownerUsername)
        .then(owner => this.eventService.createEvent(
            eventTitle, eventDescription, eventDateTime, eventPrice, eventAttire, owner.id, this.restaurantId))
        .then(() => (this.router.navigate(['restaurant/' + this.restaurantId])))
        .catch(() => 'Must be logged in as User');
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
