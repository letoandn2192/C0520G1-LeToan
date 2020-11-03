import { TestBed } from '@angular/core/testing';

import { ContractDetailService } from './contract-detail.service';

describe('ContractDetailService', () => {
  let service: ContractDetailService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ContractDetailService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
