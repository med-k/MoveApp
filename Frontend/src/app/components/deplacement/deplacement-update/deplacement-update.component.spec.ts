import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeplacementUpdateComponent } from './deplacement-update.component';

describe('DeplacementUpdateComponent', () => {
  let component: DeplacementUpdateComponent;
  let fixture: ComponentFixture<DeplacementUpdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeplacementUpdateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeplacementUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
