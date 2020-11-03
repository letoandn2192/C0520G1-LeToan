import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
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
  customerCreateForm: FormGroup;
  constructor(private customerService: CustomerService, private customerTypeService: CustomerTypeService,
              private router: Router, private fb: FormBuilder) { }

  ngOnInit(): void {
    this.customerCreateForm = this.fb.group({
      // customerId: '',
      customerName: ['', Validators.required],
      customerBirthday: ['', [Validators.required, Validators.pattern('^(?=\\d{2}([-.,\\/])\\d{2}\\1\\d{4}$)(?:0[1-9]|1\\d|[2][0-8]|29(?!.02.(?!(?!(?:[02468][1-35-79]|[13579][0-13-57-9])00)\\d{2}(?:[02468][048]|[13579][26])))|30(?!.02)|31(?=.(?:0[13578]|10|12))).(?:0[1-9]|1[012]).\\d{4}$') ]],
      customerGender: ['', Validators.required],
      customerIdCard: ['', [Validators.required, Validators.pattern('^((\\d{9})|(\\d{12}))$')]],
      customerPhone: ['', [Validators.required, Validators.pattern('^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)\\d{7}$')]],
      customerEmail: ['', [Validators.required, Validators.pattern('^(\\w{3,}@\\w+\\.\\w+)$')]],
      customerAddress: ['', Validators.required],
      // customerType: { customerTypeId: 1, customerTypeName: 'Diamond'}
      customerType: ''
    });
    this.customerTypeService.getCustomerTypeList()
      .subscribe(data => (this.customerTypeList = data), error => this.customerTypeList = []);
  }

  createNewCustomer() {
    if (this.customerCreateForm.valid) {
      const {value} = this.customerCreateForm;
      console.log(value);
      this.customerService.createNewCustomer(value)
        .subscribe(data => { this.router.navigate(['/customer']); }, error => console.log('error'));
    }
  }
}
