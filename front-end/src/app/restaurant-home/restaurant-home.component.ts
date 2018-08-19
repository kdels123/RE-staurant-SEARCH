import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';


@Component({
    selector: 'app-restaurant-home',
    templateUrl: './restaurant-home.component.html',
    styleUrls: ['./restaurant-home.component.css']
})
export class RestaurantHomeComponent implements OnInit {

    constructor(private router: Router,) {
    }

    search() {
        this.router.navigate(['search']);
    }

    login() {
        this.router.navigate(['login']);
    }

    register() {
        this.router.navigate(['register']);
    }


    ngOnInit() {
    }

}
