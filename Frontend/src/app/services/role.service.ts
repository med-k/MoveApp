import { Role } from './../models/role';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class RoleService {
  private url: string = 'http://localhost:8081/move/backend/role';
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };
  constructor(private http: HttpClient) {}
  //get all role
  GetAllRoles(): Observable<Role[]> {
    return this.http.get<Role[]>(this.url);
  }
  // ajouter role
  AddRole(role: Role): Observable<Role> {
    return this.http.post<Role>(this.url, role, this.httpOptions);
  }
}
