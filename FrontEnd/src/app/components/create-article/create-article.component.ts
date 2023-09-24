import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Post} from "../../models/post";
import {PostService} from "../../services/post.service";
import {Router} from "@angular/router";
import {FileHandle} from "../../app-routing.module";
import {AngularEditorConfig} from "@kolkov/angular-editor";

@Component({
  selector: 'app-create-article',
  templateUrl: './create-article.component.html',
  styleUrls: ['./create-article.component.css']
})
export class CreateArticleComponent implements OnInit {
  @Input() post: Post = new Post();
  image!: File;
  @Input() mode: string = "CREATE";
  @Input() postId: string = "";
  previewImg = "assets/images/image";
  constructor(private postService: PostService,
              private router: Router) { }

  ngOnInit(): void {
  }

  config: AngularEditorConfig = {
    editable: true,
    spellcheck: true,
    height: '15rem',
    minHeight: '5rem',
    placeholder: 'Введіть текст тут...',
    translate: 'yes',
    defaultParagraphSeparator: 'p',
    defaultFontName: 'Arial',
    toolbarHiddenButtons: [
      ['bold']
    ],
    customClasses: [
      {
        name: "quote",
        class: "quote",
      },
      {
        name: 'redText',
        class: 'redText'
      },
      {
        name: "titleText",
        class: "titleText",
        tag: "h1",
      },
    ]
  };
  @Input()
  uploadedFiles: FileHandle[] | undefined;
  titleMaxNumberOfCharacters = 80;
  forewordMaxNumberOfCharacters = 150;

  titleNumberOfCharacters = 0;
  forewordNumberOfCharacters = 0;

  counter = true;

  interaction = {
    textValue: '',
    inputValue: ''
  };

  titleInput(event: any): void {
    this.titleNumberOfCharacters = event.target.value.length;

    if (this.titleNumberOfCharacters > this.titleMaxNumberOfCharacters) {
      event.target.value = event.target.value.slice(0, this.titleMaxNumberOfCharacters);
      this.titleNumberOfCharacters = this.titleMaxNumberOfCharacters;
    }
  }

  forewordInput(event: any): void {
    this.forewordNumberOfCharacters = event.target.value.length;

    if (this.forewordNumberOfCharacters > this.forewordMaxNumberOfCharacters) {
      event.target.value = event.target.value.slice(0, this.forewordMaxNumberOfCharacters);
      this.forewordNumberOfCharacters = this.forewordMaxNumberOfCharacters;
    }
  }
  /*****************************************/
  toogleBool: boolean=true;

  changeEvent(event: any): void {
    this.toogleBool = !event.target.checked;
  }

  public previewImage() {
    if (this.mode === 'CREATE') {
      const fileReader = new FileReader();
      const file = (<HTMLInputElement>document.getElementById("uploadPhoto")).files![0];
      this.image = file;
      fileReader.readAsDataURL(file);
      fileReader.onload = function (fileReaderEvent) {
        (<HTMLImageElement>document.getElementById("previewImg")).src = fileReaderEvent.target?.result as string;
      }
    }
    if(this.mode === 'UPDATE'){
      const fileReader = new FileReader();
      const file = (<HTMLInputElement>document.getElementById("uploadPhoto")).files![0];
      this.image = file;
      fileReader.readAsDataURL(file);
      fileReader.onload = function (fileReaderEvent) {
        (<HTMLImageElement>document.getElementById("previewImg")).src = fileReaderEvent.target?.result as string;
      }
    }
  }

  onSave() {
    if (this.mode === 'CREATE') {
      this.postService.createPost(this.post, this.image).then((id: any) => {
        this.router.navigate([`/articles/${id}`]);
      })
    } else if (this.mode === 'UPDATE') {
      if(this.image == null){
        this.postService.updatePost(this.post).then(() => {
        })
      }
      else{
        this.postService.updateWithPhoto(this.post, this.image).then(() => {
        })
      }

      this.returnToInfo();
    }
  }

  exit() {
    if (this.mode === 'UPDATE') {
      this.returnToInfo();
    }
    else if (this.mode === 'CREATE') {
      this.router.navigate(['/articles']);
    }
  }

  @Output() onInfo = new EventEmitter<boolean>();

  public returnToInfo() {
    this.router.navigate(['/articles']);
  }
}
