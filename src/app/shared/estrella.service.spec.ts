import { TestBed } from '@angular/core/testing';

import { EstrellaService } from './estrella.service';

describe('EstrellaService', () => {
  let service: EstrellaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EstrellaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
