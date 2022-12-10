import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CuisineItemsComponent } from './cuisine-items.component';

describe('CuisineItemsComponent', () => {
  let component: CuisineItemsComponent;
  let fixture: ComponentFixture<CuisineItemsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CuisineItemsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CuisineItemsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
