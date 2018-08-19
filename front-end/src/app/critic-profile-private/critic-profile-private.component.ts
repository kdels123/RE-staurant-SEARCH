import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {CriticServiceClient} from '../services/critic.service.client';
import {ReviewServiceClient} from '../services/review.service.client';
import {PatronServiceClient} from '../services/patron.service.client';
import {OwnerServiceClient} from '../services/owner.service.client';
import {EventServiceClient} from '../services/event.service.client';

@Component({
  selector: 'app-critic-profile-private',
  templateUrl: './critic-profile-private.component.html',
  styleUrls: ['./critic-profile-private.component.css']
})
export class CriticProfilePrivateComponent implements OnInit {

    constructor(private criticService: CriticServiceClient,
                private reviewService: ReviewServiceClient,
                private patronService: PatronServiceClient,
                private ownerService: OwnerServiceClient,
                private eventService: EventServiceClient,
                private router: Router,
                private route: ActivatedRoute) {
        this.route.params.subscribe(params => this.loadUser(params['criticId']));

    }

    critic;
    criticId;
    username;
    firstName;
    lastName;
    email;
    phone;
    dob;

    reviews;
    patrons;
    blockPatrons;
    owners;
    events;
    invites;
    endorsements;

    loadUser(criticId) {
        this.criticId = criticId;
        this.criticService.findCriticById(this.criticId)
            .then(critic => this.loadProfile(critic));
    }

    loadProfile(user) {
        this.username = user.username;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.email = user.email;
        this.phone = user.phone;
        this.reviewService.findReviewsByCritic(user.id).then(
            reviews => this.reviews = reviews);
        this.patronService.findPatronsByCritic(user.id).then(
            patrons => this.patrons = patrons);
        this.patronService.findBlockPatronsByCritic(user.id).then(
            blockPatrons => this.blockPatrons = blockPatrons);
        this.eventService.findEventsByCritic(user.id).then(
            events => this.events = events);
        this.ownerService.findOwnerInvitesByCritic(user.id).then(
            invites => this.invites = invites);
        this.ownerService.findOwnerEndorsementsByCritic(user.id).then(
            endorsements => this.endorsements = endorsements);
        this.dob = this.styleDate(user.dob);
    }

    update(firstName, lastName, email, phone, dob) {
        this.criticService.updateCritic(firstName, lastName, email, phone, dob, this.criticId);
    }

    logout() {
        this.router.navigate(['home']);
    }

    blockFollower(patronId) {
        this.criticService.addBlockPatron(patronId, this.criticId)
            .then(() => location.reload());
    }

    styleDate(date) {
     return date.substring(0, 10);
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
