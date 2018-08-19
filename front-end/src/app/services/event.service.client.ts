export class EventServiceClient {


    findEventById(eventId) {
        return fetch('http://localhost:8080/api/event/' + eventId)
            .then(response => response.json());
    }


    findAllEvents() {
        return fetch('http://localhost:8080/api/event/')
            .then(function (response) {
                return response.json();
            });
    }

    findEventsByRestaurant(restaurantId) {
        return fetch('http://localhost:8080/api/restaurant/' + restaurantId + '/event')
            .then(function (response) { return response.json();
            });
    }

    findEventsByOwner(ownerId) {
        return fetch('http://localhost:8080/api/owner/' + ownerId + '/event')
            .then(function (response) { return response.json();
            });
    }

    findEventsByCritic(criticId) {
        return fetch('http://localhost:8080/api/critic/' + criticId + '/event')
            .then(function (response) {
                return response.json();
            });
    }

    findEventsByPatron(patronId) {
        return fetch('http://localhost:8080/api/patron/' + patronId + '/event')
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
        return fetch('http://localhost:8080/api/owner/' + ownerId + '/restaurant/' + restaurantId + '/event', {
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
        return fetch('http://localhost:8080/api/event/' + eventId, {
            method: 'put',
            body: JSON.stringify(event),
            headers: {
                'content-type': 'application/json',
            }
        }).then(response => response.json());
    }

    deleteEvent(eventId) {
        return fetch('http://localhost:8080/api/event/' + eventId, {
            method: 'delete'
        });
    }
}


