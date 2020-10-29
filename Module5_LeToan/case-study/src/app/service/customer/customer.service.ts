import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Customer } from '../../interface/Customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private API_URL = 'http://localhost:8080/customer';
  constructor(private http: HttpClient) { }
  getCustomerList(count = 20): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.API_URL).pipe(
      map(response => response.filter((post, i) => i < count))
    );
  }
  getCustomerById(id: number): Observable<Customer> {
    return this.http.get<Customer>(`${this.API_URL}/detail/${id}`);
  }
  createNewCustomer(customer: Partial<Customer>): Observable<Customer> {
    return this.http.post<Customer>(`${this.API_URL}/create`, customer);
  }
  deleteCustomer(id: number): Observable<any> {
    return this.http.delete(`${this.API_URL}/delete/${id}`);
  }
  updateCustomer(customer: Customer): Observable<Customer> {
    return this.http.patch<Customer>(`${this.API_URL}/edit/${customer.customerId}`, customer);
  }
}
