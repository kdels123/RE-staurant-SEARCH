import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {CriticServiceClient} from '../services/critic.service.client';
import {ReviewServiceClient} from '../services/review.service.client';

@Component({
  selector: 'app-critic-profile',
  templateUrl: './critic-profile.component.html',
  styleUrls: ['./critic-profile.component.css']
})
export class CriticProfileComponent implements OnInit {

  constructor(private criticService: CriticServiceClient,
              private reviewService: ReviewServiceClient,
              private router: Router,
              private route: ActivatedRoute) {
      this.route.params.subscribe(params => this.loadCritic(params['criticId']));
  }

  criticId;
  critic;

  reviews;
  followers;

  loadCritic(criticId) {
          this.criticId = criticId;
          this.criticService.findCriticById(criticId)
              .then(critic => this.loadCriticProfile(critic));
  }

  loadCriticProfile(critic) {
    this.critic = critic;
      this.reviewService.findReviewsByCritic(critic.id).then(
          reviews => this.reviews = reviews);
  }

  ngOnInit() {
  }

}
