import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CriticAllCriticsComponent } from './critic-all-critics.component';

describe('CriticAllCriticsComponent', () => {
  let component: CriticAllCriticsComponent;
  let fixture: ComponentFixture<CriticAllCriticsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CriticAllCriticsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CriticAllCriticsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
