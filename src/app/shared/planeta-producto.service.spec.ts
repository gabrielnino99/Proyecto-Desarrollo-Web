import { TestBed } from '@angular/core/testing';

import { PlanetaProductoService } from './planeta-producto.service';

describe('PlanetaProductoService', () => {
  let service: PlanetaProductoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PlanetaProductoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
