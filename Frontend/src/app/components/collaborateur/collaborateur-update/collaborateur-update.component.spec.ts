import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CollaborateurUpdateComponent } from './collaborateur-update.component';

describe('CollaborateurUpdateComponent', () => {
  let component: CollaborateurUpdateComponent;
  let fixture: ComponentFixture<CollaborateurUpdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CollaborateurUpdateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CollaborateurUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
