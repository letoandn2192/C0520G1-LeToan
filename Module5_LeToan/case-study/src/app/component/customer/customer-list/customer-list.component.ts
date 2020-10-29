import { Component, OnInit } from '@angular/core';
import {Customer} from '../../../interface/Customer';
import {CustomerType} from '../../../interface/CustomerType';
import {CustomerService} from '../../../service/customer/customer.service';
import {CustomerTypeService} from '../../../service/customerType/customer-type.service';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  customerList: Customer[] = [];
  constructor(private customerService: CustomerService) {
  }

  ngOnInit(): void {
    this.customerService.getCustomerList().subscribe(data => (this.customerList = data), error => this.customerList = error);
  }

  deleteCustomer(i: number) {
    // const post = this.postList[i];
    this.customerService.deleteCustomer(i).subscribe(data => {
      console.log('successful!!!');
    }, error => console.log('error'));
  }
}
