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
import {EventDetailComponent} from './event-detail/event-detail.component';
import {AdminProfilePrivateComponent} from './admin-profile-private/admin-profile-private.component';
import {OwnerAllOwnersComponent} from './owner-all-owners/owner-all-owners.component';
import {CriticAllCriticsComponent} from './critic-all-critics/critic-all-critics.component';
import {PatronAllPatronsComponent} from './patron-all-patrons/patron-all-patrons.component';
import {RestaurantAllRestaurantsComponent} from './restaurant-all-restaurants/restaurant-all-restaurants.component';
import {EventAllEventsComponent} from './event-all-events/event-all-events.component';
import {OwnerProfileComponent} from './owner-profile/owner-profile.component';
import {AdminRegisterComponent} from './admin-register/admin-register.component';

const appRoutes: Routes = [
    {path: '', redirectTo: 'home', pathMatch: 'full'},
    {path: 'home', component: RestaurantHomeComponent},
    {path: 'search', component: RestaurantSearchComponent},
    {path: 'restaurant/:restaurantId', component: RestaurantDetailComponent},
    {path: 'restaurant/:restaurantId/event', component: EventCreateComponent},
    {path: 'restaurant/:restaurantId/event/:eventId', component: EventDetailComponent},
    {path: 'login', component: UserLoginComponent},
    {path: 'register', component: UserRegisterComponent},
    {path: 'admin/:adminId/register', component: AdminRegisterComponent},
    {path: 'profile/admin/:adminId', component: AdminProfilePrivateComponent},
    {path: 'owner/:ownerId', component: OwnerProfileComponent},
    {path: 'profile/owner/:ownerId', component: OwnerProfilePrivateComponent},
    {path: 'critic/:criticId', component: CriticProfileComponent},
    {path: 'profile/critic/:criticId', component: CriticProfilePrivateComponent},
    {path: 'patron/:patronId', component: PatronProfileComponent},
    {path: 'profile/patron/:patronId', component: PatronProfilePrivateComponent},
    {path: 'admin/:adminId/owners', component: OwnerAllOwnersComponent},
    {path: 'admin/:adminId/critics', component: CriticAllCriticsComponent},
    {path: 'admin/:adminId/patrons', component: PatronAllPatronsComponent},
    {path: 'admin/:adminId/restaurants', component: RestaurantAllRestaurantsComponent},
    {path: 'admin/:adminId/events', component: EventAllEventsComponent},


];

export const routing = RouterModule.forRoot(appRoutes);


