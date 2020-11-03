import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Position } from '../../interface/Position';

@Injectable({
  providedIn: 'root'
})
export class PositionService {
  private API_URL = 'http://localhost:8080/position';
  constructor(private http: HttpClient) { }
  getPositionList(count = 20): Observable<Position[]> {
    return this.http.get<Position[]>(this.API_URL).pipe(
      map(response => response.filter((position, i) => i < count))
    );
  }
}
