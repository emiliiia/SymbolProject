import {Component, OnInit} from '@angular/core';
import {PostService} from "../../services/post.service";
import {Router} from "@angular/router";
import {Page} from "../../models/pages";
import {MatSort, MatSortDefaultOptions, Sort} from "@angular/material/sort";
import {Search} from "../../models/search";

@Component({
  selector: 'app-article-cards',
  templateUrl: './article-cards.component.html',
  styleUrls: ['./article-cards.component.css']
})
export class ArticleCardsComponent implements OnInit {
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


  ngOnInit() {
    this.search();
    this.searchParameter = this.postService.getSearchPostParameter();
    this.sort.active = this.searchParameter.sortField;
    this.sort.direction = this.searchParameter.sortDirection.toLowerCase() != "asc"?"desc":"asc";
  }

  onErrorPostImage(event: any) {
    event.target.src = 'assets/images/default.png';
  }

}
