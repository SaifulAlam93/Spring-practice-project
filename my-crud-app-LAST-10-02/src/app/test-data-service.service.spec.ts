import { TestBed } from '@angular/core/testing';

import { TestDataServiceService } from './test-data-service.service';

describe('TestDataServiceService', () => {
  let service: TestDataServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TestDataServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
