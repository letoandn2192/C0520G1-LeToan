import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Division } from '../../interface/Division';

@Injectable({
  providedIn: 'root'
})
export class DivisionService {
  private API_URL = 'http://localhost:8080/division';
  constructor(private http: HttpClient) { }
  getDivisionList(count = 20): Observable<Division[]> {
    return this.http.get<Division[]>(this.API_URL).pipe(
      map(response => response.filter((division, i) => i < count))
    );
  }
}
