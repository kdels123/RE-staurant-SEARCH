import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {UserServiceClient} from '../services/user.service.client';


@Component({
  selector: 'app-restaurant-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {

  constructor(private router: Router, private service: UserServiceClient) { }

  userId;
  username;
  password;
  role;

  setRole(role) {
    this.role = role;
  }

  login(username, password) {
    if (this.role === 'owner') {
          this.service.loginOwner(username, password)
              .then(user => (this.userId = user.id))
              .then(() => (this.router.navigate(['profile/' + this.userId])));
      }
  }

  goHome() {
    this.router.navigate(['home']);
  }

  goRegister() {
    this.router.navigate(['register']);
    }

  ngOnInit() {
  }

}
