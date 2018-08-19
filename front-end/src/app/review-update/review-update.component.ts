import { Component, OnInit } from '@angular/core';
import {OwnerServiceClient} from '../services/owner.service.client';
import {ActivatedRoute, Router} from '@angular/router';
import {EventServiceClient} from '../services/event.service.client';
import {CriticServiceClient} from '../services/critic.service.client';
import {ReviewServiceClient} from '../services/review.service.client';

@Component({
  selector: 'app-review-update',
  templateUrl: './review-update.component.html',
  styleUrls: ['./review-update.component.css']
})
export class ReviewUpdateComponent implements OnInit {

    constructor(private criticService: CriticServiceClient,
                private reviewService: ReviewServiceClient,
                private router: Router,
                private route: ActivatedRoute) {
        this.route.params.subscribe(params => this.loadCriticReview(params['criticId'], params['reviewId']));
    }


    criticId;
    reviewId;

    reviewTitle;
    reviewDescription;
    reviewRating;

    loadCriticReview(criticId, reviewId){
        this.criticId = criticId;
        this.reviewId = reviewId;
        this.reviewService.findReviewById(this.reviewId)
            .then(event => this.loadReview(event));
    }

    loadReview(review) {
        this.reviewTitle = review.title;
        this.reviewDescription = review.description;
    }

    updateReview(reviewTitle, reviewDescription) {
      this.reviewService.updateReview(reviewTitle, reviewDescription, this.reviewRating, this.reviewId);
    }

    setRating(rating) {
      this.reviewRating = rating;
    }

    returnToProfile() {
        this.router.navigate(['profile/critic/' + this.criticId]);
    }

  ngOnInit() {
  }

}
