import { Component, Input, OnDestroy, OnInit } from '@angular/core';
import {
  interval,
  Observable,
  startWith,
  Subject,
  switchMap,
  timer,
} from 'rxjs';
import { SlideInterface} from "../../directives/slide-interface";
import {Page} from "../../models/pages";
import {Search} from "../../models/search";
import {MatSort, Sort} from "@angular/material/sort";
import {PostService} from "../../services/post.service";
import {Router} from "@angular/router";


@Component({
  selector: 'app-photo-slider',
  templateUrl: './photo-slider.component.html',
  styleUrls: ['./photo-slider.component.css']
})
export class PhotoSliderComponent implements OnInit {
  page: Page = new Page([], 0);
  searchParameter!: Search;
  postImage: string = "assets/images/image";
  keyword = 'name';
  role!:any;
  sort:Sort = new MatSort()


  currentIndex: number = 0;
  timeoutId?: number;

  apply() {
    this.searchParameter.page = 0
    this.search()
  }


  changePage(page: number) {
    this.searchParameter.page = page;
    this.postService.setSearchPostParameter(this.searchParameter)
    this.search()
  }

  setSorted(event: any) {
    this.searchParameter.sortField = event.active
    if (event.direction != "") {
      this.searchParameter.sortDirection = event.direction.toUpperCase()
    }
    this.search()
  }

  getFirst() {
    this.searchParameter.page = 0;
    this.search()
  }

  getLast() {
    if (this.page.totalItem / this.searchParameter.page < 0) {
      this.searchParameter.page = 0;
    } else {
      this.searchParameter.page = Math.floor(this.page.totalItem / this.searchParameter.pageSize);
    }
    this.search()
  }

  constructor(private postService: PostService,
              private router: Router) {
  }

  search() {
    this.postService.getPostPage().subscribe((page: Page) => {
      this.page = page
    });
  }


  ngOnInit() {
    this.resetTimer();
    this.search();
    this.searchParameter = this.postService.getSearchPostParameter();
    this.sort.active = this.searchParameter.sortField;
    this.sort.direction = this.searchParameter.sortDirection.toLowerCase() != "asc"?"desc":"asc";
  }

  ngOnDestroy() {
    window.clearTimeout(this.timeoutId);
  }
  resetTimer() {
    if (this.timeoutId) {
      window.clearTimeout(this.timeoutId);
    }
    this.timeoutId = window.setTimeout(() => this.goToNext(), 3000);
  }

  onErrorPostImage(event: any) {
    event.target.src = 'assets/images/default.png';
  }

  goToPrevious(): void {
    const isFirstSlide = this.currentIndex === 0;
    const newIndex = isFirstSlide
      ? this.page.content.length - 1
      : this.currentIndex - 1;

    this.resetTimer();
    this.currentIndex = newIndex;
  }

  goToNext(): void {
    const isLastSlide = this.currentIndex === this.page.content.length - 1;
    const newIndex = isLastSlide ? 0 : this.currentIndex + 1;

    this.resetTimer();
    this.currentIndex = newIndex;
  }

  goToSlide(slideIndex: number): void {
    this.resetTimer();
    this.currentIndex = slideIndex;
  }

  getCurrentSlideUrl() {
    return `url('./assets/images/image17.jpg')`;
  }

  getCurrentSlideTitle() {
    return this.page.content[this.currentIndex].title;
  }

  getCurrentSlideId() {
    return 1;
  }

  getCurrentSlideDate() {
    return this.page.content[this.currentIndex].publishedAt;
  }
}
/*  @Input() slides: SlideInterface[] = [];
  page: Page = new Page([], 0);
  searchParameter!: Search;
  postImage: string = "assets/images/image";
  keyword = 'name';
  role!:any;
  sort:Sort = new MatSort()

  apply() {
    this.searchParameter.page = 0
    this.search()
  }


  changePage(page: number) {
    this.searchParameter.page = page;
    this.postService.setSearchPostParameter(this.searchParameter)
    this.search()
  }

  setSorted(event: any) {
    this.searchParameter.sortField = event.active
    if (event.direction != "") {
      this.searchParameter.sortDirection = event.direction.toUpperCase()
    }
    this.search()
  }

  getFirst() {
    this.searchParameter.page = 0;
    this.search()
  }

  getLast() {
    if (this.page.totalItem / this.searchParameter.page < 0) {
      this.searchParameter.page = 0;
    } else {
      this.searchParameter.page = Math.floor(this.page.totalItem / this.searchParameter.pageSize);
    }
    this.search()
  }

  constructor(private postService: PostService,
              private router: Router) {
  }

  search() {
    this.postService.getPostPage().subscribe((page: Page) => {
      this.page = page
    });
  }

  onErrorPostImage(event: any) {
    event.target.src = 'assets/images/default.png';
  }

  currentIndex: number = 0;
  timeoutId?: number;

  ngOnInit(): void {
    this.resetTimer();
    this.search();
    this.searchParameter = this.postService.getSearchPostParameter();
    this.sort.active = this.searchParameter.sortField;
    this.sort.direction = this.searchParameter.sortDirection.toLowerCase() != "asc"?"desc":"asc";
  }
  ngOnDestroy() {
    window.clearTimeout(this.timeoutId);
  }
  resetTimer() {
    if (this.timeoutId) {
      window.clearTimeout(this.timeoutId);
    }
    this.timeoutId = window.setTimeout(() => this.goToNext(), 3000);
  }

  goToPrevious(): void {
    const isFirstSlide = this.currentIndex === 0;
    const newIndex = isFirstSlide
      ? this.slides.length - 1
      : this.currentIndex - 1;

    this.resetTimer();
    this.currentIndex = newIndex;
  }

  goToNext(): void {
    const isLastSlide = this.currentIndex === this.slides.length - 1;
    const newIndex = isLastSlide ? 0 : this.currentIndex + 1;

    this.resetTimer();
    this.currentIndex = newIndex;
  }

  goToSlide(slideIndex: number): void {
    this.resetTimer();
    this.currentIndex = slideIndex;
  }

  getCurrentSlideUrl() {
    return `url('${this.slides[this.currentIndex].url}')`;
  }

  getCurrentSlideTitle() {
    return this.slides[this.currentIndex].title;
  }

  getCurrentSlideDate() {
    return this.slides[this.currentIndex].date;
  }
}
*/
