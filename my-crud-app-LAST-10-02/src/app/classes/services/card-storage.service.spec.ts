import { TestBed } from '@angular/core/testing';

import { CardStorageService } from './card-storage.service';

describe('CardStorageService', () => {
  let service: CardStorageService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CardStorageService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
