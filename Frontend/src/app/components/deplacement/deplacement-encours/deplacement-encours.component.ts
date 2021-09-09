import { DeplacementService } from './../../../services/deplacement.service';
import { MapsService } from './maps.service';
import { Component, OnInit } from '@angular/core';
import { Deplacement } from 'src/app/models/deplacement';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-deplacement-encours',
  templateUrl: './deplacement-encours.component.html',
  styleUrls: ['./deplacement-encours.component.scss'],
})
export class DeplacementEncoursComponent implements OnInit {
  lat: number = 36.904317;
  lng: number = 10.18473;
  location: Object = Object;
  deplacements: Deplacement[] = [];
  deplacement: Deplacement = new Deplacement();
  constructor(
    private map: MapsService,
    private _deplacementService: DeplacementService
  ) {}

  ngOnInit(): void {
    // this.map.getLocation().subscribe((data) => {
    //console.log(data);
    //this.lat = data.latitude;
    //this.lng = data.longitude;
    //});
    this._deplacementService.GetAllDeplacement().subscribe(
      (response: Deplacement[]) => {
        this.deplacements = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
    for (let i of this.deplacements) {
      if ('enCours' in i.etat.toString) this.deplacement = i;
    }
  }
}
