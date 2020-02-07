import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TableauResultatMuseeComponent } from './tableau-resultat-musee.component';

describe('TableauResultatMuseeComponent', () => {
  let component: TableauResultatMuseeComponent;
  let fixture: ComponentFixture<TableauResultatMuseeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TableauResultatMuseeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TableauResultatMuseeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
