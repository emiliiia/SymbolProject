import { Component } from '@angular/core';
import {SlideInterface} from "../../directives/slide-interface";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  slides: SlideInterface[] = [
    { url: 'assets/stylePhoto/1.jpg', title: 'Дякую Суспільне Новини за висвітлення діяльності нашого "#TechnoHubBukovyna":))',
    date: Date.now()},
    { url: 'assets/stylePhoto/2.jpg', title: 'boat',
      date: Date.now() },
    { url: 'assets/stylePhoto/3.jpg', title: 'forest',
      date: Date.now() },
    { url: 'assets/stylePhoto/1.jpg', title: 'city',
      date: Date.now() },
    { url: 'assets/stylePhoto/2.jpg', title: 'italy',
      date: Date.now() },
  ];
}
