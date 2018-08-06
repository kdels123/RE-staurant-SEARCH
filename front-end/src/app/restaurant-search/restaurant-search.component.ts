import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-restaurant-search',
  templateUrl: './restaurant-search.component.html',
  styleUrls: ['./restaurant-search.component.css']
})
export class RestaurantSearchComponent implements OnInit {

  token = 'Bearer _rSdKYm3xXCbQ_aE5Vw6q4xL5RxcwJgexzMo5-3-uLHBzDZCH_2xr0E_8C2oA4JHuHWckmGGRT0BvwF4vZzf-' +
      'l26J5CYJ2U53n7SFNweH90tUfr37m717OiqSXxoW3Yx';

    restaurants = [
        {name: 'Legal Seafoods'},
        {name: 'Barking Crab'},
        {name: 'Babbo'}];

    // requestObj = {
    //     url: this.url,
    //     data: {term: 'deli', latitude: 42.3601, longitude: -71.0589},
    //     headers: {'Authorization': this.token}
    // }

    constructor() { }

  ngOnInit() {
      fetch('https://cors-anywhere.herokuapp.com/https://api.yelp.com/v3/businesses/search?term=delis&latitude=42.3601&longitude=-71.0589',
          {headers: {'Authorization': this.token}})
          .then(response => response.json())
          .then(res => this.restaurants = res.businesses);
  }

}
