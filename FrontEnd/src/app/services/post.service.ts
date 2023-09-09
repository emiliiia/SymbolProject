import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Post} from "../models/post/post";
import {GlobalConstants} from "../global-constants";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private http: HttpClient) { }

  async createPost(postToCreate: Post, image: File) {
    let postData: Post | FormData;
    postData = new Post(postToCreate);
    const id = <string>await this.http.post(GlobalConstants.apiURL + '/posts/create', postData).toPromise();
    const newPath = `PostImage/post_${id}.jpg`;
    postData = new FormData();
    postData.append('id', id);

    let imageData: FormData;
    imageData = new FormData();
    imageData.append('photo', image);
    imageData.append('newPath', newPath);
    await this.http.post(GlobalConstants.apiURL + '/posts/uploadPhoto/', imageData).toPromise();

    return id;
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

    const newPath = `PostImage/post_${postToUpdate.id}.jpg`;
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

}
