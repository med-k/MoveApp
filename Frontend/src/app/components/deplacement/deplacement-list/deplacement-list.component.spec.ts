import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeplacementListComponent } from './deplacement-list.component';

describe('DeplacementListComponent', () => {
  let component: DeplacementListComponent;
  let fixture: ComponentFixture<DeplacementListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeplacementListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeplacementListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
