import { CollaborateurService } from './../../../services/collaborateur.service';
import { Collaborateur } from './../../../models/collaborateur';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-collaborateur-update',
  templateUrl: './collaborateur-update.component.html',
  styleUrls: ['./collaborateur-update.component.scss'],
})
export class CollaborateurUpdateComponent implements OnInit {
  c: Collaborateur = new Collaborateur();
  constructor(
    private _collaborateurservice: CollaborateurService,
    private ActivatedRoute: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.ActivatedRoute.paramMap.subscribe((res) =>
      this._collaborateurservice
        .GetCollaborateurById(Number(res.get('id')))
        .subscribe((res) => (this.c = res))
    );
  }
  Update(c: Collaborateur): void {
    this._collaborateurservice
      .PutCollaborateur(c.id, c)
      .subscribe((res) => this.router.navigate(['collaborateur-list']));
  }
}
