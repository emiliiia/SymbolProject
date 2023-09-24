import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Post} from "../../models/post";
import {Search} from "../../models/search";
import {Router} from "@angular/router";

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css']
})
export class ArticleComponent implements OnInit {
  @Input() post!: Post;
  @Input() postId!: string;

  @Output() onEdit = new EventEmitter<boolean>();

  searchParameter = new Search("createdAt", "DESC", 0,2, {postId:""})

  postImage: string = "assets/images/image";


  constructor(private router: Router) {
  }
  ngOnInit(): void {
    this.searchParameter.searchPattern.postId = this.postId
  }

  onErrorPostImage(event: any) {
    event.target.src = 'assets/imagees/default.jpg';
  }

  public enableEditMode() {
    this.onEdit.emit(true);
  }
}
