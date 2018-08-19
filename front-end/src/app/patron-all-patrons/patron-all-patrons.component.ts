import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {PatronServiceClient} from '../services/patron.service.client';

@Component({
  selector: 'app-patron-all-patrons',
  templateUrl: './patron-all-patrons.component.html',
  styleUrls: ['./patron-all-patrons.component.css']
})
export class PatronAllPatronsComponent implements OnInit {

    constructor(private router: Router,
                private route: ActivatedRoute,
                private patronService: PatronServiceClient) {
        this.route.params.subscribe(params => this.loadPatron(params['adminId']));
    }


    adminId;

    patrons;

    loadPatron(adminId) {
        this.adminId = adminId;
        this.patronService.findAllPatrons().then(patrons => this.patrons = patrons);
    }

    deletePatron(patronId) {
        this.patronService.deletePatron(patronId)
            .then(() => location.reload());
    }

    updatePatron(patronId) {
        this.router.navigate(['profile/patron/' + patronId]);
    }

    goToProfile() {
        this.router.navigate(['profile/admin/' + this.adminId]);
    }

    goHome() {
        this.router.navigate(['home']);
    }


    ngOnInit() {
    }

}
