import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeplacementEncoursComponent } from './deplacement-encours.component';

describe('DeplacementEncoursComponent', () => {
  let component: DeplacementEncoursComponent;
  let fixture: ComponentFixture<DeplacementEncoursComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeplacementEncoursComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeplacementEncoursComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
