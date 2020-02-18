import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ImageThemesComponent } from './image-themes.component';

describe('ImageThemesComponent', () => {
  let component: ImageThemesComponent;
  let fixture: ComponentFixture<ImageThemesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ImageThemesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ImageThemesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
