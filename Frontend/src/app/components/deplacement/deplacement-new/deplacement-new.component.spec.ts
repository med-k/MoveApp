import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeplacementNewComponent } from './deplacement-new.component';

describe('DeplacementNewComponent', () => {
  let component: DeplacementNewComponent;
  let fixture: ComponentFixture<DeplacementNewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeplacementNewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeplacementNewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
