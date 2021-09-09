import { DeplacementService } from './../../../services/deplacement.service';
import { Deplacement } from './../../../models/deplacement';
import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-deplacement-list',
  templateUrl: './deplacement-list.component.html',
  styleUrls: ['./deplacement-list.component.scss'],
})
export class DeplacementListComponent implements OnInit {
  Deplacements: Deplacement[] = [];
  constructor(private _deplacementService: DeplacementService) {}

  ngOnInit(): void {
    this._deplacementService.GetAllDeplacement().subscribe(
      (response: Deplacement[]) => {
        this.Deplacements = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
}
