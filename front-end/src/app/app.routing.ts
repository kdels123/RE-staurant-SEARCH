import {Routes, RouterModule} from '@angular/router';
import {RestaurantHomeComponent} from './restaurant-home/restaurant-home.component';
import {RestaurantSearchComponent} from './restaurant-search/restaurant-search.component';

const appRoutes: Routes = [
    {path: '', redirectTo: 'home', pathMatch: 'full'},
    {path: 'home', component: RestaurantHomeComponent},
    {path: 'search', component: RestaurantSearchComponent}
];

export const routing = RouterModule.forRoot(appRoutes);


