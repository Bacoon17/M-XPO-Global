import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FicheMuseeComponent } from './fiche-musee.component';

describe('FicheMuseeComponent', () => {
  let component: FicheMuseeComponent;
  let fixture: ComponentFixture<FicheMuseeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FicheMuseeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FicheMuseeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
