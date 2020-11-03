import { TestBed } from '@angular/core/testing';

import { RentTypeService } from './rent-type.service';

describe('RentTypeService', () => {
  let service: RentTypeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RentTypeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
