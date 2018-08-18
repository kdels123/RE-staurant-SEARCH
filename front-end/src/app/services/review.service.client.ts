export class ReviewServiceClient {

    addReview(title, description, rating, criticId, restaurantId) {
        const review = {
            title: title,
            description: description,
            rating: rating,
        };
        return fetch('http://localhost:8080/api/critic/' + criticId + '/restaurant/' + restaurantId + '/review', {
            method: 'post',
            body: JSON.stringify(review),
            headers: {
                'content-type': 'application/json',
                'Access-Control-Allow-Origin': 'http://localhost:8080'
            }
        }).then(response => response.json());
    }

    findReviewsByCritic(criticId) {
        return fetch('http://localhost:8080/api/critic/' + criticId + '/review')
            .then(function (response) { return response.json();
            });
    }

    findReviewsByRestaurant(restaurantId) {
        return fetch('http://localhost:8080/api/restaurant/' + restaurantId + '/review')
            .then(function (response) { return response.json();
            });
    }
}
