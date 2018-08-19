import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {OwnerServiceClient} from '../services/owner.service.client';

@Component({
  selector: 'app-owner-all-owners',
  templateUrl: './owner-all-owners.component.html',
  styleUrls: ['./owner-all-owners.component.css']
})
export class OwnerAllOwnersComponent implements OnInit {

    constructor(private router: Router,
                private route: ActivatedRoute,
                private ownerService: OwnerServiceClient) {
        this.route.params.subscribe(params => this.loadOwner(params['ownerId']));
    }


    adminId;

    owners;

    loadOwner(adminId) {
        this.adminId = adminId;
        this.ownerService.findAllOwners().then(owners => this.owners = owners);
    }

    deleteOwner(ownerId) {
        this.ownerService.deleteOwner(ownerId)
            .then(() => location.reload());
    }

    updateOwner(ownerId) {
        this.router.navigate(['profile/owner/' + ownerId]);
    }

    goToProfile() {
        this.router.navigate(['home']);
    }

    goHome() {
        this.router.navigate(['home']);
    }


    ngOnInit() {
    }

}
