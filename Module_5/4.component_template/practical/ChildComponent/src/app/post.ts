import {Category} from './category';

export interface Post {
  blogId: number;
  blogTitle: string;
  blogContent: string;
  blogCreateDate: string;
  blogCreateTime: string;
  blogCategory: Category;
}
