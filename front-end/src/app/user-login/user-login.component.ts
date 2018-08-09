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

  username;
  password;

  login(username, password) {
    this.service.login(username, password)
        .then(() =>  this.router.navigate(['profile']));
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
