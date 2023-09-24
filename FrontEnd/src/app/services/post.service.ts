import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Post} from "../models/post";
import {GlobalConstants} from "../global-constants";
import {map, Observable} from "rxjs";
import {Search} from "../models/search";
import {Page} from "../models/pages";
import {PostList} from "../models/postList";

@Injectable({
  providedIn: 'root'
})
export class PostService {
  searchPostsParameter = new Search("title", "ASC", 0,9,{search:""})
  searchProfileParameter!: Search;

  constructor(private http: HttpClient) { }

  async createPost(postToCreate: Post, image: File) {
    let postData: Post | FormData;
    postData = new Post(postToCreate);
    const id = <string>await this.http.post(GlobalConstants.apiURL + '/posts/create', postData).toPromise();
    const newPath = `images/image${id}.jpg`;
    postData = new FormData();
    postData.append('id', id);

    let imageData: FormData;
    imageData = new FormData();
    imageData.append('photo', image);
    imageData.append('newPath', newPath);
    await this.http.post(GlobalConstants.apiURL + '/posts/uploadPhoto/', imageData).toPromise();

    return id;
  }

  getAllPosts(): Observable<Post[]> {
    return this.http.get<Post[]>(GlobalConstants.apiURL + '/posts/');
  }

  async updatePost(postToUpdate: Post) {
    let postData: Post | FormData;

    postData = new Post(postToUpdate);
    await this.http.put(GlobalConstants.apiURL + '/posts/update/', postData).toPromise();

  }

  async updateWithPhoto(postToUpdate: Post, newImage: File) {
    let postData: Post | FormData;

    postData = new Post(postToUpdate);
    await this.http.put(GlobalConstants.apiURL + '/posts/updateWithPhoto/', postData).toPromise();

    const newPath = `images/image${postToUpdate.id}.jpg`;
    let imageData: FormData;
    imageData = new FormData();
    imageData.append('photo', newImage);
    imageData.append('newPath', newPath);
    await this.http.post(GlobalConstants.apiURL + '/posts/uploadPhoto/', imageData).toPromise();

  }

  getOnePost(id: string): Observable<Post> {
    return this.http.get<Post>(GlobalConstants.apiURL + '/posts/' + id);
  }


  deletePost(id: string) {
    return this.http.delete<Post>(GlobalConstants.apiURL + '/posts/' + id);
  }


  getSearchPostParameter(){
    return this.searchPostsParameter;
  }

  setSearchProfileParameter(searchParameter:Search) {
    this.searchProfileParameter = searchParameter;
  }

  setSearchPostParameter(searchParameter:Search) {
    this.searchPostsParameter = searchParameter;
  }

  getPostPage():Observable<Page> {
    return this.http.post(GlobalConstants.apiURL +'/posts/search', this.searchPostsParameter).pipe(map((data: any) => {
      data.content = data.content.map((post:PostList) => {
        return new PostList(post)
      })
      return new Page(data.content, data.totalItem)
    }));
  }
}
