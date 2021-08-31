import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OperacionfuegoComponent } from './operacionfuego.component';

describe('OperacionfuegoComponent', () => {
  let component: OperacionfuegoComponent;
  let fixture: ComponentFixture<OperacionfuegoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OperacionfuegoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OperacionfuegoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
