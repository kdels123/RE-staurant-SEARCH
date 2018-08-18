import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {RestaurantServiceClient} from '../services/restaurant.service.client';
import {ReviewServiceClient} from '../services/review.service.client';
import {UserServiceClient} from '../services/user.service.client';
import {CriticServiceClient} from '../services/critic.service.client';
import {PatronServiceClient} from '../services/patron.service.client';

@Component({
  selector: 'app-restaurant-detail',
  templateUrl: './restaurant-detail.component.html',
  styleUrls: ['./restaurant-detail.component.css']
})
export class RestaurantDetailComponent implements OnInit {

  constructor(private restaurantService: RestaurantServiceClient,
              private reviewService: ReviewServiceClient,
              private userService: UserServiceClient,
              private criticService: CriticServiceClient,
              private patronService: PatronServiceClient,
              private router: Router,
              private route: ActivatedRoute) {
      this.route.params.subscribe(params => this.loadRestaurant(params['restaurantId']));
  }

  restaurant;
  restaurantId;
  restaurantName;

  reviews;
  reviewTitle;
  reviewDescription;
  reviewRating;

  critic;
  criticId;
  criticUsername;

  patron;
  patronUsername;
  patrons;

  loadRestaurant(restaurantId) {
      this.restaurantId = restaurantId;
      this.restaurantService.findRestaurantById(restaurantId)
          .then(restaurant => this.loadRestaurantDetail(restaurant));
  }

  loadRestaurantDetail(restaurant) {
      this.restaurant = restaurant;
      this.restaurantName = this.styleName(restaurant.name);
      this.reviewService.findReviewsByRestaurant(restaurant.id).then(
          reviews => this.reviews = reviews);
      this.patronService.findPatronsByRestaurant(restaurant.id).then(
          patrons => this.patrons = patrons);
  }

  addReview(reviewTitle, reviewDescription, criticUsername) {
      this.criticService.findCriticByUsername(criticUsername)
          .then(critic => this.reviewService
              .addReview(reviewTitle, reviewDescription, this.reviewRating, critic.id, this.restaurantId))
          .then(() => location.reload());
  }

    restaurantToPatron(patronUsername) {
      this.patronService.findPatronByUsername(patronUsername)
          .then(patron => this.patronService.restaurantToPatron(patron.id, this.restaurantId))
          .then(() => location.reload());;
    }

    findCriticByReview(reviewId) {
        this.criticService.findCriticByReview(reviewId)
            .then(critic => this.criticId = critic.id)
            .then(() => (this.router.navigate(['critic/' + this.criticId])));

    }

    goToPatronsProfile(patronId) {
      this.router.navigate(['patron/' + patronId]);
    }

    createEvent() {
        this.router.navigate(['restaurant/' + this.restaurantId + '/event']);
    }

  setRating(rating) {
      this.reviewRating = rating;
  }

  styleName(restaurantName) {
      let styledName = '';
      for (let i = 0; i < restaurantName.length; i++) {
          if (restaurantName.charAt(i) !== '-') {
              styledName = styledName + restaurantName.charAt(i);
          } else {
              styledName = styledName + ' ';
          }
      }
      return styledName;
  }



        ngOnInit() {
  }

}
