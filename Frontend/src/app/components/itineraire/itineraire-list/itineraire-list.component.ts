import { ItineraireService } from './../../../services/itineraire.service';
import { Itineraire } from './../../../models/itineraire';
import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-itineraire-list',
  templateUrl: './itineraire-list.component.html',
  styleUrls: ['./itineraire-list.component.scss'],
})
export class ItineraireListComponent implements OnInit {
  Itineraires: Itineraire[] = [];
  id = 1;
  constructor(private _itineraireService: ItineraireService) {}

  ngOnInit(): void {
    this._itineraireService.GetAllItineraireByDeplacementId(this.id).subscribe(
      (response: Itineraire[]) => {
        this.Itineraires = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
}
