import { TestBed } from '@angular/core/testing';

import { NaveProductoService } from './nave-producto.service';

describe('NaveProductoService', () => {
  let service: NaveProductoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NaveProductoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
