import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {SafeUrl} from "@angular/platform-browser";
import {HomeComponent} from "./components/home/home.component";
import {ArticlesComponent} from "./components/articles/articles.component";
import {ArticleComponent} from "./components/article/article.component";
import {SupportComponent} from "./components/support/support.component";
import {ArticleForwardingComponent} from "./components/article-forwarding/article-forwarding.component";
import {CreateArticleComponent} from "./components/create-article/create-article.component";
import {RulesComponent} from "./components/rules/rules.component";
import {AboutUsComponent} from "./components/about-us/about-us.component";

export interface FileHandle {
  file: File;
  url: SafeUrl;
}

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'articles', component: ArticlesComponent},
  {path: 'articles/:id', component: ArticleForwardingComponent},
  {path: 'aboutUs', component: AboutUsComponent},
  {path: 'article', component: ArticleComponent},
  {path: 'createArticle', component: CreateArticleComponent},
  {path: 'rules', component: RulesComponent},
  {path: 'support', component: SupportComponent},
  {path: '**', redirectTo: '/404'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {
    anchorScrolling: 'enabled',
    scrollPositionRestoration: 'enabled'
  })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
