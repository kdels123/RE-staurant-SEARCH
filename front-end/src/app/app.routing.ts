import {Routes, RouterModule} from '@angular/router';
import {RestaurantHomeComponent} from './restaurant-home/restaurant-home.component';
import {RestaurantSearchComponent} from './restaurant-search/restaurant-search.component';
import {UserLoginComponent} from './user-login/user-login.component';
import {UserRegisterComponent} from './user-register/user-register.component';
import {UserProfileComponent} from './user-profile/user-profile.component';
import {RestaurantDetailComponent} from './restaurant-detail/restaurant-detail.component';

const appRoutes: Routes = [
    {path: '', redirectTo: 'home', pathMatch: 'full'},
    {path: 'home', component: RestaurantHomeComponent},
    {path: 'search', component: RestaurantSearchComponent},
    {path: 'restaurant/:restaurantId', component: RestaurantDetailComponent},
    {path: 'login', component: UserLoginComponent},
    {path: 'register', component: UserRegisterComponent},
    {path: 'profile', component: UserProfileComponent}
];

export const routing = RouterModule.forRoot(appRoutes);


