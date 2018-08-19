export class EventServiceClient {


    findEventById(eventId) {
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/event/' + eventId)
            .then(response => response.json());
    }


    findAllEvents() {
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/event/')
            .then(function (response) {
                return response.json();
            });
    }

    findEventsByRestaurant(restaurantId) {
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/restaurant/' + restaurantId + '/event')
            .then(function (response) { return response.json();
            });
    }

    findEventsByOwner(ownerId) {
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/owner/' + ownerId + '/event')
            .then(function (response) { return response.json();
            });
    }

    findEventsByCritic(criticId) {
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/critic/' + criticId + '/event')
            .then(function (response) {
                return response.json();
            });
    }

    findEventsByPatron(patronId) {
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/patron/' + patronId + '/event')
            .then(function (response) {
                return response.json();
            });
    }

    createEvent(title, description, dateTime, price, attire, ownerId, restaurantId) {
        const event = {
            title: title,
            description: description,
            dateTime: dateTime,
            price: price,
            attire: attire
        };
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/owner/' + ownerId + '/restaurant/' + restaurantId + '/event', {
            method: 'post',
            body: JSON.stringify(event),
            credentials: 'same-origin',
            headers: {
                'content-type': 'application/json',
            }
        }).then(response => response.json());
    }

    updateEvent(title, description, dateTime, price, attire, eventId) {
        const event = {
            title: title,
            description: description,
            dateTime: dateTime,
            price: price,
            attire: attire
        };
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/event/' + eventId, {
            method: 'put',
            body: JSON.stringify(event),
            headers: {
                'content-type': 'application/json',
            }
        }).then(response => response.json());
    }

    deleteEvent(eventId) {
        return fetch('http://cs5200-final-project-delsener-lo.us-east-2.elasticbeanstalk.com/api/event/' + eventId, {
            method: 'delete'
        });
    }
}


