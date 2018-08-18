import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PatronAllPatronsComponent } from './patron-all-patrons.component';

describe('PatronAllPatronsComponent', () => {
  let component: PatronAllPatronsComponent;
  let fixture: ComponentFixture<PatronAllPatronsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PatronAllPatronsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PatronAllPatronsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
