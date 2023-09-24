import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArticleForwardingComponent } from './article-forwarding.component';

describe('ArticleForwardingComponent', () => {
  let component: ArticleForwardingComponent;
  let fixture: ComponentFixture<ArticleForwardingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ArticleForwardingComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ArticleForwardingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
