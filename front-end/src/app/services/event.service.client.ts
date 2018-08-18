export class EventServiceClient {

    createEvent(title, description, dateTime, price, attire, ownerId, restaurantId) {
        const review = {
            title: title,
            description: description,
            dateTime: dateTime,
            price: price,
            attire: attire
        };
        return fetch('http://localhost:8080/api/owner/' + ownerId + '/restaurant/' + restaurantId + '/event', {
            method: 'post',
            body: JSON.stringify(review),
            headers: {
                'content-type': 'application/json',
                'Access-Control-Allow-Origin': 'http://localhost:8080'
            }
        }).then(response => response.json());
    }
}
