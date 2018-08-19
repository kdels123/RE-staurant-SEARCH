import { Component, OnInit } from '@angular/core';
import {OwnerServiceClient} from '../services/owner.service.client';
import {CriticServiceClient} from '../services/critic.service.client';
import {AdminServiceClient} from '../services/admin.service.client';
import {ActivatedRoute, Router} from '@angular/router';
import {PatronServiceClient} from '../services/patron.service.client';

@Component({
  selector: 'app-admin-register',
  templateUrl: './admin-register.component.html',
  styleUrls: ['./admin-register.component.css']
})
export class AdminRegisterComponent implements OnInit {

    constructor(private router: Router,
                private route: ActivatedRoute,
                private adminService: AdminServiceClient,
                private ownerService: OwnerServiceClient,
                private criticService: CriticServiceClient,
                private patronService: PatronServiceClient) {
        this.route.params.subscribe(params => this.loadAdmin(params['adminId']));
    }

    adminId;
    username;
    role = null;
    passwordI;
    passwordII;
    userId;

    setRole(role) {
        this.role = role;
    }

    loadAdmin(adminId) {
        this.adminId = adminId;
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
        }
    }

    goHome() {
        this.router.navigate(['home']);
    }

    goToProfile() {
        this.router.navigate(['profile/admin/' + this.adminId]);
    }


    ngOnInit() {
    }

}
