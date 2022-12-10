import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateCuisineItemComponent } from './update-cuisine-item.component';

describe('UpdateCuisineItemComponent', () => {
  let component: UpdateCuisineItemComponent;
  let fixture: ComponentFixture<UpdateCuisineItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateCuisineItemComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateCuisineItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
