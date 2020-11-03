import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CustomerListComponent} from './component/customer/customer-list/customer-list.component';
import { HomepageComponent} from './homepage/homepage.component';
import {CustomerDetailComponent} from './component/customer/customer-detail/customer-detail.component';
import {CustomerCreateComponent} from './component/customer/customer-create/customer-create.component';
import {CustomerEditComponent} from './component/customer/customer-edit/customer-edit.component';
import {EmployeeListComponent} from './component/employee/employee-list/employee-list.component';
import {EmployeeCreateComponent} from './component/employee/employee-create/employee-create.component';
import {EmployeeDetailComponent} from './component/employee/employee-detail/employee-detail.component';
import {EmployeeEditComponent} from './component/employee/employee-edit/employee-edit.component';
import {ServiceListComponent} from './component/service/service-list/service-list.component';
import {ServiceCreateComponent} from './component/service/service-create/service-create.component';
import {ServiceDetailComponent} from './component/service/service-detail/service-detail.component';
import {ServiceEditComponent} from './component/service/service-edit/service-edit.component';
import {ContractListComponent} from './component/contract/contract-list/contract-list.component';
import {ContractCreateComponent} from './component/contract/contract-create/contract-create.component';
import {ContractEditComponent} from './component/contract/contract-edit/contract-edit.component';
import {ContractDetailComponent} from './component/contract/contract-detail/contract-detail.component';
import {ContractDetailCreateComponent} from './component/contract-detail/contract-detail-create/contract-detail-create.component';


const routes: Routes = [
  // Home Page
  { path: '', component: HomepageComponent },
  // Customer page
  { path: 'customer', component: CustomerListComponent },
  { path: 'customer/detail/:id', component: CustomerDetailComponent },
  { path: 'customer/create', component: CustomerCreateComponent },
  { path: 'customer/edit/:id', component: CustomerEditComponent },
  // Employee Page
  { path: 'employee', component: EmployeeListComponent },
  { path: 'employee/create', component: EmployeeCreateComponent },
  { path: 'employee/detail/:id', component: EmployeeDetailComponent },
  { path: 'employee/edit/:id', component: EmployeeEditComponent },
  // Service Page
  { path: 'service', component: ServiceListComponent },
  { path: 'service/create', component: ServiceCreateComponent },
  { path: 'service/detail/:id', component: ServiceDetailComponent },
  { path: 'service/edit/:id', component: ServiceEditComponent },
  // Contract Page
  { path: 'contract', component: ContractListComponent},
  { path: 'contract/create', component: ContractCreateComponent},
  { path: 'contract/edit/:id', component: ContractEditComponent},
  { path: 'contract/detail/:id', component: ContractDetailComponent},
  // Contract Detail Page
  { path: 'contract-detail/create', component: ContractDetailCreateComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
