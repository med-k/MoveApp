import { Itineraire } from './../models/itineraire';
import { Observable } from 'rxjs';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ItineraireService {
  private url: string = 'http://localhost:8081/move/backend/itineraire';
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };
  constructor(private http: HttpClient) {}

  // get itineraires by deplacement id
  GetAllItineraireByDeplacementId(id: number): Observable<Itineraire[]> {
    return this.http.get<Itineraire[]>(this.url + '/deplacement/' + id);
  }
}
