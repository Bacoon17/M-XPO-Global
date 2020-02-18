import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListeDeroulanteThemesComponent } from './liste-deroulante-themes.component';

describe('ListeDeroulanteThemesComponent', () => {
  let component: ListeDeroulanteThemesComponent;
  let fixture: ComponentFixture<ListeDeroulanteThemesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListeDeroulanteThemesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListeDeroulanteThemesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
