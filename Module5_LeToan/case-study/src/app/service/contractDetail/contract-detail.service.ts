import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import {ContractDetail} from '../../interface/ContractDetail';

@Injectable({
  providedIn: 'root'
})
export class ContractDetailService {
  private API_URL = 'http://localhost:8080/contract-detail';
  constructor(private http: HttpClient) { }
  getContractDetailList(count = 20): Observable<ContractDetail[]> {
    return this.http.get<ContractDetail[]>(this.API_URL).pipe(
      map(response => response.filter((contractDetail, i) => i < count))
    );
  }
  createNewContractDetail(contractDetail: Partial<ContractDetail>): Observable<ContractDetail> {
    return this.http.post<ContractDetail>(`${this.API_URL}/create`, contractDetail);
  }
}
