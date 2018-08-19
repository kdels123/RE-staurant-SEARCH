import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {UserServiceClient} from '../services/user.service.client';
import {CriticServiceClient} from '../services/critic.service.client';
import {OwnerServiceClient} from '../services/owner.service.client';
import {PatronServiceClient} from '../services/patron.service.client';
import {AdminServiceClient} from '../services/admin.service.client';


@Component({
  selector: 'app-restaurant-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {

  constructor(private router: Router,
              private adminService: AdminServiceClient,
              private criticService: CriticServiceClient,
              private ownerService: OwnerServiceClient,
              private patronService: PatronServiceClient) { }

  userId;
  username;
  password;
  role;

  setRole(role) {
    this.role = role;
  }

  login(username, password) {
    if (this.role === 'owner') {
          this.ownerService.loginOwner(username, password)
              .then(user => (this.userId = user.id))
              .then(() => (this.router.navigate(['profile/owner/' + this.userId])))
              .catch(() => alert('Username and/or Password are not Valid'));
      } else if  (this.role === 'critic') {
        this.criticService.loginCritic(username, password)
            .then(user => (this.userId = user.id))
            .then(() => (this.router.navigate(['profile/critic/' + this.userId])));
    } else if (this.role === 'patron') {
        this.patronService.loginPatron(username, password)
            .then(user => (this.userId = user.id))
            .then(() => (this.router.navigate(['profile/patron/' + this.userId])));
    } else if (this.role === 'admin') {
        this.adminService.loginAdmin(username, password)
            .then(user => (this.userId = user.id))
            .then(() => (this.router.navigate(['profile/admin/' + this.userId])));
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
