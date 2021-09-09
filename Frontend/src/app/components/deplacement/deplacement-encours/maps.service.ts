import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

interface Location {
  latitude: number;
  longitude: number;
}
@Injectable({
  providedIn: 'root',
})
export class MapsService {
  constructor(private http: HttpClient) {}
  getLocation() {
    return this.http.get<Location>(
      'api/check?access_key=8cb5d785b0102e53925e6c912d195df0'
    );
  }
}
