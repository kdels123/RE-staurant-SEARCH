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

  ownerUsername;
  eventTitle;
  eventDescription;
  eventDateTime;
  eventPrice;
  eventAttire;

  loadRestaurant(restaurantId) {
    this.restaurantId = restaurantId;
  }

    createEvent(eventTitle, eventDescription, eventDateTime, eventPrice, eventAttire, ownerUsername) {
    this.ownerService.findOwnerByUsername(ownerUsername)
        .then(owner => this.eventService.createEvent(
            eventTitle, eventDescription, eventDateTime, eventPrice, eventAttire, owner.id, this.restaurantId))
        .then(() => (this.router.navigate(['restaurant/' + this.restaurantId])))

    ;
  }


  ngOnInit() {
  }

}
