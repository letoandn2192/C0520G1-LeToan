import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Post } from './post';

@Injectable({
  providedIn: 'root'
})
export class PostService {
  private API_URL = 'http://localhost:8080/blog';
  constructor(private http: HttpClient) { }
  getPosts(count = 20): Observable<Post[]> {
    return this.http.get<Post[]>(this.API_URL).pipe(
      map(response => response.filter((post, i) => i < count))
    );
  }
  getPostById(id: number): Observable<Post> {
    return this.http.get<Post>(`${this.API_URL}/view/${id}`);
  }
  createPost(post: Partial<Post>): Observable<Post> {
    return this.http.post<Post>(this.API_URL, post);
  }
  deletePost(id: number): Observable<any> {
    return this.http.delete(`${this.API_URL}/delete/${id}`);
  }
  updatePost(post: Post): Observable<Post> {
    return this.http.patch<Post>(`${this.API_URL}/edit/${post.blogId}`, post);
  }
}
