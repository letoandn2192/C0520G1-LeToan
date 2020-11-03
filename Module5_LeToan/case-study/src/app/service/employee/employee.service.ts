import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Employee } from '../../interface/Employee';
import {Customer} from '../../interface/Customer';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private API_URL = 'http://localhost:8080/employee';
  constructor(private http: HttpClient) { }
  getEmployeeList(count = 20): Observable<Employee[]> {
    return this.http.get<Employee[]>(this.API_URL).pipe(
      map(response => response.filter((employee, i) => i < count))
    );
  }
  getEmployeeById(id: number): Observable<Employee> {
    return this.http.get<Employee>(`${this.API_URL}/detail/${id}`);
  }
  createNewEmployee(employee: Partial<Employee>): Observable<Employee> {
    return this.http.post<Employee>(`${this.API_URL}/create`, employee);
  }
  deleteEmployee(id: number): Observable<any> {
    return this.http.delete(`${this.API_URL}/delete/${id}`);
  }
  updateEmployee(employee: Employee): Observable<Employee> {
    return this.http.patch<Employee>(`${this.API_URL}/edit/${employee.employeeId}`, employee);
  }
}
