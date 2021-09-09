import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ItineraireNewComponent } from './itineraire-new.component';

describe('ItineraireNewComponent', () => {
  let component: ItineraireNewComponent;
  let fixture: ComponentFixture<ItineraireNewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ItineraireNewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ItineraireNewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
