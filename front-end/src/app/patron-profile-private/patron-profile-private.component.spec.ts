import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PatronProfilePrivateComponent } from './patron-profile-private.component';

describe('PatronProfilePrivateComponent', () => {
  let component: PatronProfilePrivateComponent;
  let fixture: ComponentFixture<PatronProfilePrivateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PatronProfilePrivateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PatronProfilePrivateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
