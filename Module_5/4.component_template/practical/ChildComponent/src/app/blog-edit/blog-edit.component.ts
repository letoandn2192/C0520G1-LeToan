import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Post } from '../post';
import { PostService } from '../post.service';
import {Category} from '../category';
import {CategoryService} from '../category.service';

@Component({
  selector: 'app-blog-edit',
  templateUrl: './blog-edit.component.html',
  styleUrls: ['./blog-edit.component.css']
})
export class BlogEditComponent implements OnInit {
  post: Post;
  categoryList: Category[] = [];
  postForm: FormGroup;
  constructor(
    private route: ActivatedRoute,
    private postService: PostService,
    private categoryService: CategoryService,
    private fb: FormBuilder,
    private router: Router
  ) {}

  ngOnInit() {
    this.postForm = this.fb.group({
      blogTitle: ['', [Validators.required, Validators.minLength(10)]],
      blogContent: ['', [Validators.required, Validators.minLength(10)]],
      blogCategory: ['', [Validators.required]],
    });
    this.categoryService
      .getCategories()
      .subscribe(next => (this.categoryList = next), error => (this.categoryList = []));
    const id = +this.route.snapshot.paramMap.get('id');
    this.postService.getPostById(id).subscribe(
      next => {
        this.post = next;
        // console.log(this.post);
        this.postForm.patchValue(this.post);
        // this.postForm.get('blogCategory').patchValue(this.post.blogCategory);
        // console.log(this.postForm);
      },
      error => {
        console.log(error);
        this.post = null;
      }
    );
  }

  onSubmit() {
    if (this.postForm.valid) {
      const { value } = this.postForm;
      const data = {
        ...this.post,
        ...value
      };
      this.postService.updatePost(data).subscribe(
        next => {
          this.router.navigate(['/blog']);
        },
        error => console.log(error)
      );
    }
  }
}
