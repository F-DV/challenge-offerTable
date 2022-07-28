import { TestBed } from '@angular/core/testing';

import { CharacteristicsServiceService } from './characteristics-service.service';

describe('CharacteristicsServiceService', () => {
  let service: CharacteristicsServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CharacteristicsServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
