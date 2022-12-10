import { TestBed } from '@angular/core/testing';

import { CuisineDetailsService } from './cuisine-details.service';

describe('CuisineDetailsService', () => {
  let service: CuisineDetailsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CuisineDetailsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
