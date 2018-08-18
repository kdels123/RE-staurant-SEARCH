import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {CriticServiceClient} from '../services/critic.service.client';

@Component({
  selector: 'app-critic-profile-private',
  templateUrl: './critic-profile-private.component.html',
  styleUrls: ['./critic-profile-private.component.css']
})
export class CriticProfilePrivateComponent implements OnInit {

    constructor(private criticService: CriticServiceClient,
                private router: Router,
                private route: ActivatedRoute) {
        this.route.params.subscribe(params => this.loadUser(params['criticId']));

    }

    critic;
    criticId;
    username;
    firstName;
    lastName;
    email;
    phone;
    dob;

    loadUser(criticId) {
        this.criticId = criticId;
        this.criticService.findCriticById(this.criticId)
            .then(critic => this.loadProfile(critic));
    }

    loadProfile(user) {
        this.username = user.username;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.email = user.email;
        this.phone = user.phone;
        this.dob = this.styleDate(user.dob);
    }

    update(firstName, lastName, email, phone, dob) {
        this.criticService.updateCritic(firstName, lastName, email, phone, dob, this.criticId);
    }

    logout() {
        this.router.navigate(['home']);
    }

    styleDate(date) {
     return date.substring(0, 10);
    }

  ngOnInit() {
  }

}
