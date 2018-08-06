export class RestaurantServiceClient {

    token = 'Bearer _rSdKYm3xXCbQ_aE5Vw6q4xL5RxcwJgexzMo5-3-uLHBzDZCH_2xr0E_8C2oA4JHuHWckmGGRT0BvwF4vZzf-' +
        'l26J5CYJ2U53n7SFNweH90tUfr37m717OiqSXxoW3Yx';

    findRestaurantsByName(restaurantName) {
        return fetch('https://cors-anywhere.herokuapp.com/https://api.yelp.com/v3/businesses/' +
            'search?term=' + restaurantName + '&latitude=42.3601&longitude=-71.0589',
            {headers: {'Authorization': this.token}})
            .then(response => response.json());
    }
}