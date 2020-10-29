import { Component, OnInit } from '@angular/core';
import {Customer} from '../../../interface/Customer';
import {CustomerService} from '../../../service/customer/customer.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-customer-detail',
  templateUrl: './customer-detail.component.html',
  styleUrls: ['./customer-detail.component.css']
})
export class CustomerDetailComponent implements OnInit {
  currentCustomer: Customer;
  constructor(private customerService: CustomerService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.customerService.getCustomerById(id)
      .subscribe(data => this.currentCustomer = data, error => { console.log(error); this.currentCustomer = null; });
  }

}
