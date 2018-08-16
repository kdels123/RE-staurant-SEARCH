import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {UserServiceClient} from '../services/user.service.client';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  constructor(private service: UserServiceClient,
              private router: Router,
              private route: ActivatedRoute) {
      this.route.params.subscribe(params => this.loadUser(params['userId']));

  }

  user;
  userId;
  username;
  firstName;
  lastName;
  email;
  phone;
  dob;

  loadUser(userId) {
    this.userId = userId;
    this.service.findUserById(userId)
        .then(user => this.loadProfile(user));
  }

  loadProfile(user) {
    this.username = user.username;
    this.firstName = user.firstName;
    this.lastName = user.lastName;
    this.email = user.email;
    this.phone = user.phone;
    this.dob = user.dob;
  }

  update(firstName, lastName, email, phone, dob) {
    this.service.updateUser(firstName, lastName, email, phone, dob, this.userId);
  }

  logout() {
      this.router.navigate(['home']);
  }

  ngOnInit() {
  }

}
