import { TestBed, inject } from '@angular/core/testing';

import { OperacionServiceService } from './operacion-service.service';

describe('OperacionServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [OperacionServiceService]
    });
  });

  it('should be created', inject([OperacionServiceService], (service: OperacionServiceService) => {
    expect(service).toBeTruthy();
  }));
});
