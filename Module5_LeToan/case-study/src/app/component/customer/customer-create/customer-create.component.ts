import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {CustomerService} from '../../../service/customer/customer.service';
import {CustomerTypeService} from '../../../service/customerType/customer-type.service';
import {CustomerType} from '../../../interface/CustomerType';
import {Router} from '@angular/router';

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {
  customerTypeList: CustomerType[] = [];
  customerForm = new FormGroup(
    {
      customerName: new FormControl(''),
      customerBirthday: new FormControl(''),
      customerGender: new FormControl(''),
      customerIdCard: new FormControl(''),
      customerPhone: new FormControl(''),
      customerEmail: new FormControl(''),
      customerAddress: new FormControl(''),
      customerType: new FormControl('')
    }
  );
  constructor(private customerService: CustomerService, private customerTypeService: CustomerTypeService, private router: Router ) { }

  ngOnInit(): void {
    this.customerTypeService.getCustomerTypeList()
      .subscribe(data => (this.customerTypeList = data), error => this.customerTypeList = error);
  }

  creatNewCustomer() {
    if (this.customerForm.valid) {
      const {value} = this.customerForm;
      this.customerService.createNewCustomer(value)
        .subscribe(data => { this.router.navigate(['/customer']); }, error => console.log('error'));
    }
  }
}
