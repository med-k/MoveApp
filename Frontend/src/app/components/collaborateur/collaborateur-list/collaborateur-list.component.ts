import { Collaborateur } from './../../../models/collaborateur';
import { CollaborateurService } from './../../../services/collaborateur.service';
import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-collaborateur-list',
  templateUrl: './collaborateur-list.component.html',
  styleUrls: ['./collaborateur-list.component.scss'],
})
export class CollaborateurListComponent implements OnInit {
  Collaborateurs: Collaborateur[] = [];
  c: Collaborateur = new Collaborateur();

  constructor(private _collaborateurService: CollaborateurService) {}

  ngOnInit(): void {
    this._collaborateurService.GetAllCollaborateur().subscribe(
      (response: Collaborateur[]) => {
        this.Collaborateurs = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  DeleteCollaborateur(c: Collaborateur) {
    this._collaborateurService.DeleteCollaborateur(c).subscribe();
  }
}
