import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { RentType } from '../../interface/RentType';

@Injectable({
  providedIn: 'root'
})
export class RentTypeService {
  private API_URL = 'http://localhost:8080/rentType';
  constructor(private http: HttpClient) { }
  getRentTypeList(count = 20): Observable<RentType[]> {
    return this.http.get<RentType[]>(this.API_URL).pipe(
      map(response => response.filter((rentType, i) => i < count))
    );
  }
}
