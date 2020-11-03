import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Service } from '../../interface/Service';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  private API_URL = 'http://localhost:8080/service';
  constructor(private http: HttpClient) { }
  getServiceList(count = 20): Observable<Service[]> {
    return this.http.get<Service[]>(this.API_URL).pipe(
      map(response => response.filter((service, i) => i < count))
    );
  }
  getServiceById(id: number): Observable<Service> {
    return this.http.get<Service>(`${this.API_URL}/detail/${id}`);
  }
  createNewService(service: Partial<Service>): Observable<Service> {
    return this.http.post<Service>(`${this.API_URL}/create`, service);
  }
  deleteService(id: number): Observable<any> {
    return this.http.delete(`${this.API_URL}/delete/${id}`);
  }
  updateService(service: Service): Observable<Service> {
    return this.http.patch<Service>(`${this.API_URL}/edit/${service.serviceId}`, service);
  }
}
