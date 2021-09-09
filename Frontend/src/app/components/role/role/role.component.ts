import { RoleService } from './../../../services/role.service';
import { Role } from './../../../models/role';
import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-role',
  templateUrl: './role.component.html',
  styleUrls: ['./role.component.scss'],
})
export class RoleComponent implements OnInit {
  Roles: Role[] = [];
  constructor(private _roleService: RoleService) {}

  ngOnInit(): void {
    this._roleService.GetAllRoles().subscribe(
      (response: Role[]) => {
        this.Roles = response;
        console.log(this.Roles);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
}
