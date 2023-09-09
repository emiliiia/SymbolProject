import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {SafeUrl} from "@angular/platform-browser";
import {HomeComponent} from "./components/home/home.component";
import {ArticlesComponent} from "./components/articles/articles.component";
import {ArticleComponent} from "./components/article/article.component";
import {SupportComponent} from "./components/support/support.component";

export interface FileHandle {
  file: File;
  url: SafeUrl;
}

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'articles', component: ArticlesComponent},
  {path: 'article', component: ArticleComponent},
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
