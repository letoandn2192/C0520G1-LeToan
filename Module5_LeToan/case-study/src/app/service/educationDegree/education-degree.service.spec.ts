import { TestBed } from '@angular/core/testing';

import { EducationDegreeService } from './education-degree.service';

describe('EducationDegreeService', () => {
  let service: EducationDegreeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EducationDegreeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
