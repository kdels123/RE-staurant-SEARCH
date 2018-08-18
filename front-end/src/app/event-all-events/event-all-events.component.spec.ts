import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EventAllEventsComponent } from './event-all-events.component';

describe('EventAllEventsComponent', () => {
  let component: EventAllEventsComponent;
  let fixture: ComponentFixture<EventAllEventsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EventAllEventsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EventAllEventsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
