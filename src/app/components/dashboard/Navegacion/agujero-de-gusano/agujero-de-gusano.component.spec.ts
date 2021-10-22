import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgujeroDeGusanoComponent } from './agujero-de-gusano.component';

describe('AgujeroDeGusanoComponent', () => {
  let component: AgujeroDeGusanoComponent;
  let fixture: ComponentFixture<AgujeroDeGusanoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AgujeroDeGusanoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AgujeroDeGusanoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
