import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import {AttachService} from '../../interface/AttachService';

@Injectable({
  providedIn: 'root'
})
export class AttachServiceService {
  private API_URL = 'http://localhost:8080/attachService';
  constructor(private http: HttpClient) { }
  getAttachServiceList(count = 20): Observable<AttachService[]> {
    return this.http.get<AttachService[]>(this.API_URL).pipe(
      map(response => response.filter((attachService, i) => i < count))
    );
  }
}
