import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {UserServiceClient} from '../services/user.service.client';
import {OwnerServiceClient} from '../services/owner.service.client';

@Component({
  selector: 'app-user-profile',
  templateUrl: './owner-profile-private.component.html',
  styleUrls: ['./owner-profile-private.component.css']
})
export class OwnerProfilePrivateComponent implements OnInit {

  constructor(private ownerService: OwnerServiceClient,
              private router: Router,
              private route: ActivatedRoute) {
      this.route.params.subscribe(params => this.loadUser(params['ownerId']));
  }

  user;
  userId;
  username;
  firstName;
  lastName;
  email;
  phone;
  dob;

  loadUser(ownerId) {
    this.userId = ownerId;
    this.ownerService.findOwnerById(this.userId)
        .then(user => this.loadProfile(user));
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
    this.ownerService.updateOwner(firstName, lastName, email, phone, dob, this.userId);
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
