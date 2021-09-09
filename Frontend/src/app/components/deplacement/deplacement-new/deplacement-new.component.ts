import { DeplacementService } from './../../../services/deplacement.service';
import { Deplacement } from './../../../models/deplacement';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-deplacement-new',
  templateUrl: './deplacement-new.component.html',
  styleUrls: ['./deplacement-new.component.scss'],
})
export class DeplacementNewComponent implements OnInit {
  d: Deplacement = new Deplacement();
  constructor(private _deplacemntService: DeplacementService) {}

  ngOnInit(): void {}
  AddDeplacement() {
    this._deplacemntService.AddDeplacement(this.d).subscribe();
  }
}
