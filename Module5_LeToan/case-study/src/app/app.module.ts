import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomerListComponent } from './component/customer/customer-list/customer-list.component';
import { HeaderComponent } from './header/header.component';
import { HomepageComponent } from './homepage/homepage.component';
import { CustomerDetailComponent } from './component/customer/customer-detail/customer-detail.component';
import { CustomerCreateComponent } from './component/customer/customer-create/customer-create.component';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import { CustomerEditComponent } from './component/customer/customer-edit/customer-edit.component';
import { IdConvert} from './common/id-convert';
import {NgxPaginationModule} from 'ngx-pagination'; // <-- import the module
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { OrderModule } from 'ngx-order-pipe';
import { EmployeeListComponent } from './component/employee/employee-list/employee-list.component';
import { EmployeeCreateComponent } from './component/employee/employee-create/employee-create.component';
import { EmployeeDetailComponent } from './component/employee/employee-detail/employee-detail.component';
import { EmployeeEditComponent } from './component/employee/employee-edit/employee-edit.component';
import { ServiceListComponent } from './component/service/service-list/service-list.component';
import { ServiceCreateComponent } from './component/service/service-create/service-create.component';
import { ServiceDetailComponent } from './component/service/service-detail/service-detail.component';
import { ServiceEditComponent } from './component/service/service-edit/service-edit.component';
import { ContractListComponent } from './component/contract/contract-list/contract-list.component';
import { ContractCreateComponent } from './component/contract/contract-create/contract-create.component';
import { ContractEditComponent } from './component/contract/contract-edit/contract-edit.component';
import { ContractDetailComponent } from './component/contract/contract-detail/contract-detail.component';
import { ContractDetailCreateComponent } from './component/contract-detail/contract-detail-create/contract-detail-create.component';

@NgModule({
  declarations: [
    AppComponent,
    CustomerListComponent,
    HeaderComponent,
    HomepageComponent,
    CustomerDetailComponent,
    CustomerCreateComponent,
    CustomerEditComponent,
    IdConvert,
    EmployeeListComponent,
    EmployeeCreateComponent,
    EmployeeDetailComponent,
    EmployeeEditComponent,
    ServiceListComponent,
    ServiceCreateComponent,
    ServiceDetailComponent,
    ServiceEditComponent,
    ContractListComponent,
    ContractCreateComponent,
    ContractEditComponent,
    ContractDetailComponent,
    ContractDetailCreateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    NgxPaginationModule,
    Ng2SearchPipeModule,
    OrderModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
