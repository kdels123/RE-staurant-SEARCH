import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  constructor(private router: Router) { }

  username;
  password;
  firstName;
  lastName;
  email;
  phone;
  dob;

  update(username, password, firstName, lastName, email, phone, dob) {
    return;
  }

  logout() {
      this.router.navigate(['home']);
  }

  ngOnInit() {
  }

}
