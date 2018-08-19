import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RestaurantAllRestaurantsComponent } from './restaurant-all-restaurants.component';

describe('RestaurantAllRestaurantsComponent', () => {
  let component: RestaurantAllRestaurantsComponent;
  let fixture: ComponentFixture<RestaurantAllRestaurantsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RestaurantAllRestaurantsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RestaurantAllRestaurantsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
