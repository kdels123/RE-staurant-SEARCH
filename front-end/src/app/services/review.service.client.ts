export class ReviewServiceClient {

    addReview(title, description, rating, criticId, restaurantId) {
        const review = {
            title: title,
            description: description,
            rating: rating,
        };
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/critic/' + criticId + '/restaurant/' + restaurantId + '/review', {
            method: 'post',
            body: JSON.stringify(review),
            headers: {
                'content-type': 'application/json',
            }
        }).then(response => response.json());
    }

    addReviewForEvent(title, description, rating, criticId, eventId) {
        const review = {
            title: title,
            description: description,
            rating: rating,
        };
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/critic/' + criticId + '/event/' + eventId + '/review', {
            method: 'post',
            body: JSON.stringify(review),
            headers: {
                'content-type': 'application/json',
            }
        }).then(response => response.json());
    }

    findReviewById(reviewId) {
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/review/' + reviewId)
            .then(function (response) {
                return response.json();
            });
    }

    findReviewsByCritic(criticId) {
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/critic/' + criticId + '/review')
            .then(function (response) {
                return response.json();
            });
    }

    findReviewsByRestaurant(restaurantId) {
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/restaurant/' + restaurantId + '/review')
            .then(function (response) {
                return response.json();
            });
    }

    findReviewsByEvent(eventId) {
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/event/' + eventId + '/review')
            .then(function (response) {
                return response.json();
            });
    }

    updateReview(title, description, rating, reviewId) {
        const review = {
            title: title,
            description: description,
            rating: rating,
        };
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/review/' + reviewId, {
            method: 'put',
            body: JSON.stringify(review),
            headers: {
                'content-type': 'application/json',
            }
        }).then(response => response.json());
    }

    deleteReview(reviewId) {
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/review/' + reviewId, {
            method: 'delete'
        });
    }
}
