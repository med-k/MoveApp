import { Deplacement } from './../models/deplacement';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class DeplacementService {
  private url: string = 'http://localhost:8081/move/backend/deplacement';
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };

  constructor(private http: HttpClient) {}

  // getAll liste deplacement
  GetAllDeplacement(): Observable<Deplacement[]> {
    return this.http.get<Deplacement[]>(this.url);
  }

  // ajouter deplacement
  AddDeplacement(deplacement: Deplacement): Observable<Deplacement> {
    return this.http.post<Deplacement>(this.url, deplacement, this.httpOptions);
  }
}
