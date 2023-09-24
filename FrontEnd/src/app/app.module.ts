import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {AppRoutingModule} from './app-routing.module';

import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { HomeComponent } from './components/home/home.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import {NgxPaginationModule} from 'ngx-pagination';
import { PhotoSliderComponent } from './components/photo-slider/photo-slider.component';
import { DirectionsSliderComponent } from './components/directions-slider/directions-slider.component';
import {OwlModule} from "ngx-owl-carousel";
import { ArticleCardsComponent } from './components/article-cards/article-cards.component';
import { ArticlesComponent } from './components/articles/articles.component';
import { SkillsComponent } from './components/skills/skills.component';
import { AboutUsComponent } from './components/about-us/about-us.component';
import { FooterComponent } from './components/footer/footer.component';
import { ArticleComponent } from './components/article/article.component';
import { SupportComponent } from './components/support/support.component';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {MatSortModule} from "@angular/material/sort";
import { ArticleForwardingComponent } from './components/article-forwarding/article-forwarding.component';
import { CreateArticleComponent } from './components/create-article/create-article.component';
import {AngularEditorModule} from "@kolkov/angular-editor";
import { RulesComponent } from './components/rules/rules.component';

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
    ArticleComponent,
    SupportComponent,
    ArticleForwardingComponent,
    CreateArticleComponent,
    RulesComponent,
  ],
    imports: [
        BrowserAnimationsModule,
        BrowserModule,
        AppRoutingModule,
        OwlModule,
        FormsModule,
        HttpClientModule,
        MatSortModule,
        NgxPaginationModule,
        AngularEditorModule,
        // Add this line
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
