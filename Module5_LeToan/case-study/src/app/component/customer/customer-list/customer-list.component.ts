import { Component, OnInit } from '@angular/core';
import {Customer} from '../../../interface/Customer';
import {CustomerService} from '../../../service/customer/customer.service';
import { Router} from '@angular/router';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  customerList: Customer[] = [];
  page = 1;
  filter = '';
  key = 'customerId';
  reverse = false;
  constructor(private customerService: CustomerService, private router: Router) {
  }

  ngOnInit(): void {
    this.customerService.getCustomerList().subscribe(data => (this.customerList = data), error => this.customerList = error);
  }

  deleteCustomer(i: number) {
    this.customerService.deleteCustomer(i).subscribe(data => {
      this.router.navigate(['/customer']);
    }, error => console.log('error'));
  }

  sort(key){
    console.log(this.customerList);
    this.key = key;
    this.reverse = !this.reverse;
  }
}
