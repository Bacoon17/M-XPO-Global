import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MuseeComponent } from './musee.component';

describe('MuseeComponent', () => {
  let component: MuseeComponent;
  let fixture: ComponentFixture<MuseeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MuseeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MuseeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
