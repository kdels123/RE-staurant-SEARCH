import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {AdminServiceClient} from '../services/admin.service.client';

@Component({
  selector: 'app-admin-profile-private',
  templateUrl: './admin-profile-private.component.html',
  styleUrls: ['./admin-profile-private.component.css']
})
export class AdminProfilePrivateComponent implements OnInit {

    constructor(private adminService: AdminServiceClient,
                private router: Router,
                private route: ActivatedRoute) {
        this.route.params.subscribe(params => this.loadUser(params['adminId']));

    }

    admin;
    adminId;
    username;
    firstName;
    lastName;
    email;
    phone;
    dob;

    loadUser(adminId) {
        this.adminId = adminId;
        this.adminService.findAdminById(this.adminId)
            .then(admin => this.loadProfile(admin));
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
        this.adminService.updateAdmin(firstName, lastName, email, phone, dob, this.adminId);
    }

    goToAllRestaurantOwners() {
        this.router.navigate(['/admin/' + this.adminId + '/owners']);
    }

    goToAllCritics() {
        this.router.navigate(['/admin/' + this.adminId + '/critics']);
    }

    goToAllPatrons() {
        this.router.navigate(['/admin/' + this.adminId + '/patrons']);
    }

    goToAllRestaurants() {
        this.router.navigate(['/admin/' + this.adminId + '/restaurants']);
    }

    goToAllEvents() {
        this.router.navigate(['/admin/' + this.adminId + '/events']);
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
