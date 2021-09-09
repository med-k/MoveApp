import { Collaborateur } from '../models/collaborateur';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CollaborateurService {
  private url: string = 'http://localhost:8081/move/backend/collaborateur';
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };

  constructor(private http: HttpClient) {}

  // getAll liste collaborateur
  GetAllCollaborateur(): Observable<Collaborateur[]> {
    return this.http.get<Collaborateur[]>(this.url);
  }
  // get collaborateur by id
  GetCollaborateurById(id: number): Observable<Collaborateur> {
    return this.http.get<Collaborateur>(this.url + '/' + id);
  }
  // post collaborateur
  PostCollaborateur(collaborateur: Collaborateur): Observable<Collaborateur> {
    return this.http.post<Collaborateur>(
      this.url,
      collaborateur,
      this.httpOptions
    );
  }
  // put collaborateur
  PutCollaborateur(
    id: number,
    collaborateur: Collaborateur
  ): Observable<Collaborateur> {
    return this.http.put<Collaborateur>(
      this.url + '/' + id,
      collaborateur,
      this.httpOptions
    );
  }
  // Delete collaborateur
  DeleteCollaborateur(
    objet: Collaborateur | number
  ): Observable<Collaborateur> {
    const id = typeof objet === 'number' ? objet : objet.id;
    return this.http.delete<Collaborateur>(this.url + '/' + id);
  }
}
