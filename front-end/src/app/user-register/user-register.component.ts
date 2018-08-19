import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {OwnerServiceClient} from '../services/owner.service.client';
import {CriticServiceClient} from '../services/critic.service.client';
import {PatronServiceClient} from '../services/patron.service.client';
import {AdminServiceClient} from '../services/admin.service.client';

@Component({
  selector: 'app-restaurant-register',
  templateUrl: './user-register.component.html',
  styleUrls: ['./user-register.component.css']
})
export class UserRegisterComponent implements OnInit {

  constructor(private router: Router,
              private adminService: AdminServiceClient,
              private ownerService: OwnerServiceClient,
              private criticService: CriticServiceClient,
              private patronService: PatronServiceClient) { }

  username;
  role = null;
  passwordI;
  passwordII;
  userId;

  setRole(role) {
    this.role = role;
  }

  register(username, passwordI, passwordII) {
    if (passwordI !== passwordII) {
      alert('passwords do not match');
    } else if (this.role === null) {
        alert('please specify user type');
    }
    else if (this.role === 'patron') {
        this.patronService.createPatron(username, passwordI)
            .then(user => (this.userId = user.id))
            .then(() => (this.router.navigate(['profile/patron/' + this.userId])))
            .catch(() => alert('Useranme already exists, please try again'));
    } else if (this.role === 'owner') {
      this.ownerService.createOwner(username, passwordI)
          .then(user => (this.userId = user.id))
          .then(() => (this.router.navigate(['profile/owner/' + this.userId])))
          .catch(() => alert('Useranme already exists, please try again'));
    } else if (this.role === 'critic') {
        this.criticService.createCritic(username, passwordI)
            .then(user => (this.userId = user.id))
            .then(() => (this.router.navigate(['profile/critic/' + this.userId])))
            .catch(() => alert('Useranme already exists, please try again'));
    } else if (this.role === 'admin') {
        this.adminService.createAdmin(username, passwordI)
            .then(user => (this.userId = user.id))
            .then(() => (this.router.navigate(['profile/admin/' + this.userId])))
            .catch(() => alert('Useranme already exists, please try again'));
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
