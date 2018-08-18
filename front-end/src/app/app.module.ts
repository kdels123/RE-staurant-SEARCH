import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { RestaurantSearchComponent } from './restaurant-search/restaurant-search.component';
import { RestaurantHomeComponent } from './restaurant-home/restaurant-home.component';
import {RestaurantServiceClient} from './services/restaurant.service.client';
import {FormsModule} from '@angular/forms';
import {routing} from './app.routing';
import { UserLoginComponent } from './user-login/user-login.component';
import { UserRegisterComponent } from './user-register/user-register.component';
import { OwnerProfilePrivateComponent } from './owner-profile-private/owner-profile-private.component';
import { UserServiceClient } from './services/user.service.client';
import { RestaurantDetailComponent } from './restaurant-detail/restaurant-detail.component';
import { ReviewServiceClient } from './services/review.service.client';
import { CriticServiceClient } from './services/critic.service.client';
import { CriticProfileComponent } from './critic-profile/critic-profile.component';
import { CriticProfilePrivateComponent } from './critic-profile-private/critic-profile-private.component';
import {OwnerServiceClient} from './services/owner.service.client';
import { PatronProfilePrivateComponent } from './patron-profile-private/patron-profile-private.component';
import {PatronServiceClient} from './services/patron.service.client';
import { PatronProfileComponent } from './patron-profile/patron-profile.component';
import { EventCreateComponent } from './event-create/event-create.component';
import {EventServiceClient} from './services/event.service.client';
import { EventDetailComponent } from './event-detail/event-detail.component';


@NgModule({
  declarations: [
    AppComponent,
    RestaurantSearchComponent,
    RestaurantHomeComponent,
    UserLoginComponent,
    UserRegisterComponent,
    OwnerProfilePrivateComponent,
    RestaurantDetailComponent,
    CriticProfileComponent,
    CriticProfilePrivateComponent,
    PatronProfilePrivateComponent,
    PatronProfileComponent,
    EventCreateComponent,
    EventDetailComponent
  ],
  imports: [
    BrowserModule,
      FormsModule,
      routing
  ],
  providers: [
      RestaurantServiceClient,
      UserServiceClient,
      ReviewServiceClient,
      CriticServiceClient,
      OwnerServiceClient,
      PatronServiceClient,
      EventServiceClient
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
