import { TestBed } from '@angular/core/testing';

import { AgujeroDeGusanoEstrellaService } from './agujero-de-gusano-estrella.service';

describe('AgujeroDeGusanoEstrellaService', () => {
  let service: AgujeroDeGusanoEstrellaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AgujeroDeGusanoEstrellaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
