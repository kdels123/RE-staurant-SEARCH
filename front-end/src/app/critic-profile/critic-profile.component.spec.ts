import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CriticProfileComponent } from './critic-profile.component';

describe('CriticProfileComponent', () => {
  let component: CriticProfileComponent;
  let fixture: ComponentFixture<CriticProfileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CriticProfileComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CriticProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
