import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddCuisineItemComponent } from './add-cuisine-item.component';

describe('AddCuisineItemComponent', () => {
  let component: AddCuisineItemComponent;
  let fixture: ComponentFixture<AddCuisineItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddCuisineItemComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddCuisineItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
