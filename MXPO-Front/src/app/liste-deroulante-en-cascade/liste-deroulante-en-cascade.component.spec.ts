import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListeDeroulanteEnCascadeComponent } from './liste-deroulante-en-cascade.component';

describe('ListeDeroulanteEnCascadeComponent', () => {
  let component: ListeDeroulanteEnCascadeComponent;
  let fixture: ComponentFixture<ListeDeroulanteEnCascadeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListeDeroulanteEnCascadeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListeDeroulanteEnCascadeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
