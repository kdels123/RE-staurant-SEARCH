import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {CriticServiceClient} from '../services/critic.service.client';
import {ReviewServiceClient} from '../services/review.service.client';
import {PatronServiceClient} from '../services/patron.service.client';
import {OwnerServiceClient} from '../services/owner.service.client';

@Component({
  selector: 'app-critic-profile',
  templateUrl: './critic-profile.component.html',
  styleUrls: ['./critic-profile.component.css']
})
export class CriticProfileComponent implements OnInit {

  constructor(private criticService: CriticServiceClient,
              private reviewService: ReviewServiceClient,
              private patronService: PatronServiceClient,
              private ownerService: OwnerServiceClient,
              private router: Router,
              private route: ActivatedRoute) {
      this.route.params.subscribe(params => this.loadCritic(params['criticId']));
  }

  criticId;
  critic;

  reviews;

  patronUsername;
  patrons;

  ownerUsername;

  loadCritic(criticId) {
          this.criticId = criticId;
          this.criticService.findCriticById(criticId)
              .then(critic => this.loadCriticProfile(critic));
  }

  loadCriticProfile(critic) {
    this.critic = critic;
      this.reviewService.findReviewsByCritic(critic.id).then(
          reviews => this.reviews = reviews);
      this.patronService.findPatronsByCritic(critic.id).then(
      patrons => this.patrons = patrons);
  }

  criticToPatron(patronUsername) {
    this.patronService.findPatronByUsername(patronUsername)
        .then(patron => this.patronService.criticToPatron(patron.id, this.criticId))
        .then(() => location.reload());
  }

  criticToOwner(ownerUsername) {
    this.ownerService.findOwnerByUsername(ownerUsername)
        .then(owner => this.ownerService.addCriticInviteToOwner(owner.id, this.criticId))
        .then( () => alert('Invite Sent!'));
  }

  ngOnInit() {
  }

}
