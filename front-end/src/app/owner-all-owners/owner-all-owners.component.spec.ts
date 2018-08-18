import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OwnerAllOwnersComponent } from './owner-all-owners.component';

describe('OwnerAllOwnersComponent', () => {
  let component: OwnerAllOwnersComponent;
  let fixture: ComponentFixture<OwnerAllOwnersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OwnerAllOwnersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OwnerAllOwnersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
