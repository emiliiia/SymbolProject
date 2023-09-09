import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DirectionsSliderComponent } from './directions-slider.component';

describe('DirectionsSliderComponent', () => {
  let component: DirectionsSliderComponent;
  let fixture: ComponentFixture<DirectionsSliderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DirectionsSliderComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DirectionsSliderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
