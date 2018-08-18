import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {CriticServiceClient} from '../services/critic.service.client';

@Component({
  selector: 'app-citic-all-critics',
  templateUrl: './critic-all-critics.component.html',
  styleUrls: ['./critic-all-critics.component.css']
})
export class CriticAllCriticsComponent implements OnInit {

  constructor(private router: Router,
              private route: ActivatedRoute,
              private criticService: CriticServiceClient) {
    this.route.params.subscribe(params => this.loadCritic(params['adminId']));
  }


  adminId;

  critics;

  loadCritic(adminId) {
    this.adminId = adminId;
      this.criticService.findAllCritics().then(critics => this.critics = critics);
  }

  deleteCritic(criticId) {
      this.criticService.deleteCritic(criticId)
          .then(() => location.reload());
  }

  goToProfile() {
      this.router.navigate(['admin/' + this.adminId]);
  }

    goHome() {
        this.router.navigate(['home']);
    }


    ngOnInit() {
  }

}
