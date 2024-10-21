import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrearFaenaComponent } from './crear-faena.component';

describe('CrearFaenaComponent', () => {
  let component: CrearFaenaComponent;
  let fixture: ComponentFixture<CrearFaenaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CrearFaenaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CrearFaenaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
