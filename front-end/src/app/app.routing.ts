import {Routes, RouterModule} from '@angular/router';
import {RestaurantHomeComponent} from './restaurant-home/restaurant-home.component';
import {RestaurantSearchComponent} from './restaurant-search/restaurant-search.component';
import {UserLoginComponent} from './user-login/user-login.component';
import {UserRegisterComponent} from './user-register/user-register.component';
import {OwnerProfilePrivateComponent} from './owner-profile-private/owner-profile-private.component';
import {RestaurantDetailComponent} from './restaurant-detail/restaurant-detail.component';
import {CriticProfileComponent} from './critic-profile/critic-profile.component';
import {CriticProfilePrivateComponent} from './critic-profile-private/critic-profile-private.component';
import {PatronProfilePrivateComponent} from './patron-profile-private/patron-profile-private.component';
import {PatronProfileComponent} from './patron-profile/patron-profile.component';
import {EventCreateComponent} from './event-create/event-create.component';

const appRoutes: Routes = [
    {path: '', redirectTo: 'home', pathMatch: 'full'},
    {path: 'home', component: RestaurantHomeComponent},
    {path: 'search', component: RestaurantSearchComponent},
    {path: 'restaurant/:restaurantId', component: RestaurantDetailComponent},
    {path: 'restaurant/:restaurantId/event', component: EventCreateComponent},
    {path: 'login', component: UserLoginComponent},
    {path: 'register', component: UserRegisterComponent},
    {path: 'profile/owner/:ownerId', component: OwnerProfilePrivateComponent},
    {path: 'critic/:criticId', component: CriticProfileComponent},
    {path: 'profile/critic/:criticId', component: CriticProfilePrivateComponent},
    {path: 'patron/:patronId', component: PatronProfileComponent},
    {path: 'profile/patron/:patronId', component: PatronProfilePrivateComponent}


];

export const routing = RouterModule.forRoot(appRoutes);


