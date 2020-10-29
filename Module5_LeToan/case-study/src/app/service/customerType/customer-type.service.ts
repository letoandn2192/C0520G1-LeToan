import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { CustomerType } from '../../interface/CustomerType';
import {Customer} from '../../interface/Customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerTypeService {
  private API_URL = 'http://localhost:8080/customerType';
  constructor(private http: HttpClient) { }
  getCustomerTypeList(count = 20): Observable<CustomerType[]> {
    return this.http.get<CustomerType[]>(this.API_URL).pipe(
      map(response => response.filter((post, i) => i < count))
    );
  }
}
