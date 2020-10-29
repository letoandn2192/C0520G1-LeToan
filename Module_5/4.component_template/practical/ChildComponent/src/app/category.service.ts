import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import {Category} from './category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  private API_URL = 'http://localhost:8080/categories';
  constructor(private http: HttpClient) { }
  getCategories(count = 20): Observable<Category[]> {
    return this.http.get<Category[]>(this.API_URL).pipe(
      map(response => response.filter((category, i) => i < count))
    );
  }
  getCategoryById(id: number): Observable<Category> {
    return this.http.get<Category>(`${this.API_URL}/view/${id}`);
  }
  createCategory(category: Partial<Category>): Observable<Category> {
    return this.http.post<Category>(this.API_URL, category);
  }
  deleteCategory(id: number): Observable<any> {
    return this.http.delete(`${this.API_URL}/delete/${id}`);
  }
  updateCategory(category: Category): Observable<Category> {
    return this.http.patch<Category>(`${this.API_URL}/edit/${category.categoryId}`, category);
  }
}
