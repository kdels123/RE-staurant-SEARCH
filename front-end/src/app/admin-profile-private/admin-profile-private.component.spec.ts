import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminProfilePrivateComponent } from './admin-profile-private.component';

describe('AdminProfilePrivateComponent', () => {
  let component: AdminProfilePrivateComponent;
  let fixture: ComponentFixture<AdminProfilePrivateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminProfilePrivateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminProfilePrivateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
