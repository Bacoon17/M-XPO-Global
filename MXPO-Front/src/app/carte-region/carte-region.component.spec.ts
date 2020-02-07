import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CarteRegionComponent } from './carte-region.component';

describe('CarteRegionComponent', () => {
  let component: CarteRegionComponent;
  let fixture: ComponentFixture<CarteRegionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CarteRegionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CarteRegionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
