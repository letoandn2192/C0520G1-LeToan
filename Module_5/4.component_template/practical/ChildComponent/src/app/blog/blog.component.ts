import { Component, OnInit } from '@angular/core';
import { PostService } from '../post.service';
import { CategoryService } from '../category.service';
import { Post } from '../post';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {Category} from '../category';

@Component({
  selector: 'app-blog',
  templateUrl: './blog.component.html',
  styleUrls: ['./blog.component.css']
})
export class BlogComponent implements OnInit {
  postList: Post[] = [];
  categoryList: Category[] = [];
  postForm: FormGroup;
  constructor(
    private postService: PostService,
    private categoryService: CategoryService,
    private fb: FormBuilder
  ) {}

  ngOnInit() {
    this.postForm = this.fb.group({
      blogTitle: ['', [Validators.required, Validators.minLength(10)]],
      blogContent: ['', [Validators.required, Validators.minLength(10)]],
      blogCategory: [null, [Validators.required]],
    });
    this.postService
      .getPosts()
      .subscribe(next => (this.postList = next), error => (this.postList = []));
    this.categoryService
      .getCategories()
      .subscribe(next => (this.categoryList = next), error => (this.categoryList = []));
  }

  onSubmit() {
    if (this.postForm.valid) {
      const {value} = this.postForm;
      this.postService.createPost(value)
        .subscribe(next => {
          // this.postList.unshift(next);
          this.postForm.reset({
            blogTitle: '',
            blogContent: '',
            blogCategory: ''
          });
        }, error => console.log(error));
    }
  }

  deletePost(i) {
    const post = this.postList[i];
    this.postService.deletePost(post.blogId).subscribe(() => {
      this.postList = this.postList.filter(t => t.blogId !== post.blogId);
    });
  }
}
