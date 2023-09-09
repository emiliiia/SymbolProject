import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {AppRoutingModule} from './app-routing.module';

import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { HomeComponent } from './components/home/home.component';

import { PhotoSliderComponent } from './components/photo-slider/photo-slider.component';
import { DirectionsSliderComponent } from './components/directions-slider/directions-slider.component';
import {OwlModule} from "ngx-owl-carousel";
import { ArticleCardsComponent } from './components/article-cards/article-cards.component';
import { ArticlesComponent } from './components/articles/articles.component';
import { SkillsComponent } from './components/skills/skills.component';
import { AboutUsComponent } from './components/about-us/about-us.component';
import { FooterComponent } from './components/footer/footer.component';
import { IntroductionSectionComponent } from './components/introduction-section/introduction-section.component';
import { ArticleComponent } from './components/article/article.component';
import { SupportComponent } from './components/support/support.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    PhotoSliderComponent,
    DirectionsSliderComponent,
    ArticleCardsComponent,
    ArticlesComponent,
    SkillsComponent,
    AboutUsComponent,
    FooterComponent,
    IntroductionSectionComponent,
    ArticleComponent,
    SupportComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    OwlModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
