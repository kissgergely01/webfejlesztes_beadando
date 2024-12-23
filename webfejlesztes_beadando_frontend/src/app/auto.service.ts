import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Auto {
  id?: number;   // Opcionalis ID, mivel új elem esetén nem kell
  gyarto: string;
  model: string;
  evjarat: number;
  ar: number;
}

@Injectable({
  providedIn: 'root'
})
export class AutoService {
  private baseUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  private getHeaders() {
    return new HttpHeaders({ 'Content-Type': 'application/json'});
  }

  getAllAuto(): Observable<any> {
    return this.http.get(`${this.baseUrl}/autok`, { headers: this.getHeaders() });
  }

  saveAuto(auto: Auto): Observable<Auto> {
    return this.http.post<Auto>(`${this.baseUrl}/saveauto`, auto, { headers: this.getHeaders() });
  }

  updateAuto(auto: Auto): Observable<Auto> {
    return this.http.put<Auto>(`${this.baseUrl}/updateauto`, auto, { headers: this.getHeaders() });
  }

  deleteAuto(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/deleteauto?id=${id}`, { headers: this.getHeaders() });
  }
}
