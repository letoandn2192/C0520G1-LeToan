import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { ServiceType } from '../../interface/ServiceType';

@Injectable({
  providedIn: 'root'
})
export class ServiceTypeService {
  private API_URL = 'http://localhost:8080/serviceType';
  constructor(private http: HttpClient) { }
  getServiceTypeList(count = 20): Observable<ServiceType[]> {
    return this.http.get<ServiceType[]>(this.API_URL).pipe(
      map(response => response.filter((serviceType, i) => i < count))
    );
  }
}
