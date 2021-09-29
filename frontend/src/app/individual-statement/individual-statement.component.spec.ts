import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IndividualStatementComponent } from './individual-statement.component';

describe('IndividualStatementComponent', () => {
  let component: IndividualStatementComponent;
  let fixture: ComponentFixture<IndividualStatementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IndividualStatementComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(IndividualStatementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
