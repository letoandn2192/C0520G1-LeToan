import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BlogComponent } from './blog/blog.component';
import { BlogDetailComponent } from './blog-detail/blog-detail.component';
import { BlogEditComponent } from './blog-edit/blog-edit.component';


const routes: Routes = [{
  path: 'blog',
  component: BlogComponent
}, {
  path: 'blog/view/:id',
  component: BlogDetailComponent
}, {
  path: 'blog/:id/edit',
  component: BlogEditComponent
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
