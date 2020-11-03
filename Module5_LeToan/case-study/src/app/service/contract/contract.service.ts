import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import {Contract} from '../../interface/Contract';

@Injectable({
  providedIn: 'root'
})
export class ContractService {
  private API_URL = 'http://localhost:8080/contract';
  constructor(private http: HttpClient) { }
  getContractList(count = 20): Observable<Contract[]> {
    return this.http.get<Contract[]>(this.API_URL).pipe(
      map(response => response.filter((contract, i) => i < count))
    );
  }
  getContractById(id: number): Observable<Contract> {
    return this.http.get<Contract>(`${this.API_URL}/detail/${id}`);
  }
  createNewContract(contract: Partial<Contract>): Observable<Contract> {
    return this.http.post<Contract>(`${this.API_URL}/create`, contract);
  }
  deleteContract(id: number): Observable<any> {
    return this.http.delete(`${this.API_URL}/delete/${id}`);
  }
  updateContract(contract: Contract): Observable<Contract> {
    return this.http.patch<Contract>(`${this.API_URL}/edit/${contract.contractId}`, contract);
  }
}
