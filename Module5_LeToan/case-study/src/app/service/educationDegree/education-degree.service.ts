import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { EducationDegree } from '../../interface/EducationDegree';
import {Division} from '../../interface/Division';

@Injectable({
  providedIn: 'root'
})
export class EducationDegreeService {
  private API_URL = 'http://localhost:8080/educationDegree';
  constructor(private http: HttpClient) { }
  getEducationDegreeList(count = 20): Observable<EducationDegree[]> {
    return this.http.get<EducationDegree[]>(this.API_URL).pipe(
      map(response => response.filter((educationDegree, i) => i < count))
    );
  }
}
