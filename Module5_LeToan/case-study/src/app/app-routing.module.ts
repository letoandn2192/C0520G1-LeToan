import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CustomerListComponent} from './component/customer/customer-list/customer-list.component';
import { HomepageComponent} from './homepage/homepage.component';
import {CustomerDetailComponent} from './component/customer/customer-detail/customer-detail.component';
import {CustomerCreateComponent} from './component/customer/customer-create/customer-create.component';


const routes: Routes = [
  {
    path: '',
    component: HomepageComponent
  },
  {
    path: 'customer',
    component: CustomerListComponent
  },
  {
    path: 'customer/detail/:id',
    component: CustomerDetailComponent
  },
  {
    path: 'customer/create',
    component: CustomerCreateComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
