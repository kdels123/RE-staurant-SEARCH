export class RestaurantServiceClient {

    token = 'Bearer _rSdKYm3xXCbQ_aE5Vw6q4xL5RxcwJgexzMo5-3-uLHBzDZCH_2xr0E_8C2oA4JHuHWckmGGRT0BvwF4vZzf-' +
        'l26J5CYJ2U53n7SFNweH90tUfr37m717OiqSXxoW3Yx';

    findRestaurantsByName(restaurantName) {
        return fetch('https://cors-anywhere.herokuapp.com/https://api.yelp.com/v3/businesses/' +
            'search?term=' + restaurantName + '&latitude=42.3601&longitude=-71.0589',
            {headers: {'Authorization': this.token}})
            .then(response => response.json());
    }

    findAllRestaurants() {
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/restaurant/')
            .then(function (response) {
                return response.json();
            });
    }

    findRestaurantByName(restaurant) {
        const data = {
            name: restaurant.alias
        };
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/restaurant/name', {
            method: 'post',
            body: JSON.stringify(data),
            headers: {
                'content-type': 'application/json',
            }
        }).then(response => response.json());
    }

    findRestaurantById(restaurantId) {
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/restaurant/' + restaurantId).then(response => response.json());
    }

    findRestaurantsByPatron(patronId) {
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/patron/' + patronId + '/restaurant')
            .then(function (response) {
                return response.json();
            });
    }

    findRestaurantsByOwner(ownerId) {
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/owner/' + ownerId + '/restaurant')
            .then(function (response) {
                return response.json();
            });
    }

    addRestaurantWithOwner(name, address, city, state, phone, price, ownerId) {
        const data = {
            name: name,
            yelpId: '',
            address: address,
            city: city,
            state: state,
            phone: phone,
            numberOfVisits: '',
            price: price,
        };
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/owner/' + ownerId + '/restaurant', {
            method: 'post',
            body: JSON.stringify(data),
            headers: {
                'content-type': 'application/json',
            }
        }).then(response => response.json());
    }

    addRestaurant(restaurant) {
        const data = {
            name: restaurant.alias,
            yelpId: restaurant.id,
            address: restaurant.location.address1,
            city: restaurant.location.city,
            state: restaurant.location.state,
            phone: restaurant.phone,
            numberOfVisits: restaurant.review_count,
            price: restaurant.price,
            imageUrl: restaurant.image_url
        };
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/restaurant', {
            method: 'post',
            body: JSON.stringify(data),
            headers: {
                'content-type': 'application/json',
            }
        }).then(response => response.json());
    }

    updateRestaurant(restaurantName, restaurantAddress, restaurantCity,
                     restaurantState, restaurantPhone, restaurantPrice, restaurantId) {
        const data = {
            name: restaurantName,
            address: restaurantAddress,
            city: restaurantCity,
            state: restaurantState,
            phone: restaurantPhone,
            price: restaurantPrice,
        };
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/restaurant/' + restaurantId, {
            method: 'put',
            body: JSON.stringify(data),
            headers: {
                'content-type': 'application/json',
            }
        }).then(response => response.json());
    }

    deleteRestaurant(restaurantId) {
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/restaurant/' + restaurantId, {
            method: 'delete'
        });
    }


}
