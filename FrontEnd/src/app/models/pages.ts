import {Post} from "./post";

export class Page {
  constructor(content: any[], totalItem:number) {
    this.content = content;
    this.totalItem= totalItem;
  }
  content: any[] = [];
  totalItem:number;
}
