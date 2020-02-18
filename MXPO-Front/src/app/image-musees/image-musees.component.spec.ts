import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ImageMuseesComponent } from './image-musees.component';

describe('ImageMuseesComponent', () => {
  let component: ImageMuseesComponent;
  let fixture: ComponentFixture<ImageMuseesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ImageMuseesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ImageMuseesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
