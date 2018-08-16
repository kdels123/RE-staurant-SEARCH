import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {UserServiceClient} from '../services/user.service.client';

@Component({
  selector: 'app-restaurant-register',
  templateUrl: './user-register.component.html',
  styleUrls: ['./user-register.component.css']
})
export class UserRegisterComponent implements OnInit {

  constructor(private router: Router, private service: UserServiceClient) { }

  username;
  role;
  passwordI;
  passwordII;
  userId;

  setRole(role) {
    this.role = role;
  }

  register(username, passwordI, passwordII) {
    if (passwordI !== passwordII) {
      alert('passwords do not match');
    } else if (this.role === 'patron') {
        this.service.createPatron(username, passwordI)
            .then(() => this.router.navigate(['profile']));
    } else if (this.role === 'owner') {
      this.service.createOwner(username, passwordI)
          .then(user => (
              this.userId = user.id))
          .then(() => (
              this.router.navigate(['profile/' + this.userId])));
    } else if (this.role === 'critic') {
        this.service.createCritic(username, passwordI)
            .then(() => this.router.navigate(['profile']));
    } else if (this.role === 'admin') {
        this.service.createAdmin(username, passwordI)
            .then(() => this.router.navigate(['profile']));
    }
  }

  goHome() {
    this.router.navigate(['home']);
  }

  goLogin() {
    this.router.navigate(['login']);
  }


  ngOnInit() {
  }

}
