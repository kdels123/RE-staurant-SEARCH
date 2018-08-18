import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CriticProfilePrivateComponent } from './critic-profile-private.component';

describe('CriticProfilePrivateComponent', () => {
  let component: CriticProfilePrivateComponent;
  let fixture: ComponentFixture<CriticProfilePrivateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CriticProfilePrivateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CriticProfilePrivateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
